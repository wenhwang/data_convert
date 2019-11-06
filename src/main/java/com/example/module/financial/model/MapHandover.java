package com.example.module.financial.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
//外经证交接信息
@Data
public class MapHandover {
    @ExcelProperty("外经证ID") private String businessLicenseId = StringUtils.EMPTY;
    @ExcelProperty("交接方式id")
    private String handoverWayId = StringUtils.EMPTY;
    @ExcelProperty("交接方式名称")
    private String handoverWayName = StringUtils.EMPTY;
    @ExcelProperty("快递公司")
    private String expressCompany = StringUtils.EMPTY;
    @ExcelProperty("快递单号")
    private String expressNumber = StringUtils.EMPTY;
    @ExcelProperty("备注")
    private String remarks = StringUtils.EMPTY;
}
