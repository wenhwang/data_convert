package com.example.module.resource;

import com.example.module.resource.model.ArchiveApply;
import com.example.module.resource.model.ArchiveFile;
import com.example.module.resource.model.ArchiveLendLog;
import com.example.module.resource.model.ArchiveManage;
import com.example.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "资源中心数据维护")
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;


    @ApiOperation("资源分类")
    @GetMapping("/category")
    public Result<List> categoryHandler() {
        return Result.success(resourceService.categoryHandler());
    }


    @ApiOperation("附件")
    @GetMapping("/attachement")
    public Result<List<ArchiveFile>> attachementHandler() {
        return Result.<List<ArchiveFile>>success(resourceService.attachementHandler());
    }

    @ApiOperation("申请单")
    @GetMapping("/applyReceipt")
    public Result<List<ArchiveApply>> applyReceiptHandler() {
        return Result.<List<ArchiveApply>>success(resourceService.applyReceiptHandler());
    }

    //公司证照
    @ApiOperation("公司证照")
    @GetMapping("/companyCert")
    public Result<List<ArchiveManage>> companyCertHandler() {
        return Result.<List<ArchiveManage>>success(resourceService.companyCertHandler());
    }

    //人员证照
    @ApiOperation("人员证照")
    @GetMapping("/emplyeeCert")
    public Result<List<ArchiveManage>> emplyeeCertHandler() {
        return Result.<List<ArchiveManage>>success(resourceService.emplyeeCertHandler());
    }

    //印章证照
    @ApiOperation("印章证照")
    @GetMapping("/stampCert")
    public Result<List<ArchiveManage>> stampCertHandler() {
        return Result.<List<ArchiveManage>>success(resourceService.stampCertHandler());
    }

    //招投标账户
    @ApiOperation("招投标账户")
    @GetMapping("/bidAccount")
    public Result<List<ArchiveManage>> bidAccountHandler() {
        return Result.<List<ArchiveManage>>success(resourceService.bidAccountHandler());
    }

    //项目业绩
    @ApiOperation("项目业绩")
    @GetMapping("/projectPerformance")
    public Result<List<ArchiveManage>> projectPerformanceHandler() {
        return Result.<List<ArchiveManage>>success(resourceService.projectPerformanceHandler());
    }


    //档案使用记录
    @ApiOperation("档案使用记录")
    @GetMapping("/cmpEmyStampRecord")
    public Result<List<ArchiveLendLog>> cmpEmyStampRecordHandler() {
        return Result.<List<ArchiveLendLog>>success(resourceService.cmpEmyStampRecordHandler());
    }


    //项目业绩使用记录
    @ApiOperation("招投标账户使用记录")
    @GetMapping("/bidAccountRecord")
    public Result<List<ArchiveLendLog>> bidAccountRecordHandler() {
        return Result.<List<ArchiveLendLog>>success(resourceService.bidAccountRecordHandler());
    }


    //项目业绩使用记录
    @ApiOperation("项目业绩使用记录")
    @GetMapping("/projectPerformanceRecord")
    public Result<List<ArchiveLendLog>> projectPerformanceRecordandler() {
        return Result.<List<ArchiveLendLog>>success(resourceService.projectPerformanceRecordandler());
    }


}
