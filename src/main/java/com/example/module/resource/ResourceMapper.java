package com.example.module.resource;

import com.example.module.project.model.MapBidDocument;
import com.example.module.project.model.MapBidList;
import com.example.module.project.model.MapCloseBidDocument;
import com.example.module.project.model.MapContractCompany;
import com.example.module.project.model.MapDeposit;
import com.example.module.project.model.MapLaborTeamList;
import com.example.module.project.model.MapMakeBidDocument;
import com.example.module.project.model.MapManageCompany;
import com.example.module.project.model.MapProjectBusinessAudit;
import com.example.module.project.model.MapProjectQualificationAudit;
import com.example.module.project.model.MapProjectSkillAudit;
import com.example.module.project.model.MapWinBidResultAnalyse;
import com.example.module.project.model.ProjectAgreement;
import com.example.module.project.model.ProjectAnswer;
import com.example.module.project.model.ProjectBid;
import com.example.module.project.model.ProjectInfo;
import com.example.module.resource.model.ArchiveApply;
import com.example.module.resource.model.ArchiveFile;
import com.example.module.resource.model.ArchiveLendLog;
import com.example.module.resource.model.ArchiveManage;
import com.example.module.resource.model.ArchiveManageNew;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ResourceMapper {


    //资源大类
    List<Map<String, String>> selectResourceCategoryParent();

    //资源小类
    List<String> selectResourceCategoryChild(String resouceCategoryId);

    //申请单
    List<ArchiveApply> selectApplyReceipts();

    //附件
    List<ArchiveFile> selectAttachements();

    //公司证照
    List<ArchiveManage> selectCompanyCerts();

    //人员证照
    List<ArchiveManage> selectEmplyeeCerts();

    //印章证照
    List<ArchiveManage> selectStampCerts();

    //招投标账户
    List<ArchiveManage> selectBidAccounts();

    //项目业绩
    List<ArchiveManage> selectProjectPerformances();

    //项目业绩-new
    List<ArchiveManageNew> selectNewProjectPerformances();


    //档案使用记录
    List<ArchiveLendLog> selectCmpEmyStampRecords();

    //招投标账户使用记录
    List<ArchiveLendLog> selectBidAccountRecords();

    //项目业绩使用记录
    List<ArchiveLendLog> selectProjectPerformanceRecors();

    //申请单明细借出状态
    Map<String, String> selectApplyReceiptDetail(String applyId);

    //申请单实际归还时间
    Map<String, Date> selectApplyReceiptReturnTime(String applyId);
}
