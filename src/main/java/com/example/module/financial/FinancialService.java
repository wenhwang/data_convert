package com.example.module.financial;

import com.example.module.HelperService;
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
import com.example.module.financial.model.MapCostList;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class FinancialService {

    @Value("${fexport.begin.time}")
    private String exportBeginTime;

    @Value("${fexport.end.time}")
    private String exportEndTime;


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

    @Transactional
    public List<FinanceReimbursement> expenseHandler() {
        //查询报销单
        List<FinanceReimbursement> reimbursements = financialMapper.selectExpenseSheet(exportBeginTime,exportEndTime);
        log.info("已查询EPMS报销单数据:{} 条记录", reimbursements.size());
        //查询报销单结算方式
        log.info("查询报销单结算方式");
        //settlement_way
        List<Map> ways = helperService.query("label", "结算方式", new String[]{"dictId", "dictName"}, "sys_dict");
        //cost_type
        List<Map> costTypes = helperService.query("label", "费用类别", new String[]{"dictId", "dictName"}, "sys_dict");
        reimbursements.parallelStream().forEach(f -> {

            //处理结算方式
            String settlementWay = f.getSettlementWay();
            if (StringUtils.isNotBlank(settlementWay)) {
                f.setSettlementWayId(HelperService.replaceRefId(settlementWay, ways));
            }

            String bxId = f.getReimbursementId();
            List<MapCostList> costLists = financialMapper.selectExpenseCostList(bxId);
            costLists.forEach(m -> {
                System.err.println(m.getCostTypeName());
                m.setCostTypeId(HelperService.replaceRefId(m.getCostTypeName(), costTypes));
            });
            f.setCostList(costLists);
        });
        if (!Objects.isNull(reimbursements)) {
            mongoTemplate.insert(reimbursements, TABEL_FINANCE_REIMBURSEMENT);
            log.info("保存数据  ---> :{} ", TABEL_FINANCE_REIMBURSEMENT);
        }
        return reimbursements;
    }

    @Transactional
    public List<FinanceRepayment> repaymentHandler() {
        List<FinanceRepayment> financeRepayments = financialMapper.selectRepayment(exportBeginTime, exportEndTime);
        log.info("已查询EPMS还款单数据:{} 条记录", financeRepayments.size());
        if (!Objects.isNull(financeRepayments)) {
            mongoTemplate.insert(financeRepayments, TABEL_FINANCE_REPAYMENT);
            log.info("保存数据 ---> :{} ", TABEL_FINANCE_REPAYMENT);
        }
        return financeRepayments;
    }

    @Transactional
    public List<FinanceReserveFund> reserveFundHandler() {
        List<FinanceReserveFund> reserveFunds = financialMapper.selectReserveFund(exportBeginTime, exportEndTime);
        log.info("已查询备用金还款数据:{} 条记录", reserveFunds.size());
        if (!Objects.isNull(reserveFunds)) {
            mongoTemplate.insert(reserveFunds, TABEL_FINANCE_RESERVE_FUND);
            log.info("保存数据 ---> :{} ", TABEL_FINANCE_RESERVE_FUND);
        }
        return reserveFunds;
    }

    @Transactional
    public List<FinanceCapitalAccount> capitalAccountHandler() {
//account_money_type
        List<Map> accountMoneyTypes = helperService.query("label", "帐户资金类型", new String[]{"dictId", "dictName"}, "sys_dict");
//bank_account_type
        List<Map> bankAccountTypes = helperService.query("label", "银行帐户类型", new String[]{"dictId", "dictName"}, "sys_dict");
        List<FinanceCapitalAccount> capitalAccounts = financialMapper.selectCapitalAccount(exportBeginTime, exportEndTime);

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


        log.info("已查询资金账号数据:{} 条记录", capitalAccounts.size());
        if (!Objects.isNull(capitalAccounts)) {
            mongoTemplate.insert(capitalAccounts, TABEL_FINANCE_CAPITAL_ACCOUNT);
            log.info("保存数据 ---> :{} ", TABEL_FINANCE_CAPITAL_ACCOUNT);
        }
        return capitalAccounts;
    }

    @Transactional
    public List<FinanceBusinessLicense> businessLicenseHandler() {
        List<FinanceBusinessLicense> businessLicenses = financialMapper.selectBusinessLicense(exportBeginTime, exportEndTime);
        log.info("已查询外经证数据:{} 条记录", businessLicenses.size());
        if (!Objects.isNull(businessLicenses)) {
            mongoTemplate.insert(businessLicenses, TABEL_FINANCE_BUSINESS_LICENSE);
            log.info("保存数据 ---> :{} ", TABEL_FINANCE_BUSINESS_LICENSE);
        }
        return businessLicenses;
    }

    @Transactional
    public List<FinanceReceiveInvoice> receiveInvoiceHandler() {
        List<FinanceReceiveInvoice> receiveInvoices = financialMapper.selectReceiveInvoice(exportBeginTime, exportEndTime);
        receiveInvoices.parallelStream().forEach(f -> {
            //收票明细
            f.setInvoiceList(financialMapper.selectReceiveInvoiceDetail(f.getReceiveInvoiceId()));
        });

        log.info("已查询收票数据:{} 条记录", receiveInvoices.size());
        if (!Objects.isNull(receiveInvoices)) {
            mongoTemplate.insert(receiveInvoices, TABEL_FINANCE_RECEIVE_INVOICE);
            log.info("保存数据 ---> :{} ", TABEL_FINANCE_RECEIVE_INVOICE);
        }
        return receiveInvoices;

    }

    @Transactional
    public List<FinanceOpenInvoice> openInvoiceHandler() {
        List<FinanceOpenInvoice> openInvoices = financialMapper.selectOpenInvoice(exportBeginTime,exportEndTime);
        log.info("已查询开票数据:{} 条记录", openInvoices.size());
        openInvoices.parallelStream().forEach(f -> {
            //开票明细
            f.setInvoiceList(financialMapper.selectOpenInvoiceDetail(f.getOpenInvoiceId()));
        });

        if (!Objects.isNull(openInvoices)) {
            mongoTemplate.insert(openInvoices, TABEL_FINANCE_OPEN_INVOICE);
            log.info("保存数据 ---> :{} ", TABEL_FINANCE_OPEN_INVOICE);
        }
        return openInvoices;
    }

    @Transactional
    public List<FinanceReceivables> receivablesHandler() {
        //查询所有的收款类型
        String[] types = new String[]{"资金转换类-收款-款项类型",//trans_payment_in_type
                "筹资类-收款-款项类型",//financing_payment_in_type
                "投资类-收款-款项类型",//invest_payment_in_type
                "经营类-收款-款项类型"};//manage_payment_in_type
        Criteria criteria = Criteria.where("label").in(types).and("isEnable").is("0").and("delFlag").is("0");
        Query query = Query.query(criteria);
        query.fields().include("dictId").include("dictName").exclude("_id");
        List<Map> typeMapList = mongoTemplate.find(query, Map.class, "sys_dict");
        List<FinanceReceivables> receivablesList = financialMapper.selectReceivablese(exportBeginTime,exportEndTime);
        log.info("已查询收款数据:{} 条记录", receivablesList.size());
        if (!Objects.isNull(receivablesList)) {
            receivablesList.parallelStream().forEach(p -> {
                p.setReceivablesTypeId(HelperService.replaceRefId(p.getReceivablesTypeId(), typeMapList));
            });
            mongoTemplate.insert(receivablesList, TABEL_FINANCE_RECEIVABLES);
            log.info("保存数据 ---> :{} ", TABEL_FINANCE_RECEIVABLES);
        }
        return receivablesList;
    }

    @Transactional
    public List<FinanceAdjustment> adjustmentHandler() {
        List<FinanceAdjustment> adjustments = financialMapper.selectAdjustment(exportBeginTime,exportEndTime);
        List<Map> changeObjectTypes = helperService.query("label", "调整对象", new String[]{"dictId", "dictName"}, "sys_dict");
        log.info("已查询往来管理（调整单）数据:{} 条记录", adjustments.size());
        if (!Objects.isNull(adjustments)) {
            adjustments.parallelStream().forEach(f -> {
                //开票明细
                f.setObjectId(HelperService.replaceRefId(f.getObjectName(), changeObjectTypes));
            });
            mongoTemplate.insert(adjustments, TABEL_FINANCE_ADJUSTMENT);
            log.info("保存数据 ---> :{} ", TABEL_FINANCE_ADJUSTMENT);
        }
        return adjustments;
    }

    @Transactional
    public List<FinanceDrawMoney> drawMoneyHandler() {
        //查询资金转换类-收款-款项类型 trans_payment_in_type
        String[] types = new String[]{"trans_payment_type"};
        Criteria criteria = Criteria.where("label").in(types).and("isEnable").is("0").and("delFlag").is("0");
        Query query = Query.query(criteria);
        query.fields().include("dictId").include("dictName").exclude("_id");
        List<Map> typeMapList = mongoTemplate.find(query, Map.class, "sys_dict");

        List<FinanceDrawMoney> drawMonies = financialMapper.selectDrawMoney(exportBeginTime,exportEndTime);
        log.info("已查询划款（扣款）数据:{} 条记录", drawMonies.size());
        if (!Objects.isNull(drawMonies)) {
            drawMonies.parallelStream().forEach(p -> {
                p.setMoneyTypeId(HelperService.replaceRefId(p.getMoneyTypeName(), typeMapList));
            });
            mongoTemplate.insert(drawMonies, TABEL_FINANCE_DRAW_MONEY);
            log.info("保存数据 ---> :{} ", TABEL_FINANCE_DRAW_MONEY);
        }
        return drawMonies;
    }

    //@Transactional
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


        List<FinancePayment> payment_1 = financialMapper.selectPayingVoucher(exportBeginTime,exportEndTime);

        log.info("已查询付款（确认付款）数据:{} 条记录", payment_1.size());
        if (Objects.nonNull(payment_1)) {
            payment_1.parallelStream().forEach(p -> {
                p.setMoneyTypeId(HelperService.replaceRefId(p.getMoneyTypeId(), typeMapList));
            });
            mongoTemplate.insert(payment_1, TABEL_FINANCE_PAYMENT);
            log.info("保存数据 ---> :{} ", TABEL_FINANCE_PAYMENT);
            results.addAll(payment_1);
        }


        List<FinancePayment> payment_2 = financialMapper.selectProjectMarginApply(exportBeginTime,exportEndTime);
        log.info("已查询保证金付款数据:{} 条记录", payment_2.size());
        if (Objects.nonNull(payment_2)) {
            payment_2.parallelStream().forEach(p -> {
                p.setMoneyTypeId(HelperService.replaceRefId(p.getMoneyTypeId(), typeMapList));
            });
            mongoTemplate.insert(payment_2, TABEL_FINANCE_PAYMENT);
            log.info("保存数据 ---> :{} ", TABEL_FINANCE_PAYMENT);
            results.addAll(payment_2);
        }


        List<FinancePayment> payment_3 = financialMapper.selectProjectPaymentApply(exportBeginTime,exportEndTime);
        log.info("已查询项目付款数据:{} 条记录", payment_3.size());
        if (Objects.nonNull(payment_3)) {
            payment_3.parallelStream().forEach(p -> {
                p.setMoneyTypeId(HelperService.replaceRefId(p.getMoneyTypeId(), typeMapList));
            });
            mongoTemplate.insert(payment_3, TABEL_FINANCE_PAYMENT);
            log.info("保存数据 ---> :{} ", TABEL_FINANCE_PAYMENT);

            results.addAll(payment_3);
        }


        List<FinancePayment> payment_4 = financialMapper.selectPaymentApplyHead(exportBeginTime,exportEndTime);
        log.info("已查询采购付款申请数据:{} 条记录", payment_4.size());
        if (Objects.nonNull(payment_4)) {
            payment_4.parallelStream().forEach(p -> {
                p.setMoneyTypeId(HelperService.replaceRefId(p.getMoneyTypeId(), typeMapList));
            });
            mongoTemplate.insert(payment_4, TABEL_FINANCE_PAYMENT);
            log.info("保存数据 ---> :{} ", TABEL_FINANCE_PAYMENT);
            results.addAll(payment_4);
        }
        return results;
    }
}
