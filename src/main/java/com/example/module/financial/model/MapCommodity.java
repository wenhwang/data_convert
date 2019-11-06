package com.example.module.financial.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
//收票-商品明细
@Data
public class MapCommodity {
    @ExcelProperty("收票id") private String receiveInvoiceId = StringUtils.EMPTY;
    @ExcelProperty("商品id")
    private String commodityId = StringUtils.EMPTY;
    @ExcelProperty("商品编码")
    private String commodityCode = StringUtils.EMPTY;
    @ExcelProperty("商品名称")
    private String commodityName = StringUtils.EMPTY;
    @ExcelProperty("规格型号")
    private String model = StringUtils.EMPTY;
    @ExcelProperty("单位")
    private String unit = StringUtils.EMPTY;
    @ExcelProperty("品牌")
    private String brand = StringUtils.EMPTY;
    @ExcelProperty("数量")
    private int number;
    @ExcelProperty("单价")
    private double unitPrice;
    @ExcelProperty("金额")
    private double amount;
    @ExcelProperty("税率")
    private double taxRate;
    @ExcelProperty("税额")
    private double taxAmount;
    @ExcelProperty("价税合计")
    private double totalAmount;

}
