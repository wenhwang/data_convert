package com.example.module.financial.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 资金账号
 *
 * @pdOid 96055a40-dc4d-46c0-8add-36b6b5e01131
 */
@Data
public class FinanceCapitalAccount {
    /**
     * 资金账号ID
     *
     * @pdOid 0d4b185e-35a4-4d5d-a978-71feb764190f
     */
    @ExcelProperty("资金账号ID") private String accountId;
    /**
     * 银行账户名称
     *
     * @pdOid 3997e50f-ee31-4bd2-843d-addea81ed243
     */
    @ExcelProperty("银行账户名称") private String bankAccountName;
    /**
     * 银行账户编码
     *
     * @pdOid 2087368c-1cce-4a3b-ac88-f8ac91ed7ed8
     */
    @ExcelProperty("银行账户编码") private String sysNumber;
    /**
     * 银行账号
     *
     * @pdOid 877423e1-0022-441d-aa0f-18ac6fedcca2
     */
    @ExcelProperty("银行账号") private String bankAccount;
    /**
     * 银行网点名称
     *
     * @pdOid d8035d5e-2a22-464f-9a2a-e2ce85780931
     */
    @ExcelProperty("银行网点名称") private String bankName;
    /**
     * 记账货币
     *
     * @pdOid cfd339af-5e5b-4db4-bf81-610f543dcbb0
     */
    @ExcelProperty("记账货币") private String currency;
    /**
     * 记账货币编码
     *
     * @pdOid 49780c9a-365c-4562-9c52-eb74442ac725
     */
    @ExcelProperty("记账货币编码") private String currencyCode;
    /**
     * 账户资金类型id
     *
     * @pdOid a039833e-29aa-4a0e-addb-cbfb0c03d900
     */
    @ExcelProperty("账户资金类型id") private String accountTypeId;
    /**
     * 账户资金类型
     *
     * @pdOid 16fc72a8-94f5-4f12-8a5c-1b966aa0a5b7
     */
    @ExcelProperty("账户资金类型") private String accountType;
    /**
     * 银行账户类型id
     *
     * @pdOid f514a493-c47b-4c4c-8382-b9d00b1a6dce
     */
    @ExcelProperty("银行账户类型id") private String bankAccountTypeId;
    /**
     * 银行账户类型
     *
     * @pdOid b683e352-676d-478f-83b0-5b7958c563f3
     */
    @ExcelProperty("银行账户类型") private String bankAccountType;
    /**
     * 合伙人id
     *
     * @pdOid 80879a9e-4b6d-4aea-9b7e-0b0414e70c75
     */
    @ExcelProperty("合伙人id") private String partnerId;
    /**
     * 合伙人名称
     *
     * @pdOid 00a09f8e-8d20-486b-8b0e-d759fe96d32b
     */
    @ExcelProperty("合伙人名称") private String partnerName;
    /**
     * 业务员账号
     *
     * @pdOid 9fc34b2e-4a1e-4100-a3ce-c86873474b84
     */
    @ExcelProperty("业务员账号") private String businessUserName;
    /**
     * 业务员姓名
     *
     * @pdOid 13113a6c-9edb-432e-9479-692307ea6303
     */
    @ExcelProperty("业务员姓名") private String businessRealName;
    /**
     * 业务员部门id
     *
     * @pdOid 08f38ea8-d94d-4d05-81c2-e35d41de6d9c
     */
    @ExcelProperty("业务员部门id") private long businessDeptId;
    /**
     * 业务员部门名称
     *
     * @pdOid 056761fb-bb79-4e56-a085-71ad5c14d97a
     */
    @ExcelProperty("业务员部门名称") private long businessDept;
    /**
     * 是否允许负数 0:是 1:否
     *
     * @pdOid 75747cf5-73c6-407c-94b7-12c6f835a46f
     */
    @ExcelProperty("是否允许负数") private int isNegative;
    /**
     * 账户状态 0：正常 1：冻结 2：注销
     *
     * @pdOid ea1ce5b7-ffe8-44fc-bb8b-dcbbf58a9e4a
     */
    @ExcelProperty("状态") private String status;
    /**
     * 备注
     *
     * @pdOid d9aebe0d-a0aa-4188-8bed-9dc36d1c8df6
     */
    @ExcelProperty("备注") private String remarks;
    /**
     * 启用日期
     *
     * @pdOid 3820aafd-0bf7-43de-9f5e-a86bec9e6f89
     */
    @ExcelProperty("启用日期") private String startDate;
    /**
     * 冻结日期
     *
     * @pdOid f981244f-ea74-4825-9e78-f53010b41cb2
     */
    @ExcelProperty("冻结日期") private String freezeDate;
    /**
     * 注销日期
     *
     * @pdOid 55a534e3-bfd7-4669-a110-deb3095e34a4
     */
    @ExcelProperty("注销日期") private String cancelDate;
    /**
     * 是否删除 1:是；0:否
     *
     * @pdOid 0a8a124c-61ce-478d-822b-543bd1b932e9
     */
    @ExcelProperty("是否删除") private String delFlag = "0";
    /**
     * 创建人
     *
     * @pdOid 9d402bf4-a58d-4263-8f2a-39f922f34110
     */
    @ExcelProperty("创建人") private String createBy;
    /**
     * 修改人
     *
     * @pdOid 0082552a-c4ad-4993-a97d-ee8dde75b598
     */
    @ExcelProperty("修改人") private String updateBy;
    /**
     * 创建时间
     */
    @ExcelProperty("创建时间") private String createTime;
    /**
     * 修改时间
     */
    @ExcelProperty("修改时间") private String updateTime;
    @ExcelProperty("数据源") private String dataSource = "EPMS";
}