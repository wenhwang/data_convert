package com.example.module.customer.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Cust {

    @ExcelProperty("客户ID")private String customerId = StringUtils.EMPTY;
    @ExcelProperty("客户编码")private String customerCode = StringUtils.EMPTY;
    @ExcelProperty("客户名称")private String customerName = StringUtils.EMPTY;
    @ExcelProperty("客户简称")private String customerAbbreviation = StringUtils.EMPTY;
    @ExcelProperty("客户类型ID")private String customerTypeId = StringUtils.EMPTY;
    @ExcelProperty("客户类型")private String customerType = StringUtils.EMPTY;
    @ExcelProperty("所属行业ID")private String industryId = StringUtils.EMPTY;
    @ExcelProperty("所属行业")private String industry = StringUtils.EMPTY;
    @ExcelProperty("所属专业ID")private String majorTypeId = StringUtils.EMPTY;
    @ExcelProperty("所属专业")private String majorType = StringUtils.EMPTY;
    @ExcelProperty("客户特征ID")private String featureId = StringUtils.EMPTY;
    @ExcelProperty("客户特征")private String feature = StringUtils.EMPTY;
    @ExcelProperty("客户状态ID")private String statusId = StringUtils.EMPTY;
    @ExcelProperty("客户状态")private String status = StringUtils.EMPTY;
    @ExcelProperty("客户性质ID")private String natureId = StringUtils.EMPTY;
    @ExcelProperty("客户性质")private String nature = StringUtils.EMPTY;
    @ExcelProperty("客户等级ID")private String levelId = StringUtils.EMPTY;
    @ExcelProperty("客户等级")private String level = StringUtils.EMPTY;
    @ExcelProperty("客户来源ID")private String sourceId = StringUtils.EMPTY;
    @ExcelProperty("客户来源")private String source = StringUtils.EMPTY;
    @ExcelProperty("主要联系人")private String contacts = StringUtils.EMPTY;
    @ExcelProperty("联系电话")private String phone = StringUtils.EMPTY;
    @ExcelProperty("省份")private String province = StringUtils.EMPTY;
    @ExcelProperty("市")private String city = StringUtils.EMPTY;
    @ExcelProperty("区县")private String county = StringUtils.EMPTY;
    @ExcelProperty("详细地址")private String address = StringUtils.EMPTY;
    @ExcelProperty("账户名称")private String accountName = StringUtils.EMPTY;
    @ExcelProperty("开户行")private String bankName = StringUtils.EMPTY;
    @ExcelProperty("银行账号")private String bankAccount = StringUtils.EMPTY;
    @ExcelProperty("客户官网")private String website = StringUtils.EMPTY;
    @ExcelProperty("介绍")private String introduce = StringUtils.EMPTY;
    @ExcelProperty("备注")private String remarks = StringUtils.EMPTY;
    @ExcelProperty("负责人ID")private String dutyUserId = StringUtils.EMPTY;
    @ExcelProperty("负责人姓名")private String dutyUserName = StringUtils.EMPTY;
    @ExcelProperty("是否公海客户")private String isSeas = StringUtils.EMPTY;
    @ExcelProperty("创建人")private String createBy = StringUtils.EMPTY;
    @ExcelProperty("修改人")private String updateBy = StringUtils.EMPTY;
    @ExcelProperty("创建时间")private Date createTime ;
    @ExcelProperty("修改时间")private Date updateTime ;
    @ExcelIgnore private List<MapCustAccount> accountList = new ArrayList<>();
    @ExcelProperty("是否删除")private String delFlag = "0";
    @ExcelProperty("数据源")private String dataSource = "EPMS";

}
