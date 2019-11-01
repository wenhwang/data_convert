package com.example.module.project;

import com.example.module.project.model.ProjectAgreement;
import com.example.module.project.model.ProjectBid;
import com.example.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "项目数据维护")
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @ApiOperation("项目基本信息")
    @GetMapping("/info")
    public Result<List> projectInfoHandler(){
        return  Result.success(projectService.projectInfoHandler());
    }


    @ApiOperation("招投标信息")
    @GetMapping("/tender")
    public Result<List<ProjectBid>> tenderInfoHandler(){
        return  Result.success(projectService.tenderInfoHandler());
    }

    @ApiOperation("工程项目")
    @GetMapping("/agreement")
    public Result<List<ProjectAgreement>> agreementHandler(){
        return  Result.success(projectService.agreementHandler());
    }


}
