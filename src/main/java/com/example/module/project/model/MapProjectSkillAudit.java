package com.example.module.project.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

//项目技术审核
@Data
public class MapProjectSkillAudit {
    private String parameter = StringUtils.EMPTY;
    private String performance = StringUtils.EMPTY;
    private String attestation = StringUtils.EMPTY;
    private String ability = StringUtils.EMPTY;
    private String devise = StringUtils.EMPTY;
    private String other = StringUtils.EMPTY;
    private String evaluationResult = StringUtils.EMPTY;
    private String evaluationConclusion = StringUtils.EMPTY;
    private String remarks = StringUtils.EMPTY;
    private String createBy = StringUtils.EMPTY;
    private String updateBy = StringUtils.EMPTY;
    private Date createTime ;
    private Date updateTime ;

}
