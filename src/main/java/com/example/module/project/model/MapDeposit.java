package com.example.module.project.model;


import lombok.Data;
import org.apache.commons.lang3.StringUtils;

//缴纳保证金
@Data
public class MapDeposit {
    private  String bankName = StringUtils.EMPTY;
    private  String bankAccount = StringUtils.EMPTY;
    private  String accountName = StringUtils.EMPTY;
    private  String remarks = StringUtils.EMPTY;
    private  String payWayId = StringUtils.EMPTY;
    private  String payWay = StringUtils.EMPTY;
    private  String endTime = StringUtils.EMPTY;
    private  String isReplace = StringUtils.EMPTY;
    private  String realityPayTime = StringUtils.EMPTY;
    private  String receiptUrl = StringUtils.EMPTY;
    private  String createBy = StringUtils.EMPTY;
    private  String updateBy = StringUtils.EMPTY;
    private  String createTime = StringUtils.EMPTY;
    private  String updateTime = StringUtils.EMPTY;

}
