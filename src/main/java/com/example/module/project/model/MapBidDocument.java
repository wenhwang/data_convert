package com.example.module.project.model;


import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

//招标文件解读
@Data
public class MapBidDocument {
    private String projectId = StringUtils.EMPTY;
    private  String controlPrice = StringUtils.EMPTY;
    private  String serviceFee = StringUtils.EMPTY;
    private  Date openTime ;
    private  String openWayId = StringUtils.EMPTY;
    private  String openWay = StringUtils.EMPTY;
    private  String openAddress = StringUtils.EMPTY;
    private  String commentWayId = StringUtils.EMPTY;
    private  String commentWay = StringUtils.EMPTY;
    private  String bidBrand = StringUtils.EMPTY;
    private  double marginAmount;
    private  String receivablesCompany = StringUtils.EMPTY;
    private  String evaluationResult = StringUtils.EMPTY;
    private  String auditOpinion = StringUtils.EMPTY;
    private  String createBy = StringUtils.EMPTY;
    private  String updateBy = StringUtils.EMPTY;
    private Date createTime ;
    private  Date updateTime ;
}
