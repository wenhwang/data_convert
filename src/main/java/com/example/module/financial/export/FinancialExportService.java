package com.example.module.financial.export;

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
import com.example.module.financial.model.MapInvoiceList;
import com.example.module.financial.model.MapOpenCommodity;
import com.example.module.financial.model.MapOpenInvoiceList;
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

@Service
@Slf4j
public class FinancialExportService {
    public static final String SAVE_PATH = new File("files/export/financial/").getPath();
    public static final String FILE_EXT = ".xlsx";

    @Resource
    private FinancialMapper financialMapper;

    @Autowired
    private HelperService helperService;

    @Autowired
    private MongoTemplate mongoTemplate;

    //报销单
    public List<FinanceReimbursement> expenseHandler(String funcName) {

        //查询报销单
        List<FinanceReimbursement> reimbursements = financialMapper.selectExpenseSheet();
        log.info("已查询EPMS报销单数据:{} 条记录", reimbursements.size());
        //查询报销单结算方式
        log.info("查询报销单结算方式");
        //settlement_way
        List<Map> ways = helperService.query("label", "结算方式", new String[]{"dictId", "dictName"}, "sys_dict");
        reimbursements.parallelStream().forEach(f -> {
            //处理结算方式
            String settlementWay = f.getSettlementWay();
            if (StringUtils.isNotBlank(settlementWay)) {
                f.setSettlementWayId(HelperService.replaceRefId(settlementWay, ways));
            }
        });
        String filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(filePath,funcName,FinanceReimbursement.class,reimbursements);
        return reimbursements;
    }

    //报销单明细
    public List<MapCostList> expenseDetialHandler(String funcName) {
        //cost_type
        List<Map> costTypes = helperService.query("label", "费用类别", new String[]{"dictId", "dictName"}, "sys_dict");
        List<MapCostList> costLists = financialMapper.selectAllExpenseCostList();
        log.info("已查询EPMS报销单明细数据:{} 条记录", costLists.size());
        costLists.forEach(m -> {
            m.setCostTypeId(HelperService.replaceRefId(m.getCostTypeName(), costTypes));
        });
        String filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(SAVE_PATH+"/"+funcName+FILE_EXT,funcName,MapCostList.class,costLists);
        return costLists;
    }

    //还款单
    public List<FinanceRepayment> repaymentHandler(String funcName) {
        List<FinanceRepayment> financeRepayments = financialMapper.selectRepayment();
        log.info("已查询EPMS还款单数据:{} 条记录", financeRepayments.size());
        String filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(SAVE_PATH+"/"+funcName+FILE_EXT,funcName,FinanceRepayment.class,financeRepayments);
        return financeRepayments;
    }

    //备用金（借款）
    public List<FinanceReserveFund> reserveFundHandler(String funcName) {
        List<FinanceReserveFund> reserveFunds = financialMapper.selectReserveFund();
        log.info("已查询备用金还款数据:{} 条记录", reserveFunds.size());
        String filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(SAVE_PATH+"/"+funcName+FILE_EXT,funcName,FinanceReserveFund.class,reserveFunds);
        return reserveFunds;
    }

    //资金账号
    public List<FinanceCapitalAccount> capitalAccountHandler(String funcName) {
        //account_money_type
        List<Map> accountMoneyTypes = helperService.query("label", "帐户资金类型", new String[]{"dictId", "dictName"}, "sys_dict");
        //bank_account_type
        List<Map> bankAccountTypes = helperService.query("label", "银行帐户类型", new String[]{"dictId", "dictName"}, "sys_dict");
        List<FinanceCapitalAccount> capitalAccounts = financialMapper.selectCapitalAccount();
        capitalAccounts.stream().forEach(f -> {
            //账户资金类型
            String bankAccountType = f.getBankAccountType();
            if (StringUtils.isNotBlank(bankAccountType)) {
                f.setBankAccountTypeId(HelperService.replaceRefId(bankAccountType, bankAccountTypes));
            }

            //银行账户类型
            String accountMoneyType = f.getAccountType();
            if (StringUtils.isNotBlank(accountMoneyType)) {
                f.setAccountTypeId(HelperService.replaceRefId(accountMoneyType, accountMoneyTypes));
            }
        });
        String filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(SAVE_PATH+"/"+funcName+FILE_EXT,funcName,FinanceCapitalAccount.class,capitalAccounts);
        return capitalAccounts;
    }

    //外经证
    public List<FinanceBusinessLicense> businessLicenseHandler(String funcName) {
        List<FinanceBusinessLicense> businessLicenses = financialMapper.selectBusinessLicense();
        log.info("已查询外经证数据:{} 条记录", businessLicenses.size());
        String filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(filePath,funcName,FinanceBusinessLicense.class,businessLicenses);
        return businessLicenses;
    }

    //外经证交接信息
    public List<MapHandover> businessLicenseHandoverHandler(String funcName) {
        List<MapHandover> mapHandovers = new ArrayList<>();
        String filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(filePath,funcName,MapHandover.class,mapHandovers);
        return mapHandovers;
    }

    //外经证完税信息
    public List<MapPayTax> businessLicensePayTaxHandler(String funcName) {
        List<MapPayTax> mapHandovers = new ArrayList<>();
        String filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(filePath,funcName,MapPayTax.class,mapHandovers);
        return mapHandovers;
    }

    //收票
    public List<FinanceReceiveInvoice> receiveInvoiceHandler(String funcName) {
        List<FinanceReceiveInvoice> receiveInvoices = financialMapper.selectReceiveInvoice();
        log.info("已查询收票数据:{} 条记录", receiveInvoices.size());
        String filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(filePath,funcName,FinanceReceiveInvoice.class,receiveInvoices);
        return receiveInvoices;
    }

    //收票明细
    public List<MapInvoiceList> receiveInvoiceDetailHandler(String funcName) {
        List<MapInvoiceList> invoiceLists = financialMapper.selectALLReceiveInvoiceDetail();
        log.info("已查询收票明细数据:{} 条记录", invoiceLists.size());
        String filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(filePath,funcName,MapInvoiceList.class,invoiceLists);
        return invoiceLists;
    }

    //收票-商品明细
    public List<MapCommodity> receiveInvoiceProdsHandler(String funcName) {
        List<MapCommodity> mapCommodities = new ArrayList<>();
        String filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(filePath,funcName,MapCommodity.class,mapCommodities);
        return mapCommodities;
    }

    //开票
    public List<FinanceOpenInvoice> openInvoiceHandler(String funcName) {
        List<FinanceOpenInvoice> openInvoices = financialMapper.selectOpenInvoice();
        log.info("已查询开票数据:{} 条记录", openInvoices.size());
        String filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(filePath,funcName,FinanceOpenInvoice.class,openInvoices);
        return openInvoices;
    }

    //开票明细
    public List<MapOpenInvoiceList> openInvoiceDetailHandler(String funcName) {
        List<MapOpenInvoiceList> openInvoiceDetails = financialMapper.selectAllOpenInvoiceDetail();
        log.info("已查询开票明细数据:{} 条记录", openInvoiceDetails.size());
        String filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(filePath,funcName,MapOpenInvoiceList.class,openInvoiceDetails);
        return openInvoiceDetails;
    }

    //开票商品明细
    public List<MapOpenCommodity> openInvoiceProdsHandler(String funcName) {
        List<MapOpenCommodity> openCommodities = new ArrayList<>();
        log.info("已查询开票商品明细数据:{} 条记录", openCommodities.size());
        String filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(filePath,funcName,MapOpenCommodity.class,openCommodities);
        return openCommodities;
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

        List<FinancePayment> payment_1 = financialMapper.selectPayingVoucher();

        log.info("已查询付款（确认付款）数据:{} 条记录", payment_1.size());
        if (Objects.nonNull(payment_1)) {
            payment_1.parallelStream().forEach(p -> {
                p.setMoneyTypeId(HelperService.replaceRefId(p.getMoneyTypeId(), typeMapList));
            });
            results.addAll(payment_1);
        }
        String funcName = "付款申请（付款单）";
        String filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(SAVE_PATH+"/"+funcName+FILE_EXT,funcName,FinancePayment.class,payment_1);


        List<FinancePayment> payment_2 = financialMapper.selectProjectMarginApply();
        log.info("已查询保证金付款数据:{} 条记录", payment_2.size());
        if (Objects.nonNull(payment_2)) {
            payment_2.parallelStream().forEach(p -> {
                p.setMoneyTypeId(HelperService.replaceRefId(p.getMoneyTypeId(), typeMapList));
            });
            results.addAll(payment_2);
        }

        funcName = "保证金付款";
        filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(SAVE_PATH+"/"+funcName+FILE_EXT,funcName,FinancePayment.class,payment_2);

        List<FinancePayment> payment_3 = financialMapper.selectProjectPaymentApply();
        log.info("已查询项目付款数据:{} 条记录", payment_3.size());
        if (Objects.nonNull(payment_3)) {
            payment_3.parallelStream().forEach(p -> {
                p.setMoneyTypeId(HelperService.replaceRefId(p.getMoneyTypeId(), typeMapList));
            });
            results.addAll(payment_3);
        }
        funcName = "项目付款申请";
        filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(SAVE_PATH+"/"+funcName+FILE_EXT,funcName,FinancePayment.class,payment_3);

        List<FinancePayment> payment_4 = financialMapper.selectPaymentApplyHead();
        log.info("已查询采购付款申请数据:{} 条记录", payment_4.size());
        if (Objects.nonNull(payment_4)) {
            payment_4.parallelStream().forEach(p -> {
                p.setMoneyTypeId(HelperService.replaceRefId(p.getMoneyTypeId(), typeMapList));
            });
            results.addAll(payment_4);
        }
        funcName = "采购付款申请";
        filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(SAVE_PATH+"/"+funcName+FILE_EXT,funcName,FinancePayment.class,payment_4);
        return results;
    }

    //收款
    public List<FinanceReceivables> receivablesHandler(String funcName) {
        //查询所有的收款类型
        String[] types = new String[]{"资金转换类-收款-款项类型",//trans_payment_in_type
                "筹资类-收款-款项类型",//financing_payment_in_type
                "投资类-收款-款项类型",//invest_payment_in_type
                "经营类-收款-款项类型"};//manage_payment_in_type
        Criteria criteria = Criteria.where("label").in(types).and("isEnable").is("0").and("delFlag").is("0");
        Query query = Query.query(criteria);
        query.fields().include("dictId").include("dictName").exclude("_id");
        List<Map> typeMapList = mongoTemplate.find(query, Map.class, "sys_dict");
        List<FinanceReceivables> receivablesList = financialMapper.selectReceivablese();
        log.info("已查询收款数据:{} 条记录", receivablesList.size());
        if (!Objects.isNull(receivablesList)) {
            receivablesList.parallelStream().forEach(p -> {
                p.setReceivablesTypeId(HelperService.replaceRefId(p.getReceivablesTypeId(), typeMapList));
            });
        }
        String filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(filePath,funcName,FinanceReceivables.class,receivablesList);
        return receivablesList;
    }


    //往来管理（调整单）
    public List<FinanceAdjustment> adjustmentHandler(String funcName) {
        List<FinanceAdjustment> adjustments = financialMapper.selectAdjustment();
        List<Map> changeObjectTypes = helperService.query("label", "调整对象", new String[]{"dictId", "dictName"}, "sys_dict");
        log.info("已查询往来管理（调整单）数据:{} 条记录", adjustments.size());
        if (!Objects.isNull(adjustments)) {
            adjustments.parallelStream().forEach(f -> {
                //开票明细
                f.setObjectId(HelperService.replaceRefId(f.getObjectName(), changeObjectTypes));
            });
        }
        String filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(filePath,funcName,FinanceAdjustment.class,adjustments);
        return adjustments;
    }

    public List<FinanceDrawMoney> drawMoneyHandler(String funcName) {
        //查询资金转换类-收款-款项类型 trans_payment_in_type
        String[] types = new String[]{"trans_payment_type"};
        Criteria criteria = Criteria.where("label").in(types).and("isEnable").is("0").and("delFlag").is("0");
        Query query = Query.query(criteria);
        query.fields().include("dictId").include("dictName").exclude("_id");
        List<Map> typeMapList = mongoTemplate.find(query, Map.class, "sys_dict");

        List<FinanceDrawMoney> drawMonies = financialMapper.selectDrawMoney();
        log.info("已查询划款（扣款）数据:{} 条记录", drawMonies.size());
        if (!Objects.isNull(drawMonies)) {
            drawMonies.parallelStream().forEach(p -> {
                p.setMoneyTypeId(HelperService.replaceRefId(p.getMoneyTypeName(), typeMapList));
            });
        }
        String filePath = SAVE_PATH+"/"+funcName+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(filePath,funcName,FinanceDrawMoney.class,drawMonies);
        return drawMonies;
    }



}
