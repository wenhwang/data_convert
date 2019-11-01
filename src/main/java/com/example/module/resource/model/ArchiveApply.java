package com.example.module.resource.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class ArchiveApply {
    private String sysNumber =  StringUtils.EMPTY;
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
    private String userBy = StringUtils.EMPTY;
    private String createBy = StringUtils.EMPTY;
    private Date createTime;
    private String updateBy = StringUtils.EMPTY;
    private Date updateTime;
    private String applyId = StringUtils.EMPTY;
    private List<Map> certificates = new ArrayList<>();
    private String status = StringUtils.EMPTY;
    private String applyBy = StringUtils.EMPTY;
    private String delFlag = "0";
    private String dataSource = "EPMS";
    private Date applyDate;
    private String applyByRealName = StringUtils.EMPTY;
    private String useStatus = StringUtils.EMPTY;
}
