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
    List<FinanceReimbursement> selectExpenseSheet();

    //报销单明细
    List<MapCostList> selectExpenseCostList(@Param("bxId") String bxId);

    //还款单
    List<FinanceRepayment> selectRepayment();

    //备用金
    List<FinanceReserveFund> selectReserveFund();

    //资金账号
    List<FinanceCapitalAccount> selectCapitalAccount();

    //外经证
    List<FinanceBusinessLicense> selectBusinessLicense();

    //收票
    List<FinanceReceiveInvoice> selectReceiveInvoice();

    //收票明细
    List<MapInvoice> selectReceiveInvoiceDetail(String receiveInvoiceId);

    //收票明细
    List<MapInvoice> selectALLReceiveInvoiceDetail();

    //开票
    List<FinanceOpenInvoice> selectOpenInvoice();

    //开票明细
    List<MapOpenInvoice> selectOpenInvoiceDetail(String openInvoiceId);

    //开票明细
    List<MapOpenInvoice> selectAllOpenInvoiceDetail();

    //收款
    List<FinanceReceivables> selectReceivablese();

    //往来管理(调整单)
    List<FinanceAdjustment> selectAdjustment();

    //划款（扣款）
    List<FinanceDrawMoney> selectDrawMoney();

    //付款（确认付款）
    List<FinancePayment> selectPayingVoucher();

    //保证金付款
    List<FinancePayment> selectProjectMarginApply();

    //项目付款
    List<FinancePayment> selectProjectPaymentApply();

    //采购付款申请
    List<FinancePayment> selectPaymentApplyHead();

    //所有报销单明细
    List<MapCostList> selectAllExpenseCostList();
}
