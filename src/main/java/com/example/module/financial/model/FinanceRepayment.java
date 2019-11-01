package com.example.module.financial.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

//还款单
@Data
public class FinanceRepayment {
    /**
     * 还款单id
     */
    private String reimbursementId = StringUtils.EMPTY;
    /**
     * 还款单号
     *
     * @pdOid f29e19d0-87bd-4fa9-b1ea-710c0dafb66e
     */
    private String sysNumber = StringUtils.EMPTY;
    /**
     * 申请人
     *
     * @pdOid 8e1566c2-baff-440a-b24b-b1ec9f1d8e3c
     */
    private String applyUser = StringUtils.EMPTY;
    /**
     * 申请部门ID
     *
     * @pdOid 0d21b563-73bb-425c-95a7-29e9ece8fe55
     */
    private String departmentId = StringUtils.EMPTY;
    /**
     * 申请部门名称
     *
     * @pdOid fb220872-72c7-4da5-8003-6f08c6321657
     */
    private String departmentName = StringUtils.EMPTY;
    /**
     * 还款方式id
     *
     * @pdOid 587c971d-dd77-46c3-b8d3-e133f8141522
     */
    private String repaymentWayId = StringUtils.EMPTY;
    /**
     * 还款方式
     *
     * @pdOid 2319ac8d-6dde-4d42-a050-4d05b68b99c3
     */
    private String repaymentWay = StringUtils.EMPTY;
    /**
     * 收款名称
     *
     * @pdOid bbe13dfd-66dc-4168-a5ac-783745adb4d3
     */
    private String repaymentName = StringUtils.EMPTY;
    /**
     * 收款银行
     *
     * @pdOid a823b64e-7088-4fed-aa66-f37d312cfef3
     */
    private String repaymentBank = StringUtils.EMPTY;
    /**
     * 收款账号
     *
     * @pdOid e840b6ef-38f0-456b-9e47-6e1d6b584342
     */
    private String repaymentAccount = StringUtils.EMPTY;
    /**
     * 申请还款金额
     *
     * @pdOid 611efcd5-0323-45b1-950e-56d34c997214
     */
    private double applyAmount;
    /**
     * 实际还款金额
     *
     * @pdOid ba28d7a2-b689-459c-bbae-61dc3d99f3ef
     */
    private double actualAmount;
    /**
     * 币种id
     *
     * @pdOid 756d2956-7618-4aab-9031-b4f2256ebf87
     */
    private String currencyTypeId = StringUtils.EMPTY;
    /**
     * 币种名称
     *
     * @pdOid 4177489a-a224-4f2a-972d-21886d630d36
     */
    private String currencyTypeName = StringUtils.EMPTY;
    /**
     * 摘要
     *
     * @pdOid a5217949-c907-4e55-a7c9-923341929648
     */
    private String remarks = StringUtils.EMPTY;
    /**
     * 附件集合
     *
     * @pdOid 857a4b15-f8ea-4c42-b76e-52eb015438cd
     */
    private String files = StringUtils.EMPTY;
    /**
     * 状态 0：待审核 1：审核中 2：待付款 3：已完成 4：审核不通过 5：已撤销
     *
     * @pdOid 154a9cda-5242-4351-bc5a-dc6806473fe4
     */
    private String status = "3";
    /**
     * 是否删除 1:是；0:否
     *
     * @pdOid b3b7e73c-afda-4941-bbdf-fcd7ead4f6a7
     */
    private String delFlag = StringUtils.EMPTY;
    /**
     * 创建人
     *
     * @pdOid 66740539-38aa-4f24-8f07-2262b160d986
     */
    private String createBy = StringUtils.EMPTY;
    /**
     * 修改人
     *
     * @pdOid 56c39a45-e0f8-4804-8956-2168cbe95656
     */
    private String updateBy = StringUtils.EMPTY;
    /**
     * 创建时间
     *
     * @pdOid d22c6617-57c8-46c7-95cf-ad625310548f
     */
    private Date createTime;
    /**
     * 修改时间
     *
     * @pdOid 3ad37d05-c820-48ee-9909-93b6eda5271a
     */
    private Date updateTime;
    private String dataSource = "EPMS";
}