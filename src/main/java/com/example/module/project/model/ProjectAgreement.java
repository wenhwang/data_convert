package com.example.module.project.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.UUID;

@Data
public class ProjectAgreement {
    private String agreementId =  UUID.randomUUID().toString().replace("-","");
    private String projectId = StringUtils.EMPTY;
    private String status = StringUtils.EMPTY;
    private String planSpeed = StringUtils.EMPTY;
    private String remarks = StringUtils.EMPTY;
    private String createBy = StringUtils.EMPTY;
    private String updateBy = StringUtils.EMPTY;
    private Date createTime;
    private Date updateTime;
    private String delFlag = "0";
    private MapAgreement projectMap = new MapAgreement();
    private String dataSource = "EPMS";

}
