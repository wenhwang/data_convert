package com.example.module.system.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("sys_org")
@Data
public class SysOrg {
    private String masterId;
    private String createBy;
    private String orgName;
    private Date createTime = new Date();
    private String remark;
    private String delFlag;
    private String parentId;
    private String orgId;
    private String masterName;
}
