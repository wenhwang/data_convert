package com.example.module.supply.model;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 供应商
 *
 * @pdOid 9c7a51a2-ffb5-4e83-89f1-9d10b6f11d19
 */
@Data
public class Supplier implements Serializable {
    /**
     * 供应商id
     *
     * @pdOid 0eabcc62-9a14-48f2-8496-1035991d015d
     */
    private String supplierId = StringUtils.EMPTY;
    /**
     * 供应商编码
     *
     * @pdOid 3fc5d4ce-c1cb-498a-b0b3-5aeeddae2d44
     */
    private String supplierCode = StringUtils.EMPTY;
    /**
     * 供应商名称
     *
     * @pdOid 3893c404-48b9-4940-9e66-a894750a2b93
     */
    private String supplierName = StringUtils.EMPTY;
    /**
     * 主要联系人
     *
     * @pdOid 90b20dad-6f21-407a-971f-1166653978c4
     */
    private String contacts = StringUtils.EMPTY;
    /**
     * 联系电话
     *
     * @pdOid 13b8c606-bb6f-441c-8660-cd6be99af69d
     */
    private String phone = StringUtils.EMPTY;
    /**
     * 省份
     *
     * @pdOid fe8561cb-2df2-455f-b217-3bc575bab045
     */
    private String province = StringUtils.EMPTY;
    /**
     * 市
     *
     * @pdOid 3a10e081-3ea8-4d78-a6e7-3e9de0c1e890
     */
    private String city = StringUtils.EMPTY;
    /**
     * 区县
     *
     * @pdOid d4e61f42-0ab2-4e5f-8fb6-25a18fac3346
     */
    private String county = StringUtils.EMPTY;
    /**
     * 详细地址
     *
     * @pdOid ce7d1418-6989-467a-88e1-9416809a616d
     */
    private String address = StringUtils.EMPTY;
    /**
     * 网址
     *
     * @pdOid 33353422-2713-4830-8898-d2c2b44c2bf0
     */
    private String website = StringUtils.EMPTY;
    /**
     * 账期
     *
     * @pdOid ea82c989-1832-4607-99cb-c12a0dc675fc
     */
    private String accountPeriod = StringUtils.EMPTY;
    /**
     * 账户名称
     *
     * @pdOid 8a9aa921-1233-4b81-a3b7-45bff44a36c3
     */
    private String accountName = StringUtils.EMPTY;
    /**
     * 开户行
     *
     * @pdOid a5b6dfbd-9496-4849-b844-548626161f65
     */
    private String bankName = StringUtils.EMPTY;
    /**
     * 银行账号
     *
     * @pdOid bbe48607-d9f2-4dd9-8b31-4e18eb38965c
     */
    private String bankAccount = StringUtils.EMPTY;
    /**
     * 交货能力打分
     *
     * @pdOid 7d96afde-6d36-4e1f-947d-883e8c58629d
     */
    private int deliveryScore;
    /**
     * 服务能力打分
     *
     * @pdOid 88e775cf-51be-446a-9019-15f33ba96f95
     */
    private int serviceScore;
    /**
     * 信用等级打分
     *
     * @pdOid b76d3015-c623-42ef-91b6-4c44a277b9fb
     */
    private int creditScore;
    /**
     * 供货成本打分
     *
     * @pdOid e7a63560-1840-4a55-a53e-68014f44a381
     */
    private int supplyCostScore;
    /**
     * 创建人
     *
     * @pdOid f0e4f0cd-a46b-4e1f-8587-231ae4b39431
     */
    private String createBy = StringUtils.EMPTY;
    /**
     * 修改人
     *
     * @pdOid 9857cc89-870c-4699-9515-cfadb928b5f1
     */
    private String updateBy = StringUtils.EMPTY;
    /**
     * 创建时间
     *
     * @pdOid 1b45ad15-ed65-4889-95ec-881bc63017b8
     */
    private Date createTime;
    /**
     * 修改时间
     *
     * @pdOid 8f96ad38-ac2d-48b9-9a4a-f9f90d323f5d
     */
    private Date updateTime;
    private String delFlag = "0";
    private String dataSource = "EPMS";

}