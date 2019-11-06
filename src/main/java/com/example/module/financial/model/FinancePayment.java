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
 * 付款
 *
 * @pdOid 54783169-056c-4e94-96a5-880290af0040
 */
@Data
public class FinancePayment {
    /**
     * 付款单ID
     *
     * @pdOid 111fce82-3b4f-4bd7-a593-c0e19d6a71bc
     */
    @ExcelProperty("付款单ID") private String paymentId = StringUtils.EMPTY;
    /**
     * 付款编号
     *
     * @pdOid e2bc3840-f5c8-4d60-bbdb-30394cb66c6f
     */
    @ExcelProperty("付款编号") private String sysNumber = StringUtils.EMPTY;
    /**
     * 项目id
     *
     * @pdOid 815a0a9b-6760-4a57-ac73-7ddd43d46f4d
     */
    @ExcelProperty("项目id") private String projectId = StringUtils.EMPTY;
    /**
     * 项目名称
     *
     * @pdOid b1ef44d1-1631-4d59-848b-153b1bb51a1b
     */
    @ExcelProperty("项目名称") private String projectName = StringUtils.EMPTY;
    /**
     * 项目编码
     *
     * @pdOid ccae3cb5-c378-489a-a0f2-33ebf4cf2d80
     */
    @ExcelProperty("项目编码") private String projectCode = StringUtils.EMPTY;
    /**
     * 项目地址
     *
     * @pdOid c463e9f5-b8b1-4ca5-b585-5dc2d2b2e7d1
     */
    @ExcelProperty("项目地址") private String projectAddress = StringUtils.EMPTY;
    /**
     * 合同ID
     *
     * @pdOid fa42690e-14cc-48b7-a262-dea4d5268902
     */
    @ExcelProperty("合同ID") private String contractId = StringUtils.EMPTY;
    /**
     * 合同名称
     *
     * @pdOid bd0d7d2d-933c-4a55-b861-b824f4fe09ee
     */
    @ExcelProperty("合同名称") private String contractName = StringUtils.EMPTY;
    /**
     * 合同编号
     *
     * @pdOid 4dad8b4f-4a2a-4022-9ef4-d5aecc3a25f7
     */
    @ExcelProperty("合同编号") private String contractNumber = StringUtils.EMPTY;
    /**
     * 合同金额
     *
     * @pdOid f8d99233-0430-4616-a09a-9d4c2e04c932
     */
    @ExcelProperty("合同金额") private double contractAmount;
    /**
     * 付款单位
     *
     * @pdOid bebfff93-3f81-4015-82f7-57c70d367c4e
     */
    @ExcelProperty("付款单位") private String payCompany = StringUtils.EMPTY;
    /**
     * 付款账户
     *
     * @pdOid 5bd6c72b-0981-4765-839e-406a3c67b84f
     */
    @ExcelProperty("付款账户") private String payAccount = StringUtils.EMPTY;
    /**
     * 付款银行
     *
     * @pdOid 0d9c8277-10b6-4e95-af39-ab1f2fb16e05
     */
    @ExcelProperty("付款银行") private String payBank = StringUtils.EMPTY;
    /**
     * 收款单位
     *
     * @pdOid b0041ffe-bfaf-40dc-9528-5f88c159d5c9
     */
    @ExcelProperty("收款单位") private String receivablesCompany = StringUtils.EMPTY;
    /**
     * 收款账户
     *
     * @pdOid 14fc977d-5f52-44f9-8430-e47cd2f91408
     */
    @ExcelProperty("收款账户") private String receivablesAccount = StringUtils.EMPTY;
    /**
     * 收款银行
     *
     * @pdOid a8450b06-c181-40db-b28c-3b82fdb05bb6
     */
    @ExcelProperty("收款银行") private String receivablesBank = StringUtils.EMPTY;
    /**
     * 实际付款日期
     *
     * @pdOid f591bfeb-03f0-4e28-a76f-de6a8808fbc0
     */
    @ExcelProperty("实际付款日期") private String actualPaymentDate = StringUtils.EMPTY;
    /**
     * 账套主体
     *
     * @pdOid bd87e468-57f5-49cc-8239-75757927d97d
     */
    @ExcelProperty("账套主体") private String accountSubject = StringUtils.EMPTY;
    /**
     * 结算方式ID
     *
     * @pdOid 6518ab58-10f3-49ab-971f-14cf01bdf3fd
     */
    @ExcelProperty("结算方式ID") private String settlementWayId = StringUtils.EMPTY;
    /**
     * 结算方式名称
     *
     * @pdOid d021f32e-d421-4c7d-9d09-1f2418ef3b7a
     */
    @ExcelProperty("结算方式名称") private String settlementWayName = StringUtils.EMPTY;
    /**
     * 累计收票金额
     *
     * @pdOid 04b5bda9-c06f-489a-a25f-cf6c6194f92e
     */
    @ExcelProperty("累计收票金额") private double totalInvoiceAmount;
    /**
     * 累计付款金额
     *
     * @pdOid 0cfa6a0b-38c3-47c2-a1b5-9f5cb48bce34
     */
    @ExcelProperty("累计付款金额") private double totalPaymentAmount;
    /**
     * 本次申请付款金额
     *
     * @pdOid c26c4acf-f43a-44d1-b546-dbf53277fddf
     */
    @ExcelProperty("本次申请付款金额") private double applyPaymentAmount;
    /**
     * 实际付款金额
     *
     * @pdOid 7f6a03cc-db1d-462a-a2ec-e0c47572a741
     */
    @ExcelProperty("实际付款金额") private double actualPaymentAmount;
    /**
     * 本次结算金额
     *
     * @pdOid 0a0e1ef9-fd3b-42da-b557-1b205d68b967
     */
    @ExcelProperty("本次结算金额") private double settlementAmount;
    /**
     * 发票种类id
     *
     * @pdOid 1595e2a1-bceb-4916-88d2-593059acf68f
     */
    @ExcelProperty("发票种类id") private String invoiceTypeId = StringUtils.EMPTY;
    /**
     * 发票种类名称
     *
     * @pdOid 0fa50f5d-e9a4-45d3-9d3f-2d0628abb47d
     */
    @ExcelProperty("发票种类名称") private String invoiceTypeName = StringUtils.EMPTY;
    /**
     * 发票业务类型id
     *
     * @pdOid 028945f7-859a-416f-9800-d41f18450adc
     */
    @ExcelProperty("发票业务类型id") private String businessTypeId = StringUtils.EMPTY;
    /**
     * 发票业务类型名称
     *
     * @pdOid 1252d656-9b5d-4858-be17-b5125f946a3f
     */
    @ExcelProperty("发票业务类型名称") private String businessTypeName = StringUtils.EMPTY;
    /**
     * 款项类别id
     *
     * @pdOid bd6f7401-2a1a-44d3-a094-d2aabe685a7b
     */
    @ExcelProperty("款项类别id") private String moneyCategoryId = StringUtils.EMPTY;
    /**
     * 款项类别名称
     *
     * @pdOid d75d6b5b-7c04-41fb-b99f-9de94455eb95
     */
    @ExcelProperty("款项类别名称") private String moneyCategoryName = StringUtils.EMPTY;
    /**
     * 款项类型id
     *
     * @pdOid be6f8c12-c4a3-4c9d-b8f1-5519f8220be4
     */
    @ExcelProperty("款项类型id") private String moneyTypeId = StringUtils.EMPTY;
    /**
     * 款项类型名称
     *
     * @pdOid 0344b5ef-af2e-4e99-b0a5-887035863ba2
     */
    @ExcelProperty("款项类型名称") private String moneyTypeName = StringUtils.EMPTY;
    /**
     * 付款依据id
     *
     * @pdOid f803ce1d-3612-4fe2-9e34-d78adbec9599
     */
    @ExcelProperty("付款依据id") private String paymentBasisId = StringUtils.EMPTY;
    /**
     * 付款依据名称
     *
     * @pdOid 1fbf62ea-07c8-46b8-b68a-e5455b043d95
     */
    @ExcelProperty("付款依据名称") private String paymentBasisName = StringUtils.EMPTY;
    /**
     * 预算类别id
     *
     * @pdOid 7169910e-99f9-4103-87a6-9bd82b0f6aca
     */
    @ExcelProperty("预算类别id") private String budgetTypeId = StringUtils.EMPTY;
    /**
     * 预算类别名称
     *
     * @pdOid b7c51099-28c8-43b0-b3ff-2137f912cc86
     */
    @ExcelProperty("预算类别名称") private String budgetTypeName = StringUtils.EMPTY;
    /**
     * 支付方式id
     *
     * @pdOid b32528c4-6044-4218-b015-a35c8ad3319d
     */
    @ExcelProperty("支付方式id") private String payWayId = StringUtils.EMPTY;
    /**
     * 支付方式名称
     *
     * @pdOid 0d89448d-d20c-4ef5-941f-1cf902d8c2fc
     */
    @ExcelProperty("支付方式名称") private String payWayName = StringUtils.EMPTY;
    /**
     * 合伙人id
     *
     * @pdOid 9deddcb4-81bf-461e-8f6b-3952c4c7a6b5
     */
    @ExcelProperty("合伙人id") private String partnerId = StringUtils.EMPTY;
    /**
     * 合伙人名称
     *
     * @pdOid 514e94b4-e39f-49a0-8f23-dd01d0aa7b80
     */
    @ExcelProperty("合伙人名称") private String partnerName = StringUtils.EMPTY;
    /**
     * 是否实采 0：是 1：否
     *
     * @pdOid ddb483d7-d539-4e1b-a5ae-d4aca35ce58d
     */
    @ExcelProperty("是否实采") private int isPurchase;
    /**
     * 材料是否齐全 0：是 1：否
     *
     * @pdOid b9aa78a5-bae3-4747-9036-080eecae0085
     */
    @ExcelProperty("材料是否齐全") private int isComplete;
    /**
     * 申请人
     *
     * @pdOid 79c49c4d-d8fb-4f25-826b-92b9bda4c09d
     */
    @ExcelProperty("申请人") private String applyUser = StringUtils.EMPTY;
    /**
     * 附件集合
     *
     * @pdOid c0109daf-a760-4487-8430-18e8f2b76d22
     */
    @ExcelIgnore private List<Map> files = new ArrayList<>();
    /**
     * 备注
     *
     * @pdOid 1e40d429-85a8-4191-b225-a1dea3a2891c
     */
    @ExcelProperty("备注") private String remarks = StringUtils.EMPTY;
    /**
     * 付款单状态 0：待审核 1：审核中 2：待付款 3：已付款 4：审核不通过 5：已撤销
     *
     * @pdOid 2da57e22-e684-4387-8e7d-89d279dae75e
     */
    @ExcelProperty("单据状态") private String status = "3";
    /**
     * 是否删除 1:是；0:否
     *
     * @pdOid 7bf59d9c-9d30-4f5d-8d2e-6b51c69d04ac
     */
    @ExcelProperty("是否删除") private String delFlag = StringUtils.EMPTY;
    /**
     * 创建人
     *
     * @pdOid 348e847b-16e6-4147-b91b-8473740e0d5b
     */
    @ExcelProperty("创建人") private String createBy = StringUtils.EMPTY;
    /**
     * 修改人
     *
     * @pdOid 7f63a43a-0c86-4dea-9dc7-84f690676b84
     */
    @ExcelProperty("修改人") private String updateBy;
    /**
     * 创建时间
     *
     * @pdOid 85353f24-f250-475b-ab22-7fa9f6cded07
     */
    @ExcelProperty("创建时间") private Date createTime;
    /**
     * 修改时间
     *
     * @pdOid d5239cd4-1305-4e9c-9823-8b9adc7f46fa
     */
    @ExcelProperty("修改时间") private Date updateTime;
    @ExcelProperty("数据源") private String dataSource = "EPMS";
}