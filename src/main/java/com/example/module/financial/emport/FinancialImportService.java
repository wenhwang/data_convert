package com.example.module.financial.emport;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.module.HelperService;
import com.example.module.financial.FinancialMapper;
import com.example.module.financial.model.FinanceAdjustment;
import com.example.module.financial.model.FinanceBusinessLicense;
import com.example.module.financial.model.FinanceCapitalAccount;
import com.example.module.financial.model.FinanceDrawMoney;
import com.example.module.financial.model.FinanceOpenInvoice;
import com.example.module.financial.model.FinancePayment;
import com.example.module.financial.model.FinanceReceivables;
import com.example.module.financial.model.FinanceReceiveInvoice;
import com.example.module.financial.model.FinanceReimbursement;
import com.example.module.financial.model.FinanceRepayment;
import com.example.module.financial.model.FinanceReserveFund;
import com.example.module.financial.model.MapCommodity;
import com.example.module.financial.model.MapCostList;
import com.example.module.financial.model.MapHandover;
import com.example.module.financial.model.MapInvoice;
import com.example.module.financial.model.MapOpenCommodity;
import com.example.module.financial.model.MapOpenInvoice;
import com.example.module.financial.model.MapPayTax;
import com.example.utils.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FinancialImportService {
    public static final String SAVE_PATH = new File("files/emport/financial/").getPath();
    public static final String FILE_EXT = ".xlsx";

    @Resource
    private FinancialMapper financialMapper;

    @Autowired
    private HelperService helperService;

    @Autowired
    private MongoTemplate mongoTemplate;

    //报销单
    public static final String TABEL_FINANCE_REIMBURSEMENT = "finance_reimbursement";
    //还款单
    public static final String TABEL_FINANCE_REPAYMENT = "finance_repayment";
    //备用金
    public static final String TABEL_FINANCE_RESERVE_FUND = "finance_reserve_fund";
    //资金账号
    public static final String TABEL_FINANCE_CAPITAL_ACCOUNT = "finance_capital_account";
    //外经证
    public static final String TABEL_FINANCE_BUSINESS_LICENSE = "finance_business_license";
    //收票
    public static final String TABEL_FINANCE_RECEIVE_INVOICE = "finance_receive_invoice";
    //开票
    public static final String TABEL_FINANCE_OPEN_INVOICE = "finance_open_invoice";
    //收款
    public static final String TABEL_FINANCE_RECEIVABLES = "finance_receivables";
    //往来管理（调整单）
    public static final String TABEL_FINANCE_ADJUSTMENT = "finance_adjustment";
    //划款（扣款）
    public static final String TABEL_FINANCE_DRAW_MONEY = "finance_draw_money";
    //付款
    public static final String TABEL_FINANCE_PAYMENT = "finance_payment";


    //报销单
    public List<FinanceReimbursement> expenseHandler() {
        log.info("|------------------------------------------------------------------------|");
        log.info("|__ begin import 报销单明细 ");

        //settlement_way
        List<Map> ways = helperService.query("label", "结算方式", new String[]{"dictId", "dictName"}, "sys_dict");
        //cost_type
        List<Map> costTypes = helperService.query("label", "费用类别", new String[]{"dictId", "dictName"}, "sys_dict");

        List<MapCostList> costLists = new ArrayList<>();

        log.info("|__ 1. 报销单明细");
        ExcelUtils.read(SAVE_PATH + "/1.1 报销单明细.xlsx", MapCostList.class, new AnalysisEventListener<MapCostList>() {
            @Override
            public void invoke(MapCostList data, AnalysisContext context) {
                data.setCostTypeId(HelperService.replaceRefId(data.getCostTypeName(), costTypes));
                costLists.add(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }
        });

        Map<String, List<MapCostList>> entries = costLists
                                                .stream()
                                                .collect(Collectors.groupingBy(MapCostList::getReimbursementId));
        log.info("|__ import {} record data and has {} group record",costLists.size(),entries.size());

        log.info("|__ 2. 报销单");
        List<FinanceReimbursement> reimbursements = new ArrayList<>();
        ExcelUtils.read(SAVE_PATH + "/1 报销单.xlsx", FinanceReimbursement.class, new AnalysisEventListener<FinanceReimbursement>() {
            @Override
            public void invoke(FinanceReimbursement data, AnalysisContext context) {

                //结算方式
                String settlementWay = data.getSettlementWay();
                if (StringUtils.isNotBlank(settlementWay)) {
                    data.setSettlementWayId(HelperService.replaceRefId(settlementWay, ways));
                }

                String reimbursementId = data.getReimbursementId();
                if(!entries.containsKey(reimbursementId)){
                    log.warn("|__ {} no found detail data",data.getSysNumber() );
                   return;
                }
                data.setCostList(entries.get(reimbursementId));
                reimbursements.add(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }

        });
        log.info("|__ import {} record data",reimbursements.size());

        if (!Objects.isNull(reimbursements)) {
            mongoTemplate.insert(reimbursements, TABEL_FINANCE_REIMBURSEMENT);
            log.info("|__ save to {} ", TABEL_FINANCE_REIMBURSEMENT);
        }
        log.info("|------------------------------------------------------------------------|");
        return reimbursements;
    }


    //还款单
    @Transactional
    public List<FinanceRepayment> repaymentHandler() {
        log.info("|------------------------------------------------------------------------|");
        log.info("|__ begin import 还款单 ");
        List<FinanceRepayment> financeRepayments = new ArrayList<>();
        ExcelUtils.read(SAVE_PATH + "/2 还款单.xlsx", FinanceRepayment.class, new AnalysisEventListener<FinanceRepayment>() {
            @Override
            public void invoke(FinanceRepayment data, AnalysisContext context) {
                financeRepayments.add(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }

        });
        log.info("|__ import {} record data",financeRepayments.size());

        if (!Objects.isNull(financeRepayments)) {
            mongoTemplate.insert(financeRepayments, TABEL_FINANCE_REPAYMENT);
            log.info("|__ save to {} ", TABEL_FINANCE_REPAYMENT);
        }
        log.info("|------------------------------------------------------------------------|");
        return financeRepayments;
    }

    //备用金（借款）
    @Transactional
    public List<FinanceReserveFund> reserveFundHandler() {
        List<FinanceReserveFund> reserveFunds = new ArrayList<>();;
        log.info("|------------------------------------------------------------------------|");
        log.info("|__ begin import 备用金（借款） ");
        ExcelUtils.read(SAVE_PATH + "/3 备用金（借款）.xlsx", FinanceReserveFund.class, new AnalysisEventListener<FinanceReserveFund>() {
            @Override
            public void invoke(FinanceReserveFund data, AnalysisContext context) {
                reserveFunds.add(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }

        });
        log.info("|__ import {} record data",reserveFunds.size());

        if (!Objects.isNull(reserveFunds)) {
            mongoTemplate.insert(reserveFunds, TABEL_FINANCE_RESERVE_FUND);
            log.info("|__ save to {} ", TABEL_FINANCE_RESERVE_FUND);
        }
        log.info("|------------------------------------------------------------------------|");
        return reserveFunds;
    }

    //资金账号
    @Transactional
    public List<FinanceCapitalAccount> capitalAccountHandler() {
        log.info("|------------------------------------------------------------------------|");
        log.info("|__ begin import 资金账号 ");
        //account_money_type
        List<Map> accountMoneyTypes = helperService.query("label", "帐户资金类型", new String[]{"dictId", "dictName"}, "sys_dict");
        //bank_account_type
        List<Map> bankAccountTypes = helperService.query("label", "银行帐户类型", new String[]{"dictId", "dictName"}, "sys_dict");
        List<FinanceCapitalAccount> capitalAccounts = new ArrayList<>();

        ExcelUtils.read(SAVE_PATH + "/4 资金账号.xlsx", FinanceCapitalAccount.class, new AnalysisEventListener<FinanceCapitalAccount>() {
            @Override
            public void invoke(FinanceCapitalAccount data, AnalysisContext context) {
                //账户资金类型
                String bankAccountType = data.getBankAccountType();
                if (StringUtils.isNotBlank(bankAccountType)) {
                    data.setBankAccountTypeId(HelperService.replaceRefId(bankAccountType, bankAccountTypes));
                }

                //银行账户类型
                String accountMoneyType = data.getAccountType();
                if (StringUtils.isNotBlank(accountMoneyType)) {
                    data.setAccountTypeId(HelperService.replaceRefId(accountMoneyType, accountMoneyTypes));
                }
                capitalAccounts.add(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }

        });
        log.info("|__ import {} record data",capitalAccounts.size());

        if (!Objects.isNull(capitalAccounts)) {
            mongoTemplate.insert(capitalAccounts, TABEL_FINANCE_CAPITAL_ACCOUNT);
            log.info("|__ save to {} ", TABEL_FINANCE_CAPITAL_ACCOUNT);
        }
        log.info("|------------------------------------------------------------------------|");
        return capitalAccounts;
    }

    //外经证
    @Transactional
    public List<FinanceBusinessLicense> businessLicenseHandler() {

        log.info("|------------------------------------------------------------------------|");
        log.info("|__ begin import 外经证 ");

        //外经证完税信息
        List<MapPayTax> payTaxes = new ArrayList<>();
        ExcelUtils.read(SAVE_PATH + "/5.2 外经证完税信息.xlsx", MapPayTax.class, new AnalysisEventListener<MapPayTax>() {
            @Override
            public void invoke(MapPayTax data, AnalysisContext context) {
                payTaxes.add(data);
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }
        });
        Map<String, List<MapPayTax>> payTaxeGroups = payTaxes
                .stream()
                .collect(Collectors.groupingBy(MapPayTax::getBusinessLicenseId));
        log.info("|__ import  payTaxes {} record data and has {} group record",payTaxes.size(),payTaxeGroups.size());

        //外经证交接信息
        List<MapHandover> handovers = new ArrayList<>();
        ExcelUtils.read(SAVE_PATH + "/5.1 外经证交接信息.xlsx", MapHandover.class, new AnalysisEventListener<MapHandover>() {
            @Override
            public void invoke(MapHandover data, AnalysisContext context) {
                handovers.add(data);
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }
        });
        Map<String, List<MapHandover>> handoverGroups = handovers
                .stream()
                .collect(Collectors.groupingBy(MapHandover::getBusinessLicenseId));
        log.info("|__ import handovers {} record data and has {} group record",handovers.size(),handoverGroups.size());



        //外经证信息
        List<FinanceBusinessLicense> businessLicenses = new ArrayList<>();
        ExcelUtils.read(SAVE_PATH + "/5 外经证.xlsx", FinanceBusinessLicense.class, new AnalysisEventListener<FinanceBusinessLicense>() {
            @Override
            public void invoke(FinanceBusinessLicense data, AnalysisContext context) {

                String businessLicenseId = data.getBusinessLicenseId();
                if(!payTaxeGroups.containsKey(businessLicenseId)){
                    log.warn("|__ payTaxes: {} no found detail data",data.getSysNumber() );
                }else
                    data.setPayTaxMap(payTaxeGroups.get(businessLicenseId));

                if(!handoverGroups.containsKey(businessLicenseId)){
                    log.warn("|__ handovers: {} no found detail data",data.getSysNumber() );
                }else
                    data.setHandoverMap(handoverGroups.get(businessLicenseId));

                businessLicenses.add(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }

        });

        log.info("|__ import {} record data",businessLicenses.size());

        if (!Objects.isNull(businessLicenses)) {
            mongoTemplate.insert(businessLicenses, TABEL_FINANCE_BUSINESS_LICENSE);
            log.info("|__ save to {} ", TABEL_FINANCE_BUSINESS_LICENSE);
        }
        log.info("|------------------------------------------------------------------------|");
        return businessLicenses;
    }

    //收票
    public List<FinanceReceiveInvoice> receiveInvoiceHandler() {
        log.info("|------------------------------------------------------------------------|");
        log.info("|__ begin import 收票 ");
        log.info("|__ 1. 收票明细");
        List<MapInvoice> invoices = new ArrayList<>();
        ExcelUtils.read(SAVE_PATH + "/6.1 收票 - 发票明细.xlsx", MapInvoice.class, new AnalysisEventListener<MapInvoice>() {
            @Override
            public void invoke(MapInvoice data, AnalysisContext context) {
                invoices.add(data);
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }
        });


        log.info("|__ 2. 商品明细");
        List<MapCommodity> commodities = new ArrayList<>();
        ExcelUtils.read(SAVE_PATH + "/6.2 收票 - 商品明细.xlsx", MapCommodity.class, new AnalysisEventListener<MapCommodity>() {
            @Override
            public void invoke(MapCommodity data, AnalysisContext context) {
                commodities.add(data);
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }
        });
        Map<String, List<MapCommodity>> prodsGroupMaps = commodities
                .stream()
                .collect(Collectors.groupingBy(MapCommodity::getReceiveInvoiceDetailId));
        log.info("|__ import  Commodity {} record data and has {} group record",commodities.size(),prodsGroupMaps.size());


        //收票明细商品
        invoices.parallelStream().forEach(mapInvoice -> {
            String receiveInvoiceId = mapInvoice.getReceiveInvoiceId();
            if(!prodsGroupMaps.containsKey(receiveInvoiceId)){
                log.warn("|__ invoice Number: {} no found detail data",mapInvoice.getInvoiceNumber());
                return;
            }
            mapInvoice.setCommodityList(prodsGroupMaps.get(receiveInvoiceId));
        });

        Map<String, List<MapInvoice>> invoiceGroupMaps = invoices
                .stream()
                .collect(Collectors.groupingBy(MapInvoice::getReceiveInvoiceId));
        log.info("|__ import  Invoice {} record data and has {} group record",invoices.size(),invoiceGroupMaps.size());



        log.info("|__ 3. 收票信息");
        List<FinanceReceiveInvoice> receiveInvoices = new ArrayList<>();
        ExcelUtils.read(SAVE_PATH + "/6 收票.xlsx", FinanceReceiveInvoice.class, new AnalysisEventListener<FinanceReceiveInvoice>() {
            @Override
            public void invoke(FinanceReceiveInvoice data, AnalysisContext context) {

                String receiveInvoiceId = data.getReceiveInvoiceId();
                if(!invoiceGroupMaps.containsKey(receiveInvoiceId)){
                    log.warn("|__ invoices: {} no found detail data",data.getSysNumber() );
                }else
                    data.setInvoiceList(invoiceGroupMaps.get(receiveInvoiceId));

                receiveInvoices.add(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }

        });

        log.info("|__ import {} record data",receiveInvoices.size());

        if (!Objects.isNull(receiveInvoices)) {
            mongoTemplate.insert(receiveInvoices, TABEL_FINANCE_RECEIVE_INVOICE);
            log.info("|__ save to {} ", TABEL_FINANCE_RECEIVE_INVOICE);
        }
        log.info("|------------------------------------------------------------------------|");
        return receiveInvoices;
    }

    //开票
    public List<FinanceOpenInvoice> openInvoiceHandler() {
        log.info("|------------------------------------------------------------------------|");
        log.info("|__ begin import 开票 ");

        log.info("|__ 1. 开票明细");
        List<MapOpenInvoice> openInvoiceDetails = new ArrayList<>();
        ExcelUtils.read(SAVE_PATH + "/7.2 开票 - 发票明细.xlsx", MapOpenInvoice.class, new AnalysisEventListener<MapOpenInvoice>() {
            @Override
            public void invoke(MapOpenInvoice data, AnalysisContext context) {
                openInvoiceDetails.add(data);
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }
        });


        log.info("|__ 2. 商品明细");
        List<MapOpenCommodity> openCommodities = new ArrayList<>();
        ExcelUtils.read(SAVE_PATH + "/7.1 开票 - 商品明细.xlsx", MapOpenCommodity.class, new AnalysisEventListener<MapOpenCommodity>() {
            @Override
            public void invoke(MapOpenCommodity data, AnalysisContext context) {
                openCommodities.add(data);
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }
        });
        Map<String, List<MapOpenCommodity>> prodsGroupMaps = openCommodities
                .stream()
                .collect(Collectors.groupingBy(MapOpenCommodity::getOpenInvoiceDetailId));
        log.info("|__ import Open Commodity {} record data and has {} group record",openCommodities.size(),prodsGroupMaps.size());

        //开票商品明细
        openInvoiceDetails.parallelStream().forEach(mapOpenInvoice -> {
            String openInvoiceDetailId = mapOpenInvoice.getOpenInvoiceDetailId();
            if(!prodsGroupMaps.containsKey(openInvoiceDetailId)){
                log.warn("|__ open invoice Number: {} no found detail data",mapOpenInvoice.getInvoiceNumber());
                return;
            }
            mapOpenInvoice.setCommodityList(prodsGroupMaps.get(openInvoiceDetailId));
        });


        Map<String, List<MapOpenInvoice>> invoiceGroupMaps = openInvoiceDetails
                .stream()
                .collect(Collectors.groupingBy(MapOpenInvoice::getOpenInvoiceId));
        log.info("|__ import Open Invoice {} record data and has {} group record",openInvoiceDetails.size(),invoiceGroupMaps.size());


        log.info("|__ 3. 开票信息");
        List<FinanceOpenInvoice> openInvoices =  new ArrayList<>();
        ExcelUtils.read(SAVE_PATH + "/7 开票.xlsx", FinanceOpenInvoice.class, new AnalysisEventListener<FinanceOpenInvoice>() {
            @Override
            public void invoke(FinanceOpenInvoice data, AnalysisContext context) {

                String openInvoiceId = data.getOpenInvoiceId();
                if(!invoiceGroupMaps.containsKey(openInvoiceId)){
                    log.warn("|__ open invoices: {} no found detail data",data.getSysNumber() );
                }else
                    data.setInvoiceList(invoiceGroupMaps.get(openInvoiceId));
                openInvoices.add(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }
        });

        log.info("|__ import {} record data",openInvoices.size());

        if (!Objects.isNull(openInvoices)) {
            mongoTemplate.insert(openInvoices, TABEL_FINANCE_OPEN_INVOICE);
            log.info("|__ save to {} ", TABEL_FINANCE_OPEN_INVOICE);
        }
        log.info("|------------------------------------------------------------------------|");
        return openInvoices;
    }


    //付款
    public List<FinancePayment> paymentHandler() {
        List<FinancePayment> results = new ArrayList<>();
        //查询所有的付款类型
        String[] types = new String[]{"资金转换类-收款-款项类型",//trans_payment_in_type
                "筹资类-收款-款项类型",//financing_payment_in_type
                "投资类-收款-款项类型",//invest_payment_in_type
                "经营类-收款-款项类型"};//manage_payment_in_type
        Criteria criteria = Criteria.where("label").in(types).and("isEnable").is("0").and("delFlag").is("0");
        Query query = Query.query(criteria);
        query.fields().include("dictId").include("dictName").exclude("_id");
        List<Map> typeMapList = mongoTemplate.find(query, Map.class, "sys_dict");

        log.info("|------------------------------------------------------------------------|");
        log.info("|__ begin import 付款 ");

        log.info("|__ 1. 付款申请（付款单）");
        List<FinancePayment> payments_1 = new ArrayList<>();
        ExcelUtils.read(SAVE_PATH + "/8 付款申请（付款单）.xlsx", FinancePayment.class, new AnalysisEventListener<FinancePayment>() {
            @Override
            public void invoke(FinancePayment data, AnalysisContext context) {
                data.setMoneyTypeId(HelperService.replaceRefId(data.getMoneyTypeId(), typeMapList));
                payments_1.add(data);
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }
        });

        if (Objects.nonNull(payments_1)) {
            mongoTemplate.insert(payments_1, TABEL_FINANCE_PAYMENT);
            log.info("|__ save to {} ", TABEL_FINANCE_PAYMENT);
            results.addAll(payments_1);
        }

        log.info("|__ 2. 保证金付款");
        List<FinancePayment> payments_2 = new ArrayList<>();
        ExcelUtils.read(SAVE_PATH + "/9 保证金付款.xlsx", FinancePayment.class, new AnalysisEventListener<FinancePayment>() {
            @Override
            public void invoke(FinancePayment data, AnalysisContext context) {
                data.setMoneyTypeId(HelperService.replaceRefId(data.getMoneyTypeId(), typeMapList));
                payments_2.add(data);
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }
        });

        if (Objects.nonNull(payments_2)) {
            mongoTemplate.insert(payments_2, TABEL_FINANCE_PAYMENT);
            log.info("|__ save to {} ", TABEL_FINANCE_PAYMENT);
            results.addAll(payments_2);
        }

        log.info("|__ 3. 项目付款申请");
        List<FinancePayment> payments_3 = new ArrayList<>();
        ExcelUtils.read(SAVE_PATH + "/10 项目付款申请.xlsx", FinancePayment.class, new AnalysisEventListener<FinancePayment>() {
            @Override
            public void invoke(FinancePayment data, AnalysisContext context) {
                data.setMoneyTypeId(HelperService.replaceRefId(data.getMoneyTypeId(), typeMapList));
                payments_3.add(data);
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }
        });

        if (Objects.nonNull(payments_3)) {
            mongoTemplate.insert(payments_3, TABEL_FINANCE_PAYMENT);
            log.info("|__ save to {} ", TABEL_FINANCE_PAYMENT);
            results.addAll(payments_3);
        }

        log.info("|__ 4. 采购付款申请");
        List<FinancePayment> payments_4 = new ArrayList<>();
        ExcelUtils.read(SAVE_PATH + "/11 采购付款申请.xlsx", FinancePayment.class, new AnalysisEventListener<FinancePayment>() {
            @Override
            public void invoke(FinancePayment data, AnalysisContext context) {
                data.setMoneyTypeId(HelperService.replaceRefId(data.getMoneyTypeId(), typeMapList));
                payments_4.add(data);
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }
        });

        if (Objects.nonNull(payments_4)) {
            mongoTemplate.insert(payments_4, TABEL_FINANCE_PAYMENT);
            log.info("|__ save to {} ", TABEL_FINANCE_PAYMENT);
            results.addAll(payments_4);
        }
        log.info("|------------------------------------------------------------------------|");
        return results;
    }

    //收款
    public List<FinanceReceivables> receivablesHandler() {

        log.info("|------------------------------------------------------------------------|");
        log.info("|__ begin import 收款 ");
        //查询所有的收款类型
        String[] types = new String[]{"资金转换类-收款-款项类型",//trans_payment_in_type
                "筹资类-收款-款项类型",//financing_payment_in_type
                "投资类-收款-款项类型",//invest_payment_in_type
                "经营类-收款-款项类型"};//manage_payment_in_type
        Criteria criteria = Criteria.where("label").in(types).and("isEnable").is("0").and("delFlag").is("0");
        Query query = Query.query(criteria);
        query.fields().include("dictId").include("dictName").exclude("_id");
        List<Map> typeMapList = mongoTemplate.find(query, Map.class, "sys_dict");
        List<FinanceReceivables> receivablesList = new ArrayList<>();

        ExcelUtils.read(SAVE_PATH + "/13 收款.xlsx", FinanceReceivables.class, new AnalysisEventListener<FinanceReceivables>() {
            @Override
            public void invoke(FinanceReceivables data, AnalysisContext context) {
                data.setReceivablesTypeId(HelperService.replaceRefId(data.getReceivablesTypeId(), typeMapList));
                receivablesList.add(data);
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }
        });

        log.info("|__ import {} record data",receivablesList.size());

        if (Objects.nonNull(receivablesList)) {
            mongoTemplate.insert(receivablesList, TABEL_FINANCE_RECEIVABLES);
            log.info("|__ save to {} ", TABEL_FINANCE_RECEIVABLES);
        }
        log.info("|------------------------------------------------------------------------|");
        return receivablesList;
    }


    //往来管理（调整单）
    public List<FinanceAdjustment> adjustmentHandler() {
        log.info("|------------------------------------------------------------------------|");
        log.info("|__ begin import 往来管理（调整单） ");
        List<Map> changeObjectTypes = helperService.query("label", "调整对象", new String[]{"dictId", "dictName"}, "sys_dict");
        List<FinanceAdjustment> adjustments = new ArrayList<>();
        ExcelUtils.read(SAVE_PATH + "/14 往来管理（调整单）.xlsx", FinanceAdjustment.class, new AnalysisEventListener<FinanceAdjustment>() {
            @Override
            public void invoke(FinanceAdjustment data, AnalysisContext context) {
                data.setObjectId(HelperService.replaceRefId(data.getObjectName(), changeObjectTypes));
                adjustments.add(data);
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }
        });

        log.info("|__ import {} record data",adjustments.size());

        if (!Objects.isNull(adjustments)) {
            mongoTemplate.insert(adjustments, TABEL_FINANCE_ADJUSTMENT);
            log.info("|__ save to {} ",TABEL_FINANCE_ADJUSTMENT);
        }
        log.info("|------------------------------------------------------------------------|");
        return adjustments;
    }

    //划款（扣款）
    public List<FinanceDrawMoney> drawMoneyHandler() {
        log.info("|------------------------------------------------------------------------|");
        log.info("|__ begin import 往来管理（调整单） ");
        //查询资金转换类-收款-款项类型 trans_payment_in_type
        String[] types = new String[]{"trans_payment_type"};
        Criteria criteria = Criteria.where("label").in(types).and("isEnable").is("0").and("delFlag").is("0");
        Query query = Query.query(criteria);
        query.fields().include("dictId").include("dictName").exclude("_id");
        List<Map> typeMapList = mongoTemplate.find(query, Map.class, "sys_dict");

        List<FinanceDrawMoney> drawMonies = new ArrayList<>();
        ExcelUtils.read(SAVE_PATH + "/14 往来管理（调整单）.xlsx", FinanceDrawMoney.class, new AnalysisEventListener<FinanceDrawMoney>() {
            @Override
            public void invoke(FinanceDrawMoney data, AnalysisContext context) {
                data.setMoneyTypeId(HelperService.replaceRefId(data.getMoneyTypeName(), typeMapList));
                drawMonies.add(data);
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) { }
        });

        log.info("|__ import {} record data",drawMonies.size());

        if (!Objects.isNull(drawMonies)) {
            mongoTemplate.insert(drawMonies, TABEL_FINANCE_DRAW_MONEY);
            log.info("|__ save to {} ",TABEL_FINANCE_DRAW_MONEY);
        }
        log.info("|------------------------------------------------------------------------|");
        return drawMonies;
    }



}
