package com.example.module.financial.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class MapPayTax {
    @ExcelProperty("外经证ID") private String businessLicenseId = StringUtils.EMPTY;
    @ExcelProperty("交接方式id")
    private String handoverWayId = StringUtils.EMPTY;
    @ExcelProperty("交接方式名称")
    private String handoverWayName = StringUtils.EMPTY;
    @ExcelProperty("快递公司")
    private String expressCompany = StringUtils.EMPTY;
    @ExcelProperty("快递单号")
    private String expressNumber = StringUtils.EMPTY;
    @ExcelProperty("领取人")
    private String receiveUser = StringUtils.EMPTY;
    @ExcelProperty("完税金额")
    private double payTaxAmount;
    @ExcelProperty("完税税额")
    private double taxAmount;
    @ExcelProperty("备注")
    private String remarks = StringUtils.EMPTY;

}
