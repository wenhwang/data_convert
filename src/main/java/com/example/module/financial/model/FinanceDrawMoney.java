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
 * 划款
 *
 * @pdOid 0bfce9a5-f58d-4b56-82db-072256c72f8d
 */
@Data
public class FinanceDrawMoney {
    /**
     * 划款单ID
     *
     * @pdOid 6b374732-235d-40c7-a2bc-fa0a7f9e3437
     */
    @ExcelProperty("划款单ID") private String drawMoneyId = StringUtils.EMPTY;
    /**
     * 划款单编号
     *
     * @pdOid 5b9ca9d5-3066-4ba9-9716-c42ddf7a8041
     */
    @ExcelProperty("划款单编号") private String sysNumber = StringUtils.EMPTY;
    /**
     * 项目id
     *
     * @pdOid ba1e89bd-9f07-474d-ab15-c5b60ae5a111
     */
    @ExcelProperty("项目id") private String projectId = StringUtils.EMPTY;
    /**
     * 项目名称
     *
     * @pdOid 2a0de76f-c427-4936-89d7-6038682e17e4
     */
    @ExcelProperty("项目名称") private String projectName = StringUtils.EMPTY;
    /**
     * 合同ID
     *
     * @pdOid d3cfd558-aa24-4f47-b5b4-5f665a596907
     */
    @ExcelProperty("合同ID") private String contractId = StringUtils.EMPTY;
    /**
     * 合同名称
     *
     * @pdOid 6a02b992-f5fc-4965-96d2-8058982c8c39
     */
    @ExcelProperty("合同名称") private String contractName = StringUtils.EMPTY;
    /**
     * 划款单位
     *
     * @pdOid 7a2b2fbe-d11a-4cc7-ba79-242d4dc1a8a7
     */
    @ExcelProperty("划款单位") private String payCompany = StringUtils.EMPTY;
    /**
     * 划款单位账户
     *
     * @pdOid ee958c18-dd6f-4bad-9076-9347d920604d
     */
    @ExcelProperty("划款单位账户") private String payAccount = StringUtils.EMPTY;
    /**
     * 划款单位银行
     *
     * @pdOid ac6c824d-0fef-41e2-a103-3d43b5fbd16d
     */
    @ExcelProperty("划款单位银行") private String payBank = StringUtils.EMPTY;
    /**
     * 收款单位
     *
     * @pdOid d84f93f2-76c5-4a3e-980d-547d31ee8653
     */
    @ExcelProperty("收款单位") private String receivablesCompany = StringUtils.EMPTY;
    /**
     * 收款账户
     *
     * @pdOid ab809345-b6b0-485d-af5b-f10ca51b9afa
     */
    @ExcelProperty("收款账户") private String receivablesAccount = StringUtils.EMPTY;
    /**
     * 收款银行
     *
     * @pdOid 6c30b42a-f462-4c22-85eb-8fe0f0aceaf8
     */
    @ExcelProperty("收款银行") private String receivablesBank = StringUtils.EMPTY;
    /**
     * 实际付款日期
     *
     * @pdOid 6ca19295-6601-4dce-b94b-8a5db22fccdb
     */
    @ExcelProperty("实际付款日期") private String actualPaymentDate = StringUtils.EMPTY;
    /**
     * 账套主体
     *
     * @pdOid 43e1e22d-e437-4346-b3c0-24bfcaa42096
     */
    @ExcelProperty("账套主体") private String accountSubject = StringUtils.EMPTY;
    /**
     * 申请划款金额
     *
     * @pdOid 3dc78f8b-3da0-494c-929f-d4c75f397f33
     */
    @ExcelProperty("申请划款金额") private double applyAmount;
    /**
     * 实际划款金额
     *
     * @pdOid 7651fc90-0142-4a87-891f-ed29b28f413a
     */
    @ExcelProperty("实际划款金额") private double actualPaymentAmount;
    /**
     * 款项类别id
     *
     * @pdOid d7a851b3-a6d8-400c-946c-47d88bca4e0d
     */
    @ExcelProperty("款项类别id") private String moneyCategoryId = StringUtils.EMPTY;
    /**
     * 款项类别名称
     *
     * @pdOid 501604b6-f372-4283-b034-235a1c3fa7c6
     */
    @ExcelProperty("款项类别名称") private String moneyCategoryName = StringUtils.EMPTY;
    /**
     * 款项类型id
     *
     * @pdOid fe15a68b-ccce-496c-abe2-021dbbb292d4
     */
    @ExcelProperty("款项类型id") private String moneyTypeId = StringUtils.EMPTY;
    /**
     * 款项类型名称
     *
     * @pdOid ca488bfb-17d0-4d19-bf80-871de0b90fa4
     */
    @ExcelProperty("款项类型名称") private String moneyTypeName = StringUtils.EMPTY;
    /**
     * 合伙人id
     *
     * @pdOid 042513b4-ea7c-4286-8fa2-d8dadd889b1c
     */
    @ExcelProperty("合伙人id") private String partnerId = StringUtils.EMPTY;
    /**
     * 合伙人名称
     *
     * @pdOid 1a833479-d7f0-4231-ac78-1d4c929f3f74
     */
    @ExcelProperty("合伙人名称") private String partnerName = StringUtils.EMPTY;
    /**
     * 申请人
     *
     * @pdOid 403af816-8694-4b59-91ca-41c61809bf97
     */
    @ExcelProperty("申请人") private String applyUser = StringUtils.EMPTY;
    /**
     * 附件集合
     *
     * @pdOid ca106126-3d82-466d-843f-c5fd1acf9f87
     */
    @ExcelIgnore
    private List<Map> files = new ArrayList<>();
    /**
     * 备注
     *
     * @pdOid ebef9d76-0037-4f16-a7c1-3c7edc559b48
     */
    @ExcelProperty("备注") private String remarks = StringUtils.EMPTY;
    /**
     * 状态 0：待审核 1：审核中 2：待付款 3：已付款 4：审核不通过 5：已撤销
     *
     * @pdOid d87910c3-e775-4c89-b235-9a5c4340a644
     */
    @ExcelProperty("单据状态") private String status = "3";
    /**
     * 是否删除 1:是；0:否
     *
     * @pdOid a0991c6c-aa90-4cf9-b8cc-c2fdc403af3d
     */
    @ExcelProperty("是否删除") private String delFlag = StringUtils.EMPTY;
    /**
     * 创建人
     *
     * @pdOid 734a048d-7611-4a07-95f8-b06a48876883
     */
    @ExcelProperty("创建人") private String createBy = StringUtils.EMPTY;
    /**
     * 修改人
     *
     * @pdOid 7dd99665-367d-4352-ac98-2b92703b3df3
     */
    @ExcelProperty("修改人") private String updateBy = StringUtils.EMPTY;
    /**
     * 创建时间
     *
     * @pdOid 94278fad-073b-4100-997a-28aeffcbaea2
     */
    @ExcelProperty("创建时间") private Date createTime;
    /**
     * 修改时间
     *
     * @pdOid f4ce7281-0a24-4527-92fa-340432b3fe84
     */
    @ExcelProperty("修改时间") private Date updateTime;

    @ExcelProperty("审批流程实例id") private 	String procInstId = StringUtils.EMPTY;
    @ExcelProperty("收款账户id") private String receivablesAccountId = StringUtils.EMPTY;

    @ExcelProperty("数据源") private String dataSource = "EPMS";
}