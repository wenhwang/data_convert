package com.example.module.project.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("project_info")
public class ProjectInfo {
    private String projectId = StringUtils.EMPTY;
    private String sysNumber= StringUtils.EMPTY;
    private String projectName= StringUtils.EMPTY;
    private String budgetAmount= StringUtils.EMPTY;
    private String customerPhone= StringUtils.EMPTY;
    private String projectTypeId= StringUtils.EMPTY;
    private String projectTypeName= StringUtils.EMPTY;
    private String projectNatureId= StringUtils.EMPTY;
    private String projectNatureName= StringUtils.EMPTY;
    private String projectSourceId= StringUtils.EMPTY;
    private String projectSourceName= StringUtils.EMPTY;
    private String endTime= StringUtils.EMPTY;
    private String province= StringUtils.EMPTY;
    private String city= StringUtils.EMPTY;
    private String county= StringUtils.EMPTY;
    private String provinceCode= StringUtils.EMPTY;
    private String cityCode= StringUtils.EMPTY;
    private String countyCode= StringUtils.EMPTY;
    private String isBid= StringUtils.EMPTY;
    private String projectArea= StringUtils.EMPTY;
    private String bidBrand= StringUtils.EMPTY;
    private String enrollWebsite= StringUtils.EMPTY;
    private String tenderWebsite= StringUtils.EMPTY;
    private String competitor= StringUtils.EMPTY;
    private String competeBrand= StringUtils.EMPTY;
    private String departmentId= StringUtils.EMPTY;
    private String department= StringUtils.EMPTY;
    private String ownerId= StringUtils.EMPTY;
    private String ownerName= StringUtils.EMPTY;
    private String ownerPhone= StringUtils.EMPTY;
    private String partnerId= StringUtils.EMPTY;
    private String partnerName= StringUtils.EMPTY;
    private String partnerPhone= StringUtils.EMPTY;
    private String projectSummary= StringUtils.EMPTY;
    private String projectLogo= StringUtils.EMPTY;
    private String createBy= StringUtils.EMPTY;
    private String updateBy= StringUtils.EMPTY;
    private String createTime= StringUtils.EMPTY;
    private String updateTime= StringUtils.EMPTY;
    private String businessUserName= StringUtils.EMPTY;
    private String businessUserId= StringUtils.EMPTY;
    private String delFlag= StringUtils.EMPTY;
    private String status= StringUtils.EMPTY;
    private String dataSource = "EPMS";
}
