package com.example.module.customer.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

@Data
public class Customer {

    private String isSeas = "1";
    //     客户名称
    @ExcelProperty("客户名称")
    private String customerName = StringUtils.EMPTY;
    //    主要联系人
    @ExcelProperty("主要联系人")
    private String contacts = StringUtils.EMPTY;
    //    客户电话
    @ExcelProperty("客户电话")
    private String phone = StringUtils.EMPTY;

    //    客户类型
    private String customerTypeId = StringUtils.EMPTY;
    @ExcelProperty(value = "客户类型",converter = MapCodeConverter.class)
    private String customerType = StringUtils.EMPTY;
    //    所属专业
    private String majorTypeId = StringUtils.EMPTY;
    @ExcelProperty(value = "所属专业",converter = MapCodeConverter.class)
    private String majorType = StringUtils.EMPTY;
    //    客户特征
    private String featureId = StringUtils.EMPTY;
    @ExcelProperty(value = "客户特征",converter = MapCodeConverter.class)
    private String feature = StringUtils.EMPTY;
    //    客户状态
    @ExcelProperty(value = "客户状态",converter = MapCodeConverter.class)
    private String status = StringUtils.EMPTY;
    private String statusId = StringUtils.EMPTY;
    //    客户性质
    @ExcelProperty(value = "客户性质",converter = MapCodeConverter.class)
    private String natures = StringUtils.EMPTY;
    private String natureId = StringUtils.EMPTY;
    //    客户分级
    @ExcelProperty(value = "客户分级",converter = MapCodeConverter.class)
    private String level = StringUtils.EMPTY;
    private String levelId = StringUtils.EMPTY;
    //    客户行业
    @ExcelProperty(value = "客户行业",converter = MapCodeConverter.class)
    private String industry = StringUtils.EMPTY;
    private String industryId = StringUtils.EMPTY;
    //    省
    @ExcelProperty("省")
    private String province = StringUtils.EMPTY;
    //    市
    @ExcelProperty("市")
    private String city = StringUtils.EMPTY;
    //    区/县
    @ExcelProperty("区/县")
    private String county = StringUtils.EMPTY;
    //    详细地址
    @ExcelProperty("详细地址")
    private String address = StringUtils.EMPTY;
    //    客户来源
    @ExcelProperty(value = "客户来源",converter = MapCodeConverter.class)
    private String source = StringUtils.EMPTY;
    private String sourceId = StringUtils.EMPTY;
    //    客户简介
    @ExcelProperty("客户简介")
    private String introduce = StringUtils.EMPTY;
    //    创建人
    //@ExcelProperty("创建人")
    private String createBy = "zw@zhonghui.com";
    //    前负责人
    @ExcelProperty("前负责人")
    private String dutyUserName = StringUtils.EMPTY;
    //    创建时间
    @ExcelProperty(value = "创建时间",converter = StringToDateConvert.class)
    private Date createTime;
    //     修改时间
    @ExcelProperty(value = "修改时间",converter = StringToDateConvert.class)
    private Date updateTime;
    private String delFlag= "0";
    private String dataSource = "EPMS";
}
