package com.example.module.financial.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 往来管理
 *
 * @pdOid 2260ab0b-e15b-43a3-9d06-fe38287ba637
 */
@Data
public class FinanceAdjustment {
    /**
     * 调整单ID
     *
     * @pdOid 9f4d264c-e5fe-4144-acd7-d138fee81df9
     */
    @ExcelProperty("调整单ID") private String adjustmentId = StringUtils.EMPTY;
    /**
     * 调整单业务号
     *
     * @pdOid 8e4d5ff2-ff6b-4185-bf2e-4db24f5f3c1d
     */
    @ExcelProperty("调整单业务号") private String sysNumber = StringUtils.EMPTY;
    /**
     * 项目id
     *
     * @pdOid fb134b95-0812-4d97-bf1b-44b4103a2ed8
     */
    @ExcelProperty("项目id") private String projectId = StringUtils.EMPTY;
    /**
     * 项目名称
     *
     * @pdOid 654e11c7-cc01-4b09-a671-ef94c50983fa
     */
    @ExcelProperty("项目名称") private String projectName = StringUtils.EMPTY;
    /**
     * 业务类型id
     *
     * @pdOid 552c5744-40b2-4842-8c39-5c3c7ba78f87
     */
    @ExcelProperty("业务类型id") private String typeId = StringUtils.EMPTY;
    /**
     * 业务类型名称
     *
     * @pdOid ef02184c-31a3-4a48-b961-77f147a83736
     */
    @ExcelProperty("业务类型名称") private String typeName = StringUtils.EMPTY;
    /**
     * 单位名称
     *
     * @pdOid 0d79e32b-276e-471b-b058-b936e8456409
     */
    @ExcelProperty("单位名称") private String companyName = StringUtils.EMPTY;
    /**
     * 调整对象id
     *
     * @pdOid 46b9df34-114c-4b5b-8c5f-b496575febff
     */
    @ExcelProperty("调整对象id") private String objectId = StringUtils.EMPTY;
    /**
     * 调整对象
     *
     * @pdOid 9a2aa21e-04f0-4a53-ad28-8503698b11d2
     */
    @ExcelProperty("调整对象") private String objectName = StringUtils.EMPTY;
    /**
     * 调整前对象
     *
     * @pdOid 7b0d0719-6a5b-4dd9-96f4-dc2d03235bb9
     */
    @ExcelProperty("调整前对象") private String overObject = StringUtils.EMPTY;
    /**
     * 调整后对象
     *
     * @pdOid d7c2751c-61f0-4ca1-afcc-44133ce1860a
     */
    @ExcelProperty("调整后对象") private String afterObject = StringUtils.EMPTY;
    /**
     * 申请日期
     *
     * @pdOid 62bef834-1443-42c6-a3dc-93c208d8b1dc
     */
    @ExcelProperty("申请日期") private Date applyDate;
    /**
     * 申请人
     *
     * @pdOid 73a8e91b-f7dd-4f43-b8e1-a6befa8f104c
     */
    @ExcelProperty("申请人") private String applyUser = StringUtils.EMPTY;
    /**
     * 申请部门id
     *
     * @pdOid 6580423b-3c0f-49e2-a0ae-1b43dff693b9
     */
    @ExcelProperty("申请部门id") private String applyDepartmentId = StringUtils.EMPTY;
    /**
     * 申请部门名称
     *
     * @pdOid 50d69672-5d61-48bc-9389-0dbd1de9e450
     */
    @ExcelProperty("申请部门名称") private String applyDepartmentName = StringUtils.EMPTY;
    /**
     * 调整金额
     *
     * @pdOid 6c9d3f10-3ec3-408f-9afb-e0c2842e33db
     */
    @ExcelProperty("调整金额") private double amount;
    /**
     * 账套主体
     *
     * @pdOid d121af87-fd23-48b9-a4e8-8cdd132cf0c5
     */
    @ExcelProperty("账套主体") private String accountSubject = StringUtils.EMPTY;
    /**
     * 附件集合
     *
     * @pdOid 5b0f89d6-9a59-4e99-85a0-0f34a39df53a
     */
    @ExcelIgnore
    private List<Map> files = new ArrayList<>();
    /**
     * 备注
     *
     * @pdOid b881c023-6c1d-4b4f-8a88-22ab81a6bbd2
     */
    @ExcelProperty("备注") private String remarks = StringUtils.EMPTY;
    /**
     * 状态 0：待审核 1：审核中 2：待转款 3：已完成 4：审核不通过 5：已撤销
     *
     * @pdOid d2512a2b-5a2e-4458-83a5-94bdddaf84d5
     */
    @ExcelProperty("状态") private String status = "3";
    /**
     * 是否删除 1:是；0:否
     *
     * @pdOid 671c5ed5-108d-44f3-a1ee-92642901e84b
     */
    @ExcelProperty("是否删除") private String delFlag = StringUtils.EMPTY;
    /**
     * 创建人
     *
     * @pdOid 1e463dd0-1363-4a07-bc3d-3f7ee85ea1a2
     */
    @ExcelProperty("创建人") private String createBy = StringUtils.EMPTY;
    /**
     * 修改人
     *
     * @pdOid 5104e166-59ce-4d3b-b7be-4eae7be4c30a
     */
    @ExcelProperty("修改人") private String updateBy = StringUtils.EMPTY;
    /**
     * 创建时间
     *
     * @pdOid f209b612-5f91-4ad0-b002-34b2c16b1a30
     */
    @ExcelProperty("创建时间") private Date createTime;
    /**
     * 修改时间
     *
     * @pdOid 7c42bc7a-fa95-49a1-aa83-08f4185e0246
     */
    @ExcelProperty("修改时间") private Date updateTime;

    @ExcelProperty("数据源") private String dataSource = "EPMS";
}