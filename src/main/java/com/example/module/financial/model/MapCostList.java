package com.example.module.financial.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class MapCostList {
    @ExcelProperty("报销id") private String reimbursementId = StringUtils.EMPTY;
    @ExcelProperty("发生日期")private String addDate;
    @ExcelProperty("费用类别id")private String costTypeId = StringUtils.EMPTY;
    @ExcelProperty("费用类别名称")private String costTypeName = StringUtils.EMPTY;
    @ExcelProperty("实际报销人账号")private String reimbursementUserName = StringUtils.EMPTY;
    @ExcelProperty("实际报销人真实姓名")private String reimbursementRealName = StringUtils.EMPTY;
    @ExcelProperty("承担部门id")private String bearDepartmentId = StringUtils.EMPTY;
    @ExcelProperty("承担部门名称")private String bearDepartmentName = StringUtils.EMPTY;
    @ExcelProperty("申请金额")private double applyAmount;
    @ExcelProperty("可抵扣税率")private double taxRate;
    @ExcelProperty("可抵扣税额")private double taxAmount;
}
