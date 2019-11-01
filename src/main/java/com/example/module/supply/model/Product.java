package com.example.module.supply.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * 商品
 *
 * @pdOid 0cb02da5-d694-49f3-b45c-73319f3b33e4
 */
@Data
public class Product {
    /**
     * 商品id
     *
     * @pdOid 8280f45f-c91d-4682-8702-e901d7f7be19
     */
    private String commodityId = StringUtils.EMPTY;
    /**
     * 商品名称
     *
     * @pdOid cbf106dc-8ba2-45a3-b4c2-5afd26b8bdc0
     */
    private String commodityName = StringUtils.EMPTY;
    /**
     * 商品编码
     *
     * @pdOid 23dd458b-a6cb-43a7-9d5f-8164c6920194
     */
    private String commodityCode = StringUtils.EMPTY;
    /**
     * 商品图片地址
     *
     * @pdOid a0f1cdf5-7684-491e-838a-3dd8920dcb7a
     */
    private String image = StringUtils.EMPTY;
    /**
     * 商品分类id
     *
     * @pdOid 6bce3bbe-9804-4eb2-90dd-24142f735456
     */
    private String categoryId = StringUtils.EMPTY;
    /**
     * 商品一级分类
     *
     * @pdOid 52cca60a-11c8-4706-ada5-63dfc9b5e8a0
     */
    private String categoryOne = StringUtils.EMPTY;
    /**
     * 商品二级分类
     *
     * @pdOid b142a491-ef91-433f-b2fc-226dd3037a67
     */
    private String categoryTwo = StringUtils.EMPTY;
    /**
     * 商品三级分类
     *
     * @pdOid ed2632ef-8aef-4cbc-beb1-f55348bcec1d
     */
    private String categoryThree = StringUtils.EMPTY;
    /**
     * 规格型号
     * 规格型号
     *
     * @pdOid ee42a253-c41b-4018-99be-7b2cd1241529
     */
    private String model = StringUtils.EMPTY;
    /**
     * 单位
     *
     * @pdOid 4ca444d4-a0da-4d6b-999e-01ccab320d11
     */
    private String unit = StringUtils.EMPTY;
    /**
     * 品牌
     *
     * @pdOid 8ab6321d-0848-4ce1-acf9-f766d6fa6757
     */
    private String brand = StringUtils.EMPTY;
    /**
     * 供应商id
     *
     * @pdOid c9f0c22b-fcbc-4d91-9415-6849298034be
     */
    private String supplierId = StringUtils.EMPTY;
    /**
     * 供应商名称
     *
     * @pdOid c6813ba3-7f66-4818-9334-aee15f699781
     */
    private String supplier = StringUtils.EMPTY;
    /**
     * 生产日期
     *
     * @pdOid 589ffa53-a2b9-4a0c-b15c-fabf193dff5e
     */
    private Date produceDate;
    /**
     * 过期日期
     *
     * @pdOid 4b90a898-0469-4f51-bc78-33308678193c
     */
    private Date overdueDate;
    /**
     * 是否有效 0：有效 1：无效
     *
     * @pdOid c06ee829-f405-43eb-a0e1-302e23d01e5b
     */
    private int isValid = 0;
    /**
     * 采购价
     *
     * @pdOid 01b2abe5-8fd0-4e15-88b5-fdd24f3fe429
     */
    private double purchasePrice;
    /**
     * 销售价
     *
     * @pdOid b2e90e66-2c5d-445d-bb46-3c3545f89982
     */
    private double salesPrice;
    /**
     * 活动价
     *
     * @pdOid d4506e4f-8aa9-477d-9cf1-a073874afb9d
     */
    private double activityPrice;
    /**
     * 简介
     *
     * @pdOid 88ed27b0-a97c-4cd5-92c8-bed6f0deb132
     */
    private String synopsis = StringUtils.EMPTY;
    /**
     * 创建人
     *
     * @pdOid b47203f6-fc1e-4bc5-b416-5ab8682566da
     */
    private String createBy = StringUtils.EMPTY;
    /**
     * 修改人
     *
     * @pdOid 9b893889-ff83-4d1d-a138-ba0e1228e60a
     */
    private String updateBy = StringUtils.EMPTY;
    ;
    /**
     * 创建时间
     *
     * @pdOid 00396f53-bda7-4816-ba43-0f24edfb6232
     */
    private Date createTime;
    /**
     * 修改时间
     *
     * @pdOid 8d851427-a098-46cf-a2ef-d04564b6b245
     */
    private Date updateTime;
    private String delFlag = "0";
    private String dataSource = "EPMS";

}