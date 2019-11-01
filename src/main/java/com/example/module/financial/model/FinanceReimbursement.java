package com.example.module.financial.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class FinanceReimbursement {
    private String reimbursementId = StringUtils.EMPTY;
    private String sysNumber = StringUtils.EMPTY;
    private String typeId = StringUtils.EMPTY;
    private String typeName = StringUtils.EMPTY;
    private String applyNumber = StringUtils.EMPTY;
    private String applyUser = StringUtils.EMPTY;
    private String departmentId = StringUtils.EMPTY;
    private String departmentName = StringUtils.EMPTY;
    private String settlementWayId = StringUtils.EMPTY;
    private String settlementWay = StringUtils.EMPTY;
    private String projectId = StringUtils.EMPTY;
    private String projectName = StringUtils.EMPTY;
    private String projectBalance = StringUtils.EMPTY;
    private String partnerId = StringUtils.EMPTY;
    private String partnerName = StringUtils.EMPTY;
    private String accountName = StringUtils.EMPTY;
    private String bankName = StringUtils.EMPTY;
    private String bankAccount = StringUtils.EMPTY;
    private double applyAmount;
    private double actualPaymentAmount;
    private String areaName = StringUtils.EMPTY;
    private String purpose = StringUtils.EMPTY;
    private String delFlag = "0";
    private String status = "0";
    private String createBy = StringUtils.EMPTY;
    private String updateBy = StringUtils.EMPTY;
    private Date createTime;
    private Date updateTime;
    private String files = StringUtils.EMPTY;

    private List<MapCostList> costList = new ArrayList<>();
    private String dataSource = "EPMS";
}
