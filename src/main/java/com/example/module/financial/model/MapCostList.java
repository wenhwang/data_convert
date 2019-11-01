package com.example.module.financial.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class MapCostList {
    private String addDate;
    private String costTypeId = StringUtils.EMPTY;
    private String costTypeName = StringUtils.EMPTY;
    private String reimbursementUserName = StringUtils.EMPTY;
    private String reimbursementRealName = StringUtils.EMPTY;
    private String bearDepartmentId = StringUtils.EMPTY;
    private String bearDepartmentName = StringUtils.EMPTY;
    private double applyAmount;
    private String taxRate = StringUtils.EMPTY;
    private String taxAmount = StringUtils.EMPTY;
}
