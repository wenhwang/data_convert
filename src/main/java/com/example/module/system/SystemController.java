package com.example.module.system;

import com.example.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "系统基础数据维护")
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private SystemService systemService;


    @ApiOperation("ALLEPMS-清空导入数据")
    @GetMapping("/clearAllEPMS")
    public Result<List<String>> clearAllEPMS() {
        return Result.<List<String>>success(systemService.clearAllEPMS());
    }

    @ApiOperation("ALL-清空所有数据")
    @GetMapping("/clearAll")
    public Result<List<String>> clearAll() {
        return Result.<List<String>>success(systemService.clearAll());
    }

    @ApiOperation("客户-清空导入数据")
    @GetMapping("/clearCustomer")
    public Result<List<String>> clearCustomer() {
        return Result.<List<String>>success(systemService.clearCustomer());
    }

    @ApiOperation("项目-清空导入数据")
    @GetMapping("/clearProject")
    public Result<List<String>> clearProject() {
        return Result.<List<String>>success(systemService.clearProject());
    }

    @ApiOperation("合同-清空导入数据")
    @GetMapping("/clearContract")
    public Result<List<String>> clearContract() {
        return Result.<List<String>>success(systemService.clearContract());
    }

    @ApiOperation("资源-清空导入数据")
    @GetMapping("/clearResource")
    public Result<List<String>> clearResource() {
        return Result.<List<String>>success(systemService.clearResource());
    }

    @ApiOperation("财务-清空导入数据")
    @GetMapping("/clearFinance")
    public Result<List<String>> clearFinance() {
        return Result.<List<String>>success(systemService.clearFinance());
    }

    @ApiOperation("供应-清空导入数据")
    @GetMapping("/clearSupply")
    public Result<List<String>> clearSupply() {
        return Result.<List<String>>success(systemService.clearSupply());
    }




}
