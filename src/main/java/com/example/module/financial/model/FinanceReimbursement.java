package com.example.module.financial.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ContentRowHeight(22)
@HeadRowHeight(30)
public class FinanceReimbursement {

    @ExcelProperty("报销id")
    private String reimbursementId = StringUtils.EMPTY;
    @ExcelProperty("报销单号")
    private String sysNumber = StringUtils.EMPTY;
    @ExcelProperty("报销类别ID")
    private String typeId = StringUtils.EMPTY;
    @ExcelProperty("报销类别名称")
    private String typeName = StringUtils.EMPTY;
    @ExcelProperty("费用申请单号")
    private String applyNumber = StringUtils.EMPTY;
    @ExcelProperty("申请人")
    private String applyUser = StringUtils.EMPTY;
    @ExcelProperty("申请部门ID")
    private String departmentId = StringUtils.EMPTY;
    @ExcelProperty("申请部门名称")
    private String departmentName = StringUtils.EMPTY;
    @ExcelProperty("结算方式id")
    private String settlementWayId = StringUtils.EMPTY;
    @ExcelProperty("结算方式")
    private String settlementWay = StringUtils.EMPTY;
    @ExcelProperty("项目id")
    private String projectId = StringUtils.EMPTY;
    @ExcelProperty("项目名称")
    private String projectName = StringUtils.EMPTY;
    @ExcelProperty("项目余额")
    private String projectBalance = StringUtils.EMPTY;
    @ExcelProperty("合伙人id")
    private String partnerId = StringUtils.EMPTY;
    @ExcelProperty("合伙人名称")
    private String partnerName = StringUtils.EMPTY;
    @ExcelProperty("开户名称")
    private String accountName = StringUtils.EMPTY;
    @ExcelProperty("开户银行")
    private String bankName = StringUtils.EMPTY;
    @ExcelProperty("开户账号")
    private String bankAccount = StringUtils.EMPTY;
    @ExcelProperty("申请金额")
    private double applyAmount;
    @ExcelProperty("实际付款金额")
    private double actualPaymentAmount;
    @ExcelProperty("所属区域名称")
    private String areaName = StringUtils.EMPTY;
    @ExcelProperty("用途")
    private String purpose = StringUtils.EMPTY;
    @ExcelProperty("是否删除")
    private String delFlag = "0";
    @ExcelProperty("报销状态")
    private String status = "0";
    @ExcelProperty("创建人")
    private String createBy = StringUtils.EMPTY;
    @ExcelProperty("修改人")
    private String updateBy = StringUtils.EMPTY;
    @ExcelProperty("创建时间")
    private Date createTime;
    @ExcelProperty("修改时间")
    private Date updateTime;
    @ExcelProperty("附件集合")
    private String files = StringUtils.EMPTY;
    @ExcelIgnore private List<MapCostList> costList = new ArrayList<>();


    @ExcelProperty("实际报销人id")
    private String reimbursementUserId;
    @ExcelProperty("实际报销人真实姓名")
    private String reimbursementRealName = StringUtils.EMPTY;
    @ExcelProperty("业务负责人id")
    private String businessUserId = StringUtils.EMPTY;
    @ExcelProperty("业务负责人姓名")
    private String businessUserName = StringUtils.EMPTY;
    @ExcelProperty("实际批准金额")
    private double approveAmount;
    @ExcelProperty("审批流程实例id")
    private String procInstId = StringUtils.EMPTY;
    @ExcelProperty("付款账号ID")
    private String payAccountId = StringUtils.EMPTY;
    @ExcelProperty("付款账户户名")
    private String payAccountName = StringUtils.EMPTY;
    @ExcelProperty("付款账号")
    private String payBankAccount = StringUtils.EMPTY;
    @ExcelProperty("付款开户行")
    private String payBankName = StringUtils.EMPTY;
    @ExcelProperty("冲账金额")
    private double paymentAmount;
    @ExcelProperty("冲账人id")
    private String paymentUserId = StringUtils.EMPTY;
    @ExcelProperty("冲账人姓名")
    private String paymentUser = StringUtils.EMPTY;
    private String dataSource = "EPMS";
}
