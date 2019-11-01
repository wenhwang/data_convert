package com.example.module.resource.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

@Data
public class ArchiveLendLog {
    private String lendId = StringUtils.EMPTY;
    private String applyId = StringUtils.EMPTY;
    private String archiveId = StringUtils.EMPTY;
    private String sysNumber = StringUtils.EMPTY;
    private String archiveName = StringUtils.EMPTY;
    private String useStatus = StringUtils.EMPTY;
    private String projectId = StringUtils.EMPTY;
    private String projectName = StringUtils.EMPTY;
    private String partnerName = StringUtils.EMPTY;
    private String partnerId = StringUtils.EMPTY;
    private String ownerId = StringUtils.EMPTY;
    private String ownerName = StringUtils.EMPTY;
    private String orgName = StringUtils.EMPTY;
    private Date expectLendTime;
    private Date expectReturnTime;
    private Date actualReturnTime;
    private String use = StringUtils.EMPTY;
    private String createBy = StringUtils.EMPTY;
    private Date createTime;
    private String updateBy = StringUtils.EMPTY;
    private Date updateTime;
    private String applyStatus = StringUtils.EMPTY;
    private String status = StringUtils.EMPTY;
    private String userBy = StringUtils.EMPTY;
    private String remarks = StringUtils.EMPTY;
    private String accountId = StringUtils.EMPTY;
    private String accountCode = StringUtils.EMPTY;
    private String accountName = StringUtils.EMPTY;
    private String accountType = StringUtils.EMPTY;
    private String accountTypeId = StringUtils.EMPTY;
    private String area = StringUtils.EMPTY;
    private String biddingWebSite = StringUtils.EMPTY;
    private String account = StringUtils.EMPTY;
    private String delFlag = "0";
    private String dataSource = "EPMS";

}
