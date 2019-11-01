package com.example.module.financial.model;

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
     *
     * @pdOid 4276ada3-b5db-440f-bbc4-481e3fa288d0
     */
    private String reimbursementId = StringUtils.EMPTY;
    /**
     * 备用金单号
     *
     * @pdOid 879db5aa-ed95-4dcc-b0db-519769dac0ad
     */
    private String sysNumber = StringUtils.EMPTY;
    /**
     * 备用金类型id
     *
     * @pdOid 40adc7dd-eb38-4ba3-91f8-1e16de7d1928
     */
    private String imprestTypeId = StringUtils.EMPTY;
    ;
    /**
     * 备用金类型
     *
     * @pdOid c0a9b14d-a8eb-49ca-966a-fe8f0ece4a54
     */
    private String imprestTypeName = StringUtils.EMPTY;
    ;
    /**
     * 申请人
     *
     * @pdOid 899e81b9-0b70-44d9-9cae-151d2d955343
     */
    private String applyUser = StringUtils.EMPTY;
    ;
    /**
     * 申请部门ID
     *
     * @pdOid d3f27395-3a13-41f0-8316-7204943bac4b
     */
    private String departmentId = StringUtils.EMPTY;
    ;
    /**
     * 申请部门名称
     *
     * @pdOid 2239c515-fc69-4729-84b1-2a64ce6b0adc
     */
    private String departmentName = StringUtils.EMPTY;
    ;
    /**
     * 币种id
     *
     * @pdOid 2df35707-913e-42ff-a465-07ba718af83f
     */
    private String currencyTypeId = StringUtils.EMPTY;
    ;
    /**
     * 币种名称
     *
     * @pdOid 825735cc-a8bf-422b-b4d2-cd50315bfbf2
     */
    private String currencyTypeName = StringUtils.EMPTY;
    ;
    /**
     * 申请金额
     *
     * @pdOid 282dd65c-bb39-447f-93ba-4c0a585e80ce
     */
    private double applyAmount;
    /**
     * 付款名称
     *
     * @pdOid 2133f5af-c97c-4905-9cda-736e69fe03d7
     */
    private String paymentName = StringUtils.EMPTY;
    ;
    /**
     * 付款银行
     *
     * @pdOid 6506235f-5e75-42e0-a20a-818bd6221ed1
     */
    private String paymentBank = StringUtils.EMPTY;
    ;
    /**
     * 付款账号
     *
     * @pdOid deb11d8e-8159-4035-be39-466241b1f51e
     */
    private String paymentAccount = StringUtils.EMPTY;
    ;
    /**
     * 收款名称
     *
     * @pdOid b5b779b9-7250-43b8-afc9-baad70e478de
     */
    private String repaymentName = StringUtils.EMPTY;
    ;
    /**
     * 收款银行
     *
     * @pdOid 38cfb1f2-cc3b-4012-b3ee-7a0d5576edde
     */
    private String repaymentBank = StringUtils.EMPTY;
    ;
    /**
     * 收款账号
     *
     * @pdOid 0d5138ac-6427-44fe-b083-e2be55ac12a4
     */
    private String repaymentAccount = StringUtils.EMPTY;
    ;
    /**
     * 费用承担单位id
     *
     * @pdOid a0426153-b675-4d1a-808d-31ddff0fe5e6
     */
    private String companyId = StringUtils.EMPTY;
    ;
    /**
     * 费用承担单位名称
     *
     * @pdOid 444dc748-df27-4918-97b3-95925d35a773
     */
    private String companyName = StringUtils.EMPTY;
    ;
    /**
     * 帐套主体
     *
     * @pdOid 61bebf18-8b12-462c-8b9c-3de15ee3b727
     */
    private String accountSubject = StringUtils.EMPTY;
    ;
    /**
     * 用途
     *
     * @pdOid e2da4275-a162-4b16-b11e-0a2d524ea75e
     */
    private String remarks = StringUtils.EMPTY;
    ;
    /**
     * 状态 0：待审核 1：审核中 2：待付款 3：已完成 4：审核不通过 5：已撤销
     *
     * @pdOid 331d45cd-3327-44e0-bff1-1baa9a9d4905
     */
    private String status = "3";
    /**
     * 附件集合
     *
     * @pdOid 3f04d643-f058-4962-9a0f-5bbda02cd23d
     */
    private String files = StringUtils.EMPTY;
    ;
    /**
     * 是否删除 1:是；0:否
     *
     * @pdOid 524e5fe8-5254-4970-90be-93e385f9bee1
     */
    private String delFlag = StringUtils.EMPTY;
    ;
    /**
     * 创建人
     *
     * @pdOid 1b19c1e2-1071-4578-beea-b27a6a25c001
     */
    private String createBy = StringUtils.EMPTY;
    ;
    /**
     * 修改人
     *
     * @pdOid 5dfecc02-ad60-4a96-845a-558dc947655f
     */
    private String updateBy = StringUtils.EMPTY;
    ;
    /**
     * 创建时间
     *
     * @pdOid 5d51a55d-6a99-40bd-ac1a-5142b657aac8
     */
    private Date createTime;
    ;
    /**
     * 修改时间
     *
     * @pdOid da680f98-51a5-4d40-a837-0dfaf884add2
     */
    private Date updateTime;
    ;

    //批准金额
    private double approveAmount;
    private String dataSource = "EPMS";
}