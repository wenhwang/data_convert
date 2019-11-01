package com.example.module.project.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

//项目商务评审
@Data
public class MapProjectBusinessAudit {
    private String paymentWay = StringUtils.EMPTY;
    private String constructionPeriod = StringUtils.EMPTY;
    private String warrantyPeriod = StringUtils.EMPTY;
    private String guaranteeWayId = StringUtils.EMPTY;
    private String guaranteeWay = StringUtils.EMPTY;
    private String guaranteeAmount = StringUtils.EMPTY;
    private String reputation = StringUtils.EMPTY;
    private String evaluationResult = StringUtils.EMPTY;
    private String evaluationConclusion = StringUtils.EMPTY;
    private String remarks = StringUtils.EMPTY;
    private String createBy = StringUtils.EMPTY;
    private String updateBy = StringUtils.EMPTY;
    private Date createTime;
    private Date updateTime;

}
