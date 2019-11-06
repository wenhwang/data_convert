package com.example.module.financial.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * 报销管理-备用金
 *
 * @pdOid ac01a491-d6e0-46d1-b8fc-38e5201e08ef
 */
@Data
public class FinanceReserveFund {
    /**
     * 备用金id
     */
    @ExcelProperty("报销id") private String reimbursementId = StringUtils.EMPTY;
    /**
     * 备用金单号
     */
    @ExcelProperty("报销单号") private String sysNumber = StringUtils.EMPTY;
    /**
     * 备用金类型id
     */
    @ExcelProperty("备用金类型id") private String imprestTypeId = StringUtils.EMPTY;
    ;
    /**
     * 备用金类型
     */
    @ExcelProperty("备用金类型") private String imprestTypeName = StringUtils.EMPTY;
    ;
    /**
     * 申请人
     */
    @ExcelProperty("申请人") private String applyUser = StringUtils.EMPTY;
    ;
    /**
     * 申请部门ID
     */
    @ExcelProperty("") private String departmentId = StringUtils.EMPTY;
    ;
    /**
     * 申请部门名称
     */
    @ExcelProperty("申请部门名称")private String departmentName = StringUtils.EMPTY;
    ;
    /**
     * 币种id
     */
    @ExcelProperty("币种id")private String currencyTypeId = StringUtils.EMPTY;
    ;
    /**
     * 币种名称
     */
    @ExcelProperty("币种名称")private String currencyTypeName = StringUtils.EMPTY;
    ;
    /**
     * 申请金额
     */
    @ExcelProperty("申请金额")private double applyAmount;
    /**
     * 付款名称
     */
    @ExcelProperty("付款名称")private String paymentName = StringUtils.EMPTY;
    ;
    /**
     * 付款银行
     */
    @ExcelProperty("付款银行")private String paymentBank = StringUtils.EMPTY;
    ;
    /**
     * 付款账号
     *
     * @pdOid deb11d8e-8159-4035-be39-466241b1f51e
     */
    @ExcelProperty("付款账号")private String paymentAccount = StringUtils.EMPTY;
    /**
     * 收款名称
     */
    @ExcelProperty("收款名称")private String repaymentName = StringUtils.EMPTY;
    ;
    /**
     * 收款银行
     */
    @ExcelProperty("收款银行") private String repaymentBank = StringUtils.EMPTY;
    ;
    /**
     * 收款账号
     */
    @ExcelProperty("收款账号")private String repaymentAccount = StringUtils.EMPTY;
    ;
    /**
     * 费用承担单位id
     */
    @ExcelProperty("费用承担单位id")private String companyId = StringUtils.EMPTY;
    ;
    /**
     * 费用承担单位名称
     */
    @ExcelProperty("费用承担单位名称")private String companyName = StringUtils.EMPTY;
    ;
    /**
     * 帐套主体
     */
    @ExcelProperty("帐套主体")private String accountSubject = StringUtils.EMPTY;
    ;
    /**
     * 用途
     */
    @ExcelProperty("用途")private String remarks = StringUtils.EMPTY;
    ;
    /**
     * 状态 0：待审核 1：审核中 2：待付款 3：已完成 4：审核不通过 5：已撤销
     *
     * @pdOid 331d45cd-3327-44e0-bff1-1baa9a9d4905
     */
    @ExcelProperty("状态")private String status = "3";
    /**
     * 附件集合
     */
    @ExcelIgnore  private String files = StringUtils.EMPTY;
    ;
    /**
     * 是否删除 1:是；0:否
     */
    @ExcelProperty("是否删除")private String delFlag = StringUtils.EMPTY;
    ;
    /**
     * 创建人
     */
    @ExcelProperty("创建人")private String createBy = StringUtils.EMPTY;
    ;
    /**
     * 修改人
     */
    @ExcelProperty("修改人")private String updateBy = StringUtils.EMPTY;
    ;
    /**
     * 创建时间
     */
    @ExcelProperty("创建时间")private Date createTime;
    ;
    /**
     * 修改时间
     */
    @ExcelProperty("修改时间")private Date updateTime;

    //批准金额
    @ExcelProperty("批准金额")private double approveAmount;


    @ExcelProperty("审批流程实例id")private String procInstId = StringUtils.EMPTY;
    @ExcelProperty("帐套主体id")private String accountSubjectId = StringUtils.EMPTY;
    @ExcelProperty("付款账号id")private String paymentAccountId = StringUtils.EMPTY;
    @ExcelProperty("实际付款金额")private double actualPaymentAmountdouble;


    @ExcelProperty("数据源")private String dataSource = "EPMS";
}