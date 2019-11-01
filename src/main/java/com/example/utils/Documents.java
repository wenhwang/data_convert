package com.example.utils;

/**
 * @program: data_convert
 * @description:
 * @author: Administrator
 * @create: 2019-10-21 15:32
 **/
public class Documents {

    //客户
    public enum CUSTOMER{
        CUSTOMER_INFO_DOC("customer_info");
        public String docName;
        CUSTOMER(String docName) {
            this.docName = docName;
        }
    }

    //合同
    public enum CONTRACT{
        CONTRACT_MANAGE_DOC("contract_manage"),
        CONTRACT_PARTNER_RECEIVABLES_PLAN_DOC("contract_partner_receivables_plan");
        public String docName;
        CONTRACT(String docName) {
            this.docName = docName;
        }
    }

    //金融
    public enum FINANCE {
        //报销单
        FINANCE_REIMBURSEMENT_DOC ("finance_reimbursement"),
        //还款单
        FINANCE_REPAYMENT_DOC("finance_repayment"),
        //备用金
        FINANCE_RESERVE_FUND_DOC("finance_reserve_fund"),
        //资金账号
        FINANCE_CAPITAL_ACCOUNT_DOC("finance_capital_account"),
        //外经证
        FINANCE_BUSINESS_LICENSE_DOC("finance_business_license"),
        //收票
        FINANCE_RECEIVE_INVOICE_DOC("finance_receive_invoice"),
        //开票
        FINANCE_OPEN_INVOICE_DOC("finance_open_invoice"),
        //收款
        FINANCE_RECEIVABLES_DOC("finance_receivables"),
        //往来管理（调整单）
        FINANCE_ADJUSTMENT_DOC("finance_adjustment"),
        //划款（扣款）
        FINANCE_DRAW_MONEY_DOC("finance_draw_money"),
        //付款
        FINANCE_PAYMENT_DOC("finance_payment");

        public String docName;
        FINANCE(String docName) {
            this.docName = docName;
        }
    }

    //项目
    public enum PROJECT{
        PROJECT_INFO_DOC ("project_info"),
        PROJECT_AGREEMENT_DOC("project_agreement"),
        PROJECT_BID_DOC("project_bid"),
        PROJECT_ANSWER_DOC("project_answer");
        public String docName;
        PROJECT(String docName) {
            this.docName = docName;
        }
    }

    //资源
    public enum RESOURCE{
        ARCHIVE_APPLY_DOC ("archive_apply"),
        ARCHIVE_FILE_DOC ("archive_file"),
        ARCHIVE_MANAGE_DOC ("archive_manage"),
        ARCHIVE_LEND_LOG_DOC("archive_lend_log");
        public String docName;
        RESOURCE(String docName) {
            this.docName = docName;
        }
    }

    //供应链
    public enum SUPPLY{
        SUPPLY_SUPPLIER_DOC("supply_supplier"),
        SUPPLY_COMMODITY_DOC("supply_commodity"),
        SUPPLY_COMMODITY_CATEGORY_DOC("supply_commodity_category");
        public String docName;
        SUPPLY(String docName) {
            this.docName = docName;
        }
    }





}
