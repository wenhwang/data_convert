package com.example.module.customer.export;


import com.example.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "客户数据-Export")
@RequestMapping("/cust-export")
public class CustomerExportController {

    @Autowired
    private CustomerExportService customerService;

    @ApiOperation("合伙人")
    @GetMapping("/cobber")
    public Result<List> cobberHandler() {
        return Result.success(customerService.customerHandler("合伙人"));
    }

    @ApiOperation("业主")
    @GetMapping("/subject")
    public Result<List> subjectPersonHandler() {
        return Result.success(customerService.customerHandler("业主"));
    }

    @ApiOperation("招投标单位")
    @GetMapping("/tender")
    public Result<List> tenderCompanyHandler() {
        return Result.success(customerService.customerHandler("招投标单位"));
    }


    @ApiOperation("劳务单位")
    @GetMapping("/labour")
    public Result<List> labourCompanyHandler() {
        return Result.success(customerService.customerHandler("劳务单位"));
    }

    @ApiOperation("公海客户")
    @GetMapping("/seas")
    public Result<List> seasHandler() {
        return Result.success(customerService.seasHandler());
    }
}

