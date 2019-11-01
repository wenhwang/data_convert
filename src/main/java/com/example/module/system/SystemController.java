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


    @ApiOperation("清空所有导入数据")
    @GetMapping("/cobber")
    public Result<List<String>> clearAll() {
        return Result.<List<String>>success(systemService.clearAll());
    }


}
