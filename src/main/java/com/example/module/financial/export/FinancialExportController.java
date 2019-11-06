package com.example.module.financial.export;

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
import com.example.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "财务数据-导出文件")
@RequestMapping("/financial-export")
public class FinancialExportController {

    @Autowired
    private FinancialExportService financialLocalFileService;

    @ApiOperation("1. 报销单")
    @GetMapping("/expense")
    public Result<List<FinanceReimbursement>> expenseHandler(){
        return  Result.<List<FinanceReimbursement>>success(financialLocalFileService.expenseHandler("报销单"));
    }

    @ApiOperation("1.1 报销单明细")
    @GetMapping("/expenseDetail")
    public Result<List<MapCostList>> expenseDetialHandler(){
        return  Result.<List<MapCostList>>success(financialLocalFileService.expenseDetialHandler("报销单明细"));
    }


    //还款单 finance_repayment
    @ApiOperation("2 还款单")
    @GetMapping("/repayment")
    public Result<List<FinanceRepayment>> repaymentHandler(){
        return  Result.<List<FinanceRepayment>>success(financialLocalFileService.repaymentHandler("还款单"));
    }

    //备用金 finance_reserve_fund
    @ApiOperation("3 备用金")
    @GetMapping("/reservefund")
    public Result<List<FinanceReserveFund>> reservefundHandler(){
        return  Result.<List<FinanceReserveFund>>success(financialLocalFileService.reserveFundHandler("备用金（借款）"));
    }

    //资金账号 capitalaccount  finance_capital_account
    @ApiOperation("4 资金账号")
    @GetMapping("/capitalaccount")
    public Result<List<FinanceCapitalAccount>> capitalaccountHandler(){
        return  Result.<List<FinanceCapitalAccount>>success(financialLocalFileService.capitalAccountHandler("资金账号"));
    }


   //外经证 businesslicense  finance_business_license
    @ApiOperation("5 外经证")
    @GetMapping("/license")
    public Result<List<FinanceBusinessLicense>> businessLicenseHandler(){
        return  Result.<List<FinanceBusinessLicense>>success(financialLocalFileService.businessLicenseHandler("外经证"));
    }

    //外经证交接信息
    @ApiOperation("5.1 外经证-交接信息")
    @GetMapping("/license-handove")
    public Result<List<MapHandover>> businessLicenseHandoverHandler(){
        return  Result.<List<MapHandover>>success(financialLocalFileService.businessLicenseHandoverHandler("外经证-交接信息"));
    }
    //外经证完税信息
    @ApiOperation("5.2 外经证-完税信息")
    @GetMapping("/license-payTax")
    public Result<List<MapPayTax>> businessLicensePayTaxHandler(){
        return  Result.<List<MapPayTax>>success(financialLocalFileService.businessLicensePayTaxHandler("外经证-完税信息"));
    }

    //收票 receiveinvoice finance_receive_invoice
    @ApiOperation("6 收票")
    @GetMapping("/receiveinvoice")
    public Result<List<FinanceReceiveInvoice>> receiveInvoiceHandler(){
        return  Result.<List<FinanceReceiveInvoice>>success(financialLocalFileService.receiveInvoiceHandler("收票"));
    }


    @ApiOperation("6.1 收票-收票明细")
    @GetMapping("/receiveinvoice-detail")
    public Result<List<MapInvoiceList>> receiveInvoiceDetailHandler(){
        return  Result.<List<MapInvoiceList>>success(financialLocalFileService.receiveInvoiceDetailHandler("收票-收票明细"));
    }


    @ApiOperation("6.2 收票-商品明细")
    @GetMapping("/receiveinvoice-prod")
    public Result<List<MapCommodity>> receiveInvoiceProdsHandler(){
        return  Result.<List<MapCommodity>>success(financialLocalFileService.receiveInvoiceProdsHandler("收票-商品明细"));
    }



    //开票 openInvoice   finance_open_invoice
    @ApiOperation("7 开票")
    @GetMapping("/openinvoice")
    public Result<List<FinanceOpenInvoice>> openInvoiceHandler(){
        return  Result.<List<FinanceOpenInvoice>>success(financialLocalFileService.openInvoiceHandler("开票"));
    }
    //开票-发票明细
    @ApiOperation("7.1 开票-开票明细")
    @GetMapping("/openinvoice-details")
    public Result<List<MapOpenInvoiceList>> openInvoiceDetailHandler(){
        return  Result.<List<MapOpenInvoiceList>>success(financialLocalFileService.openInvoiceDetailHandler("开票-开票明细"));
    }
    //开票-商品明细
    @ApiOperation("7.2 开票-商品明细")
    @GetMapping("/openinvoice-prod")
    public Result<List<MapOpenCommodity>> openInvoiceProdsHandler(){
        return  Result.<List<MapOpenCommodity>>success(financialLocalFileService.openInvoiceProdsHandler("开票-商品明细"));
    }

    //付款 payment 保证金付款 项目付款 采购付款  finance_payment
    @ApiOperation("8 付款")
    @GetMapping("/payment")
    public Result<List<FinancePayment>> paymentHandler(){
        return  Result.<List<FinancePayment>>success(financialLocalFileService.paymentHandler());
    }

    //往来管理（调整单）finance_adjustment
    @ApiOperation("9 往来管理（调整单）")
    @GetMapping("/adjustment")
    public Result<List<FinanceAdjustment>> adjustmentHandler() {
        return Result.<List<FinanceAdjustment>>success(financialLocalFileService.adjustmentHandler("往来管理（调整单）"));
    }

    //收款  finance_receivables
    @ApiOperation("10 收款")
    @GetMapping("/receivables")
    public Result<List<FinanceReceivables>> receivablesHandler(){
        return  Result.<List<FinanceReceivables>>success(financialLocalFileService.receivablesHandler("收款"));
    }

    //划款（扣款） finance_draw_money
    @ApiOperation("11 划款（扣款）")
    @GetMapping("/drawmoney")
    public Result<List<FinanceDrawMoney>> drawMoneyHandler(){
        return  Result.<List<FinanceDrawMoney>>success(financialLocalFileService.drawMoneyHandler("划款（扣款）"));
    }
}
