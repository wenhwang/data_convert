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
 * 收票
 *
 * @pdOid 93fe008e-d56d-40af-a7ac-d1da6a898fb3
 */
@Data
public class FinanceReceiveInvoice {
    /**
     * 收票id
     *
     * @pdOid 32097573-066d-436b-a7a8-79a259bca8b8
     */
    @ExcelProperty("收票id")
    private String receiveInvoiceId = StringUtils.EMPTY;
    @ExcelProperty("收票编号")
    private String sysNumber = StringUtils.EMPTY;
    /**
     * 项目id
     *
     * @pdOid eb824534-0f1e-498a-b760-40fe187a1a39
     */
    @ExcelProperty("项目id")
    private String projectId = StringUtils.EMPTY;
    /**
     * 项目名称
     *
     * @pdOid b36c7653-3ecb-426c-8fb4-908ee045ac76
     */
    @ExcelProperty("项目名称")
    private String projectName = StringUtils.EMPTY;
    /**
     * 合同id
     *
     * @pdOid 34acd59e-c4e1-4716-b24a-0e78408116d4
     */
    @ExcelProperty("合同id")
    private String contractId = StringUtils.EMPTY;
    /**
     * 合同名称
     *
     * @pdOid e56050fc-0c12-4467-ae2e-b74ea902959d
     */
    @ExcelProperty("合同名称")
    private String contractName = StringUtils.EMPTY;
    /**
     * 合同编号
     *
     * @pdOid 6136a508-e1af-45fe-a5e6-2b162063d3da
     */
    @ExcelProperty("合同编号")
    private String contractNumber = StringUtils.EMPTY;
    /**
     * 合同金额
     *
     * @pdOid 2c51602f-7212-4973-b5eb-e39868c0b5d5
     */
    @ExcelProperty("合同金额")
    private String contractAmount = StringUtils.EMPTY;
    /**
     * 结算方式ID
     *
     * @pdOid 257d69d2-fef2-41fa-9404-8b2d065591ef
     */
    @ExcelProperty("结算方式ID")
    private String settlementWayId = StringUtils.EMPTY;
    /**
     * 结算方式名称
     *
     * @pdOid e95d59d2-b171-40c8-ba10-e33095904089
     */
    @ExcelProperty("结算方式名称")
    private String settlementWayName = StringUtils.EMPTY;
    /**
     * 结算金额
     *
     * @pdOid 2240b292-0bcc-434e-a5ae-026d32ecdccd
     */
    @ExcelProperty("结算金额")
    private String settlementAmount = StringUtils.EMPTY;
    /**
     * 发票种类ID
     *
     * @pdOid b7411e3a-d4cf-4148-9d97-111769785114
     */
    @ExcelProperty("发票种类ID")
    private String typeId = StringUtils.EMPTY;
    /**
     * 发票种类名称
     *
     * @pdOid c45f2f4e-d266-4f54-8107-421f25fc9984
     */
    @ExcelProperty("发票种类名称")
    private String typeName = StringUtils.EMPTY;
    /**
     * 开票单位
     *
     * @pdOid 06884ba0-d3f0-4982-abdd-1d26f5838c43
     */
    @ExcelProperty("开票单位")
    private String company = StringUtils.EMPTY;
    /**
     * 发票业务类型ID
     *
     * @pdOid 7801b10e-d252-420f-8da2-81ca750e9ee5
     */
    @ExcelProperty("发票业务类型ID")
    private String businessTypeId = StringUtils.EMPTY;
    /**
     * 发票业务类型名称
     *
     * @pdOid 01f21011-3c69-4655-9d68-7a91fa16268a
     */
    @ExcelProperty("发票业务类型名称")
    private String businessTypeName = StringUtils.EMPTY;
    /**
     * 税率
     *
     * @pdOid 9e899d07-5ded-4ba7-9199-4c25f7f3df8e
     */
    @ExcelProperty("税率")
    private String taxRate = StringUtils.EMPTY;
    /**
     * 发票张数
     *
     * @pdOid 811f3957-09f3-4f61-8e32-ada57da976e5
     */
    @ExcelProperty("发票张数")
    private String number = StringUtils.EMPTY;
    /**
     * 本次收票金额
     *
     * @pdOid 7adfb1f6-5bc5-47aa-937a-84668276ba5c
     */
    @ExcelProperty("本次收票金额")
    private double invoiceAmount;
    /**
     * 本次收票税额
     *
     * @pdOid bea5758d-48c3-4b75-92ca-ef01af6f82c8
     */
    @ExcelProperty("本次收票税额")
    private double taxAmount;
    /**
     * 已收票金额
     *
     * @pdOid c7e3dc54-48ee-4a4a-9d6e-bb32724da4a3
     */
    @ExcelProperty("已收票金额")
    private double alreadyReceiveAmount;
    /**
     * 累计收票金额
     *
     * @pdOid 22034b48-aa9d-402e-b52f-a4c151f03ed7
     */
    @ExcelProperty("累计收票金额")
    private double totalReceiveAmount;
    /**
     * 是否实采 0：是 1：否
     *
     * @pdOid da3a835d-6b48-4544-ac51-d046d6e1c2af
     */
    @ExcelProperty("是否实采")
    private String isPurchase = StringUtils.EMPTY;
    /**
     * 是否推送付款申请单 0：是 1：否
     *
     * @pdOid 7425d3f4-02dd-4586-9457-dcbc1818d67c
     */
    @ExcelProperty("是否推送付款申请单")
    private String isPush = StringUtils.EMPTY;
    /**
     * 申请日期
     *
     * @pdOid e2088256-7f70-42d3-b952-07fa2aa5dac1
     */
    @ExcelProperty("申请日期")
    private Date applyDate;
    /**
     * 申请人
     *
     * @pdOid 72055761-c88e-4688-a9bc-fbb54d98453d
     */
    @ExcelProperty("申请人")
    private String applyUser = StringUtils.EMPTY;
    /**
     * 合伙人id
     *
     * @pdOid 8c846e66-eb3a-460c-b5bd-7a54f3074a6a
     */
    @ExcelProperty("合伙人id")
    private String partnerId = StringUtils.EMPTY;
    /**
     * 合伙人名称
     *
     * @pdOid 7ed1731a-f88a-45eb-b879-36fd83c44b5b
     */
    @ExcelProperty("合伙人名称")
    private String partnerName = StringUtils.EMPTY;
    /**
     * 结算单附件集合
     *
     * @pdOid 03861f67-9002-4ff9-ac1b-b6a78a6e2565
     */
    @ExcelIgnore
    private List<Map> settlementFiles = new ArrayList<>();
    /**
     * 其他附件集合
     *
     * @pdOid 0e0ee567-f022-4c1d-b7e6-34b99fe337ed
     */
    @ExcelIgnore
    private List<Map> otherFiles = new ArrayList<>();
    /**
     * 发票集合
     *
     * @pdOid c8a668ab-a95e-4d97-9a2b-625c1f5aeee7
     */
    @ExcelIgnore
    private List<MapInvoiceList> invoiceList = new ArrayList<>();
    /**
     * 备注
     *
     * @pdOid 22d5e3a5-d43a-4bd6-975b-f6fa6d51e403
     */
    @ExcelProperty("备注")
    private String remarks = StringUtils.EMPTY;
    /**
     * 收票状态 0：待审核 1：审核中 2：待交接 3：待认证 4：已认证 5：审核不通过
     *
     * @pdOid d204d060-49d1-4b12-8e19-d40fa2ff56bd
     */
    @ExcelProperty("收票状态")
    private String status = "4";
    /**
     * 是否删除 1:是；0:否
     *
     * @pdOid ccb05efe-af13-4341-8ab7-0841b3650a40
     */
    @ExcelProperty("是否删除")
    private String delFlag = StringUtils.EMPTY;
    /**
     * 创建人
     *
     * @pdOid 029fde22-fde8-417c-83a5-79da72bedce9
     */
    @ExcelProperty("创建人")
    private String createBy = StringUtils.EMPTY;
    /**
     * 修改人
     *
     * @pdOid 8fd732f7-7a46-4874-b0a8-6f73a86ea703
     */
    @ExcelProperty("修改人")
    private String updateBy = StringUtils.EMPTY;
    /**
     * 创建时间
     *
     * @pdOid 68df9292-8ea0-487e-9d13-7c7a250a16b1
     */
    @ExcelProperty("创建时间")
    private Date createTime;
    /**
     * 修改时间
     *
     * @pdOid c0ffe1ae-c06f-4988-ae7b-3c59060c7180
     */
    @ExcelProperty("修改时间")
    private Date updateTime;
    /**
     * 开具方式名称
     *
     * @pdOid ddc30390-0e98-4ee3-8d94-9067d175f2d5
     */
    @ExcelProperty("开具方式名称")
    private String openWayName = StringUtils.EMPTY;
    @ExcelProperty("审批流程实例id")
    private String procInstId = StringUtils.EMPTY;

    @ExcelProperty("数据源")
    private String dataSource = "EPMS";
}