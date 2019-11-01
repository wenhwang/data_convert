package com.example.module.contract;

import com.example.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "合同类数据导入")
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @ApiOperation("工程合同")
    @GetMapping("/engineering")
    public Result<List> engineeringContractHandler(){
        return  Result.success(contractService.contractHandler(ContractService.CONTRACT_TYPE_1));
    }

    @ApiOperation("增补合同")
    @GetMapping("/extengineering")
    public Result<List> extEngineeringContractHandler(){
        return  Result.success(contractService.contractHandler(ContractService.CONTRACT_TYPE_2));
    }

    @ApiOperation("劳务合同")
    @GetMapping("/labor")
    public Result<List> laborContractHandler(){
        return  Result.success(contractService.contractHandler(ContractService.CONTRACT_TYPE_3));
    }

    @ApiOperation("采购合同")
    @GetMapping("/purchase")
    public Result<List> purchaseContractHandler(){
        return  Result.success(contractService.contractHandler(ContractService.CONTRACT_TYPE_4));
    }

    @ApiOperation("分包合同")
    @GetMapping("/sub")
    public Result<List> subContractHandler(){
        return  Result.success(contractService.contractHandler(ContractService.CONTRACT_TYPE_5));
    }

    @ApiOperation("合伙人合同")
    @GetMapping("/cobber")
    public Result<List> cobberContractHandler(){
        return  Result.success(contractService.contractHandler(ContractService.CONTRACT_TYPE_6));
    }
    @ApiOperation("合同收款计划")
    @GetMapping("/payPlan")
    public Result<List> payPlanContractHandler(){
        return  Result.success(contractService.payPlanContract());
    }
}
