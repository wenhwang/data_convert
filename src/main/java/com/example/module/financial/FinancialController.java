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
import com.example.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "财务数据-DB")
@RequestMapping("/financialdb")
public class FinancialController {

    @Autowired
    private FinancialService financialService;

    @ApiOperation("报销单")
    @GetMapping("/expense")
    public Result<List<FinanceReimbursement>> expenseHandler(){
        return  Result.<List<FinanceReimbursement>>success(financialService.expenseHandler());
    }

    //还款单 finance_repayment
    @ApiOperation("还款单")
    @GetMapping("/repayment")
    public Result<List<FinanceRepayment>> repaymentHandler(){
        return  Result.<List<FinanceRepayment>>success(financialService.repaymentHandler());
    }

    //备用金 finance_reserve_fund
    @ApiOperation("备用金")
    @GetMapping("/reservefund")
    public Result<List<FinanceReserveFund>> reservefundHandler(){
        return  Result.<List<FinanceReserveFund>>success(financialService.reserveFundHandler());
    }

    //资金账号 capitalaccount  finance_capital_account
    @ApiOperation("资金账号")
    @GetMapping("/capitalaccount")
    public Result<List<FinanceCapitalAccount>> capitalaccountHandler(){
        return  Result.<List<FinanceCapitalAccount>>success(financialService.capitalAccountHandler());
    }


   //外经证 businesslicense  finance_business_license
    @ApiOperation("外经证")
    @GetMapping("/license")
    public Result<List<FinanceBusinessLicense>> businessLicenseHandler(){
        return  Result.<List<FinanceBusinessLicense>>success(financialService.businessLicenseHandler());
    }

    //收票 receiveinvoice finance_receive_invoice
    @ApiOperation("收票")
    @GetMapping("/receiveinvoice")
    public Result<List<FinanceReceiveInvoice>> receiveInvoiceHandler(){
        return  Result.<List<FinanceReceiveInvoice>>success(financialService.receiveInvoiceHandler());
    }

    //开票 openInvoice   finance_open_invoice
    @ApiOperation("开票")
    @GetMapping("/openinvoice")
    public Result<List<FinanceOpenInvoice>> openInvoiceHandler(){
        return  Result.<List<FinanceOpenInvoice>>success(financialService.openInvoiceHandler());
    }

    //收款  finance_receivables
    @ApiOperation("收款")
    @GetMapping("/receivables")
    public Result<List<FinanceReceivables>> receivablesHandler(){
        return  Result.<List<FinanceReceivables>>success(financialService.receivablesHandler());
    }


    //往来管理（调整单）finance_adjustment
    @ApiOperation("往来管理（调整单）")
    @GetMapping("/adjustment")
    public Result<List<FinanceAdjustment>> adjustmentHandler() {
        return Result.<List<FinanceAdjustment>>success(financialService.adjustmentHandler());
    }

    //划款（扣款） finance_draw_money
    @ApiOperation("划款（扣款）")
    @GetMapping("/drawmoney")
    public Result<List<FinanceDrawMoney>> drawMoneyHandler(){
        return  Result.<List<FinanceDrawMoney>>success(financialService.drawMoneyHandler());
    }


    //付款 payment 保证金付款 项目付款 采购付款  finance_payment
    @ApiOperation("付款")
    @GetMapping("/payment")
    public Result<List<FinancePayment>> paymentHandler(){
        return  Result.<List<FinancePayment>>success(financialService.paymentHandler());
    }
}
