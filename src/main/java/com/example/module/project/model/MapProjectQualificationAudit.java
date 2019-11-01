package com.example.module.project.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

//项目资格审核
@Data
public class MapProjectQualificationAudit {
    private  String evaluationResult = StringUtils.EMPTY;
    private  String evaluationConclusion = StringUtils.EMPTY;
    private  String remarks = StringUtils.EMPTY;
    private  String createBy = StringUtils.EMPTY;
    private  String updateBy = StringUtils.EMPTY;
    private  String createTime = StringUtils.EMPTY;
    private  String updateTime = StringUtils.EMPTY;

}
