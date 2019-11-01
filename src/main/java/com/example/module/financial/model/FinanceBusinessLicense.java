package com.example.module.financial.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * 外经证
 *
 * @pdOid 924542f4-b659-475e-b862-52591fe7ce38
 */
@Data
public class FinanceBusinessLicense {
    /**
     * 外经证ID
     *
     * @pdOid b3454d48-9177-4bee-8e3f-b837a0291fca
     */
    private String businessLicenseId = StringUtils.EMPTY;
    /**
     * 外经证编号
     *
     * @pdOid 6bf2b810-f0a5-4944-b9a7-c9bea75824ef
     */
    private String sysNumber = StringUtils.EMPTY;
    /**
     * 项目id
     *
     * @pdOid 0e4cbd98-d8f5-4305-bd75-e17bb36bd7f8
     */
    private String projectId = StringUtils.EMPTY;
    /**
     * 项目名称
     *
     * @pdOid 5bb6b94e-63aa-49da-ac32-11e44300b028
     */
    private String projectName = StringUtils.EMPTY;
    /**
     * 项目编号
     *
     * @pdOid f88a7885-a02e-4e43-81b1-82e15735e6c6
     */
    private String projectNumber = StringUtils.EMPTY;
    /**
     * 合同ID
     *
     * @pdOid 05b40fc2-c017-4546-84ff-262100daf0d9
     */
    private String contractId = StringUtils.EMPTY;
    /**
     * 合同名称
     *
     * @pdOid fe05a6ae-2e37-4971-aa18-cada75be079d
     */
    private String contractName = StringUtils.EMPTY;
    /**
     * 合同编号
     *
     * @pdOid 2213f404-2c81-4bdd-953a-bb3d3e27dfca
     */
    private String contractNumber = StringUtils.EMPTY;
    /**
     * 合同金额
     *
     * @pdOid 755b3935-8de0-44b7-961e-185cc82ff6e3
     */
    private String contractAmount = StringUtils.EMPTY;
    /**
     * 业主id
     *
     * @pdOid ea7d028a-5cda-45e4-8800-cffae577aa99
     */
    private String ownerId = StringUtils.EMPTY;
    /**
     * 业主名称
     *
     * @pdOid 1f66067b-30ca-47e1-8718-fe502051f826
     */
    private String ownerName = StringUtils.EMPTY;
    /**
     * 合伙人id
     *
     * @pdOid 9e04f154-bddb-41e8-8970-6b1406d74102
     */
    private String partnerId = StringUtils.EMPTY;
    /**
     * 合伙人名称
     *
     * @pdOid 3db912c8-eae6-4ff6-a57b-7d6176fd8523
     */
    private String partnerName = StringUtils.EMPTY;
    /**
     * 申请日期
     *
     * @pdOid 22e79b12-cf96-4340-8555-5b03f9187a1b
     */
    private Date applyDate;
    /**
     * 申请人
     *
     * @pdOid 18b516d4-d0af-4740-9cf7-75fa2bffdd8c
     */
    private String applyUser = StringUtils.EMPTY;
    /**
     * 领用人
     *
     * @pdOid 34a7d8b0-f7cf-4689-89a9-4a9fd195583b
     */
    private String receiveUser = StringUtils.EMPTY;
    /**
     * 外经证开具地址
     *
     * @pdOid d9bfb4c0-78db-4ccf-b4ed-39fbd8107a90
     */
    private String address = StringUtils.EMPTY;
    /**
     * 完税税务局名称
     *
     * @pdOid 3a454c2d-64fc-4b91-8b3e-a9ddcd8cb2ed
     */
    private String taxBureauName = StringUtils.EMPTY;
    /**
     * 已开具金额
     *
     * @pdOid 4d99c162-b295-4d7c-8ebd-6d66a19f81ec
     */
    private double overOpenAmount;
    /**
     * 申请开具金额
     *
     * @pdOid 6b4990b2-f975-425d-ba6e-75a1777dfed4
     */
    private double applyOpenAmount;
    /**
     * 实际开具金额
     *
     * @pdOid cf44a6b5-9e1d-4ac2-baec-ac94ca5bdbca
     */
    private double actualOpenAmount;
    /**
     * 累计开具金额
     *
     * @pdOid 7efd69bd-65e5-42af-9a22-a6aa3b729f1b
     */
    private double totalOpenAmount;
    /**
     * 外经证编码
     *
     * @pdOid be7e98ee-4e8f-4c72-a45c-b60813427444
     */
    private String businessLicenseNumber = StringUtils.EMPTY;
    /**
     * 失效时间
     */
    private Date endDate;

    /**
     * 生效时间
     */
    private Date startDate;
    /**
     * 附件集合
     *
     * @pdOid 8b3d7835-0750-41e0-aff5-0ee72951e4d2
     */
    private String files = StringUtils.EMPTY;
    /**
     * 备注
     *
     * @pdOid ef7a147a-f01e-46cb-a677-61a10f61a92e
     */
    private String remarks = StringUtils.EMPTY;
    /**
     * 状态 0：待审核 1：审核中 2：审核不通过 3：待开具（审核通过） 4：待交接 5：待交接确认 6：已交接（待完税申请） 7：待完税确认 8：已完税 9：待核销确认 10：已核销 11：已撤销
     *
     * @pdOid bad51575-7c8c-48b5-95de-78a3849303f6
     */
    private String status = StringUtils.EMPTY;
    /**
     * 是否删除 1:是；0:否
     *
     * @pdOid 67351998-c1b9-4f6d-a385-9ce3ce0c4018
     */
    private String delFlag = StringUtils.EMPTY;
    /**
     * 创建人
     *
     * @pdOid 2bc9c1e2-62bd-4bc3-bf1c-a3cf77c1d2ea
     */
    private String createBy = StringUtils.EMPTY;
    /**
     * 修改人
     *
     * @pdOid 27e42543-3a27-4552-82cd-545a2071a3e2
     */
    private String updateBy = StringUtils.EMPTY;
    /**
     * 创建时间
     *
     * @pdOid 1ffd5f09-e9bf-4321-9323-e9d475e4c1c4
     */
    private Date createTime;
    /**
     * 修改时间
     *
     * @pdOid 1b35e5c0-3b79-4867-9115-43878208b380
     */
    private Date updateTime;
    private String isPrintInvoice = StringUtils.EMPTY; //外经证状态
    private String dataSource = "EPMS";
}