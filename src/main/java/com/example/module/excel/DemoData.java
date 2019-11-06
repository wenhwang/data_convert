package com.example.module.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DemoData {
    @ExcelProperty("字段名称")
    private String fieldName;

    @ExcelProperty("字段code")
    private String fieldCode;

    @ExcelProperty("字段值")
    private double fieldVal;
}
