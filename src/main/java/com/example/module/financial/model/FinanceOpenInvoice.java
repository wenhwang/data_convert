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
 * 开票
 **/
@Data
public class FinanceOpenInvoice {
    /**
     * 开票ID
     *
     * @pdOid ae38ab77-7d6e-46aa-acda-4ad924d6e708
     */
    @ExcelProperty("开票ID") private String openInvoiceId = StringUtils.EMPTY;
    /**
     * 开票编号
     *
     * @pdOid b0ca94c2-4942-4fe0-b5f8-83677994dc25
     */
    @ExcelProperty("开票编号") private String sysNumber = StringUtils.EMPTY;
    /**
     * 结算单id
     *
     * @pdOid 9381ac97-9f51-4b3d-96e7-f7fbe5e6ddcd
     */
    @ExcelProperty("结算单id") private String statementId = StringUtils.EMPTY;
    /**
     * 结算单号
     *
     * @pdOid 97ea4801-e575-49b8-8f8c-3ea5e225db0e
     */
    @ExcelProperty("结算单号") private String statementNumber = StringUtils.EMPTY;
    /**
     * 项目id
     *
     * @pdOid 1ee43529-1f03-4fc4-8c82-6f6ff7a0c022
     */
    @ExcelProperty("项目id") private String projectId = StringUtils.EMPTY;
    /**
     * 项目名称
     *
     * @pdOid a3070b79-3fe3-4a6d-9882-3215d94c0b31
     */
    @ExcelProperty("项目名称") private String projectName = StringUtils.EMPTY;
    /**
     * 申请日期
     *
     * @pdOid 0721604c-90f4-4a51-90a4-6b371d5e6b61
     */
    @ExcelProperty("申请日期") private String applyDate = StringUtils.EMPTY;
    /**
     * 申请人
     *
     * @pdOid 18b288da-1e51-4e0f-90d0-8cd6f2a35d3d
     */
    @ExcelProperty("申请人") private String applyUser = StringUtils.EMPTY;
    /**
     * 开票单位名称
     *
     * @pdOid 9303a5e1-a23b-49c8-818f-b3477be5e4e7
     */
    @ExcelProperty("开票单位名称") private String companyName = StringUtils.EMPTY;
    /**
     * 合同id
     *
     * @pdOid 18e03c6e-ecb9-4226-8a3e-1f08ce8ab724
     */
    @ExcelProperty("合同id") private String contractId = StringUtils.EMPTY;
    /**
     * 合同名称
     *
     * @pdOid c9fd3b87-f2cf-4cbb-bc49-2458d6e33604
     */
    @ExcelProperty("合同名称") private String contractName = StringUtils.EMPTY;
    /**
     * 项目合同金额
     *
     * @pdOid bb74f60c-c56f-478f-8f04-4d0fe51f6849
     */
    @ExcelProperty("项目合同金额") private String contractAmount = StringUtils.EMPTY;
    /**
     * 发票类型ID
     *
     * @pdOid 4ee15129-883b-43ce-90b8-f588184ecc52
     */
    @ExcelProperty("发票类型ID") private String typeId = StringUtils.EMPTY;
    /**
     * 发票类型名称
     *
     * @pdOid 3881dbed-94ef-46eb-9fba-bc2d61d2442c
     */
    @ExcelProperty("发票类型名称") private String typeName = StringUtils.EMPTY;
    /**
     * 发票业务类型ID
     *
     * @pdOid 70899f99-94fc-4c7f-ad2e-3f96f12607cd
     */
    @ExcelProperty("发票业务类型ID") private String businessTypeId = StringUtils.EMPTY;
    /**
     * 发票业务类型名称
     *
     * @pdOid 61ed0eb5-504f-4d37-ab38-f6a17fac163a
     */
    @ExcelProperty("发票业务类型名称") private String businessTypeName = StringUtils.EMPTY;
    /**
     * 支付方式Id
     *
     * @pdOid 830be081-f656-48a4-af70-0d1afde12f33
     */
    @ExcelProperty("支付方式Id") private String payWayId = StringUtils.EMPTY;
    /**
     * 支付方式
     *
     * @pdOid 04d44fe4-9beb-48c1-822e-e7727c52b444
     */
    @ExcelProperty("支付方式") private String payWay = StringUtils.EMPTY;
    /**
     * 已开票金额
     *
     * @pdOid 995672c8-d0f3-44ba-b994-c4e6ae79d85d
     */
    @ExcelProperty("已开票金额") private double overInvoiceAmount;
    /**
     * 申请开票金额
     *
     * @pdOid eb81c6a4-5f7c-44ca-9003-52421c183f58
     */
    @ExcelProperty("申请开票金额") private double applyInvoiceAmount;
    /**
     * 实际开票金额
     *
     * @pdOid 158609ce-82b8-4af6-b3e1-30e9b4f1a965
     */
    @ExcelProperty("实际开票金额") private double actualInvoiceAmount;
    /**
     * 累计开票金额
     *
     * @pdOid cf1859ab-3e42-4c97-a343-dc1103298b43
     */
    @ExcelProperty("累计开票金额") private double totalInvoiceAmount;
    /**
     * 税率
     *
     * @pdOid 9686ba6c-32dc-479c-925f-f7e25730308f
     */
    @ExcelProperty("税率") private String taxRate = StringUtils.EMPTY;
    /**
     * 合伙人id
     *
     * @pdOid 98851917-74a8-4b2a-b6e7-188a97714c66
     */
    @ExcelProperty("合伙人id") private String partnerId = StringUtils.EMPTY;
    /**
     * 合伙人名称
     *
     * @pdOid 028cc4c3-af69-476b-9e87-266060698d41
     */
    @ExcelProperty("合伙人名称") private String partnerName = StringUtils.EMPTY;
    /**
     * 开票依据
     *
     * @pdOid fd6d0a44-54b9-4621-849b-efcc17884de4
     */
    @ExcelProperty("开票依据") private String invoiceBasis = StringUtils.EMPTY;
    /**
     * 是否推送到收款申请单 0：是 1：否
     *
     * @pdOid 3bf2649f-a11e-439d-92fc-3ff4269a57e1
     */
    @ExcelProperty("是否推送到收款申请单") private String isPush = StringUtils.EMPTY;
    /**
     * 附件集合
     *
     * @pdOid 0450e08d-3f00-4182-bc28-d7d77a0baafe
     */
    @ExcelIgnore private List<Map> files = new ArrayList<>();
    /**
     * 开票状态 0：待审核 1：审核中 2：待开票 3：待收票 4：已收票 5：审核不通过
     *
     * @pdOid 670ebf94-4756-4221-924d-03dcbe93af93
     */
    @ExcelProperty("开票状态") private String status = "4";
    /**
     * 备注
     *
     * @pdOid 1097a5b5-0bf7-4429-a923-7c787078eb16
     */
    @ExcelProperty("备注") private String remarks = StringUtils.EMPTY;
    /**
     * 是否删除 1:是；0:否
     *
     * @pdOid 5555ddc9-5e31-49d7-8d53-0e5c17abd2a3
     */
    @ExcelProperty("是否删除") private String delFlag = StringUtils.EMPTY;
    /**
     * 创建人
     *
     * @pdOid f2df2dd7-f6fc-4998-8637-bb33f78f7c73
     */
    @ExcelProperty("创建人") private String createBy = StringUtils.EMPTY;
    /**
     * 修改人
     *
     * @pdOid 3f895b35-982e-435e-8781-8e5b3c5bcec1
     */
    @ExcelProperty("修改人") private String updateBy = StringUtils.EMPTY;
    /**
     * 创建时间
     *
     * @pdOid 9fe4fff1-8381-4088-aaf5-f54e057d6694
     */
    @ExcelProperty("创建时间") private Date createTime;
    /**
     * 修改时间
     *
     * @pdOid fe9022a1-143a-4746-a264-01ffa3d26cb8
     */
    @ExcelProperty("修改时间") private Date updateTime;
    /**
     * 发票集合
     *
     * @pdOid c8a668ab-a95e-4d97-9a2b-625c1f5aeee7
     */
    @ExcelIgnore private List<MapInvoiceList> invoiceList = new ArrayList<>();

    @ExcelProperty("审批流程实例id")
    private String procInstId = StringUtils.EMPTY;
    @ExcelProperty("数据源") private String dataSource = "EPMS";
}