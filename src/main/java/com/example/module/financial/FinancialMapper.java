package com.example.module.financial;

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
import com.example.module.financial.model.MapInvoice;
import com.example.module.financial.model.MapOpenInvoice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinancialMapper {
    //报销单
    List<FinanceReimbursement> selectExpenseSheet(String exportBeginTime, String exportEndTime);

    //报销单明细
    List<MapCostList> selectExpenseCostList(@Param("bxId") String bxId);

    //还款单
    List<FinanceRepayment> selectRepayment(String exportBeginTime, String exportEndTime);

    //备用金
    List<FinanceReserveFund> selectReserveFund(String exportBeginTime, String exportEndTime);

    //资金账号
    List<FinanceCapitalAccount> selectCapitalAccount(String exportBeginTime, String exportEndTime);

    //外经证
    List<FinanceBusinessLicense> selectBusinessLicense(String exportBeginTime, String exportEndTime);

    //收票
    List<FinanceReceiveInvoice> selectReceiveInvoice(String exportBeginTime, String exportEndTime);

    //收票明细
    List<MapInvoice> selectReceiveInvoiceDetail(String receiveInvoiceId);

    //收票明细
    List<MapInvoice> selectALLReceiveInvoiceDetail(String exportBeginTime, String exportEndTime);

    //开票
    List<FinanceOpenInvoice> selectOpenInvoice(String exportBeginTime, String exportEndTime);

    //开票明细
    List<MapOpenInvoice> selectOpenInvoiceDetail(String openInvoiceId);

    //开票明细
    List<MapOpenInvoice> selectAllOpenInvoiceDetail(String exportBeginTime, String exportEndTime);

    //收款
    List<FinanceReceivables> selectReceivablese(String exportBeginTime, String exportEndTime);

    //往来管理(调整单)
    List<FinanceAdjustment> selectAdjustment(String exportBeginTime, String exportEndTime);

    //划款（扣款）
    List<FinanceDrawMoney> selectDrawMoney(String exportBeginTime, String exportEndTime);

    //付款（确认付款）
    List<FinancePayment> selectPayingVoucher(String exportBeginTime, String exportEndTime);

    //保证金付款
    List<FinancePayment> selectProjectMarginApply(String exportBeginTime, String exportEndTime);

    //项目付款
    List<FinancePayment> selectProjectPaymentApply(String exportBeginTime, String exportEndTime);

    //采购付款申请
    List<FinancePayment> selectPaymentApplyHead(String exportBeginTime, String exportEndTime);

    //所有报销单明细
    List<MapCostList> selectAllExpenseCostList(String exportBeginTime, String exportEndTime);
}
