package com.example.module.financial.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 收款
 *
 * @pdOid 976a5ebc-77f1-4b78-9d60-6707b5b5307c
 */
@Data
public class FinanceReceivables {
    /**
     * 收款单ID
     *
     * @pdOid 28837f76-a502-4453-bb29-6b4eaf9ed1f3
     */
    private String receivablesId = StringUtils.EMPTY;
    /**
     * 收款单编号
     *
     * @pdOid 64910b0e-dbd4-4ec8-bb55-f4823a3d1b85
     */
    private String sysNumber = StringUtils.EMPTY;
    /**
     * 项目id
     *
     * @pdOid 8d4c47b6-ec4f-4503-82b1-ba3dcf780f7b
     */
    private String projectId = StringUtils.EMPTY;
    /**
     * 项目名称
     *
     * @pdOid d5d68cb9-18d5-4c46-96e0-96efbc54b9f2
     */
    private String projectName = StringUtils.EMPTY;
    /**
     * 项目编码
     *
     * @pdOid f7c8cfc9-4c01-4c64-b7ec-d66cd14d37b7
     */
    private String projectCode = StringUtils.EMPTY;
    /**
     * 合同ID
     *
     * @pdOid 881f619f-5bee-4ffb-8bcf-ccb765000f37
     */
    private String contractId = StringUtils.EMPTY;
    /**
     * 合同名称
     *
     * @pdOid b05ffeab-96c1-4885-88a0-2ccf1ec49c16
     */
    private String contractName = StringUtils.EMPTY;
    /**
     * 合同编号
     *
     * @pdOid 7ff6c642-30ff-4284-b397-b5fbf1e637db
     */
    private String contractNumber = StringUtils.EMPTY;
    /**
     * 合同金额
     *
     * @pdOid cc617d10-c3b4-4d3d-9fd3-dac0882d0444
     */
    private String contractAmount = StringUtils.EMPTY;
    /**
     * 收款类型id
     *
     * @pdOid a562d859-c5fb-4ac9-b4c3-c1a81a9a889c
     */
    private String receivablesTypeId = StringUtils.EMPTY;
    /**
     * 收款类型名称
     *
     * @pdOid f22775f2-753b-48cf-8da3-c31867df21cb
     */
    private String receivablesTypeName = StringUtils.EMPTY;
    /**
     * 款项类别id
     *
     * @pdOid 61d35869-4669-4842-bb33-3580050d88b3
     */
    private String typeId = StringUtils.EMPTY;
    /**
     * 款项类别名称
     *
     * @pdOid 3b0de9a9-035b-4a4f-925c-9c83bb3539c1
     */
    private String typeName = StringUtils.EMPTY;
    /**
     * 收款单位
     *
     * @pdOid 47a78e1b-2860-4792-ac49-62e8856efb12
     */
    private String receivablesCompany = StringUtils.EMPTY;
    /**
     * 收款账户
     *
     * @pdOid 2a282d93-0f16-43dc-b1ea-16fa3c522298
     */
    private String receivablesAccount = StringUtils.EMPTY;
    /**
     * 收款银行
     *
     * @pdOid 9b14ca7d-1d06-4e5d-86b1-f2b2b5dabe6a
     */
    private String receivablesBank = StringUtils.EMPTY;
    /**
     * 付款单位
     *
     * @pdOid deb9bb8d-cf7e-448d-9471-48391005eb90
     */
    private String payCompany = StringUtils.EMPTY;
    /**
     * 付款账户
     *
     * @pdOid b88348f7-deb8-47df-9797-1bc6d44f31af
     */
    private String payAccount = StringUtils.EMPTY;
    /**
     * 付款银行
     *
     * @pdOid d33548cd-593a-4b1c-85ac-c69c5a64e261
     */
    private String payBank = StringUtils.EMPTY;
    /**
     * 累计开票金额
     *
     * @pdOid 64fe2267-4328-46ce-9ed0-57efaaecf55e
     */
    private double totalInvoiceAmount;
    /**
     * 累计结算金额
     *
     * @pdOid bb991636-4e55-4346-8925-85d30a1b3faf
     */
    private double totalSettlementAmount;
    /**
     * 计划收款金额
     *
     * @pdOid 9e7a7f1f-ed06-46e4-903e-0d1fa62667b3
     */
    private double estimateReceivablesAmount;
    /**
     * 累计收款金额
     *
     * @pdOid 6ffb352d-6799-453d-aa6f-f78a3211c96e
     */
    private double totalReceivablesAmount;
    /**
     * 实际收款金额
     *
     * @pdOid 1322c408-7933-4a59-bd2c-ce634d4aa68e
     */
    private double actualReceivablesAmount;
    /**
     * 实际收款日期
     *
     * @pdOid bb8031f1-8867-4e52-9ff4-aeabf24eb1ec
     */
    private String actualReceivablesDate = StringUtils.EMPTY;
    /**
     * 合伙人id
     *
     * @pdOid ebad0f90-4b12-4446-b42a-182888fee46f
     */
    private String partnerId = StringUtils.EMPTY;
    /**
     * 合伙人名称
     *
     * @pdOid b2689684-3cc7-49f8-92e0-3575eb310948
     */
    private String partnerName = StringUtils.EMPTY;
    /**
     * 申请日期
     *
     * @pdOid c9f6bba6-b375-4d32-a507-15382d9dadc3
     */
    private String applyDate = StringUtils.EMPTY;
    /**
     * 申请人
     *
     * @pdOid 78261e98-10dd-4c4f-aeec-bc1a559b5b82
     */
    private String applyUser = StringUtils.EMPTY;
    /**
     * 账套主体
     *
     * @pdOid c00323f5-6363-499c-8e5a-0707b51bdfeb
     */
    private String accountSubject = StringUtils.EMPTY;
    /**
     * 附件集合
     *
     * @pdOid f4ccdf85-2adc-4eb3-9946-c0f65689a00f
     */
    private List<Map> files = new ArrayList<>();
    /**
     * 摘要
     *
     * @pdOid f65e5e21-20e7-48a1-a8be-77591c3eeb00
     */
    private String _abstract = StringUtils.EMPTY;
    /**
     * 备注
     *
     * @pdOid e6d67edd-1a98-470e-9790-98c8ba2dc7b5
     */
    private String remarks = StringUtils.EMPTY;
    /**
     * 是否推送开票申请单 1:是；0:否
     *
     * @pdOid 80d25d7d-97c4-4750-9038-d0c82ad4d8f3
     */
    private String isPush = StringUtils.EMPTY;
    /**
     * 收款单状态 0：待审核 1：审核中 2：待收款 3：已收款 4：审核不通过 5：已撤销
     *
     * @pdOid e7bef654-0804-4a73-aff2-4e04b95979f0
     */
    private String status = "3";
    /**
     * 是否删除 1:是；0:否
     *
     * @pdOid 1569ffde-2244-408c-9df7-93e1ed2cbd9d
     */
    private String delFlag = StringUtils.EMPTY;
    /**
     * 创建人
     *
     * @pdOid c87256e3-fbce-4c0c-82b7-9682a5bce983
     */
    private String createBy = StringUtils.EMPTY;
    /**
     * 修改人
     *
     * @pdOid fa49ea97-d843-4bd0-82cc-b8193c7d627e
     */
    private String updateBy = StringUtils.EMPTY;
    /**
     * 创建时间
     *
     * @pdOid 2460ed73-2e63-47bd-b965-90477d26c6b3
     */
    private Date createTime;
    /**
     * 修改时间
     *
     * @pdOid 3b796cd1-b190-4ad6-b7dd-8e240c43ecc2
     */
    private Date updateTime;
    private String dataSource = "EPMS";
}