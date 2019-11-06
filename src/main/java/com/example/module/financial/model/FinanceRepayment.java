package com.example.module.financial.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

//还款单
@Data
public class FinanceRepayment {
    @ExcelProperty("报销单id") private String reimbursementId = StringUtils.EMPTY;
   //还款单号
    @ExcelProperty("报销单号") private String sysNumber = StringUtils.EMPTY;
   // 申请人
    @ExcelProperty("申请人") private String applyUser = StringUtils.EMPTY;
  //申请部门ID
    @ExcelProperty("申请部门ID") private String departmentId = StringUtils.EMPTY;
  //申请部门名称
    @ExcelProperty("申请部门名称") private String departmentName = StringUtils.EMPTY;
  //还款方式id
    @ExcelProperty("还款方式id") private String repaymentWayId = StringUtils.EMPTY;
   //还款方式
    @ExcelProperty("还款方式") private String repaymentWay = StringUtils.EMPTY;
   // 收款名称
    @ExcelProperty("收款名称") private String repaymentName = StringUtils.EMPTY;
   //收款银行
    @ExcelProperty("收款银行") private String repaymentBank = StringUtils.EMPTY;
    //收款账号
    @ExcelProperty("收款账号") private String repaymentAccount = StringUtils.EMPTY;
   //申请还款金额
    @ExcelProperty("申请还款金额") private double applyAmount;
    //实际还款金额
    @ExcelProperty("实际还款金额") private double actualAmount;
    //币种id
    @ExcelProperty("币种id") private String currencyTypeId = StringUtils.EMPTY;
   //币种名称
    @ExcelProperty("币种名称") private String currencyTypeName = StringUtils.EMPTY;
    //摘要
    @ExcelProperty("用途") private String remarks = StringUtils.EMPTY;
     // 附件集合
    @ExcelIgnore  private String files = StringUtils.EMPTY;
    //状态 0：待审核 1：审核中 2：待付款 3：已完成 4：审核不通过 5：已撤销
    @ExcelProperty("还款单状态") private String status = "3";
    //是否删除 1:是；0:否
    @ExcelProperty("是否删除") private String delFlag = StringUtils.EMPTY;
    //创建人
    @ExcelProperty("创建人") private String createBy = StringUtils.EMPTY;
    //修改人
    @ExcelProperty("修改人") private String updateBy = StringUtils.EMPTY;
    //创建时间
    @ExcelProperty("创建时间") private Date createTime;
    //修改时间
    @ExcelProperty("修改时间") private Date updateTime;
    @ExcelProperty("收款账号id") private String repaymentAccountId = StringUtils.EMPTY;
    @ExcelProperty("审批流程实例id") private String procInstId = StringUtils.EMPTY;
    @ExcelProperty("数据源") private String dataSource = "EPMS";
}