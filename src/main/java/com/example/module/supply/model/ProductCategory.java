package com.example.module.supply.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * 商品分类
 *
 * @pdOid 46f2defe-9a83-45ad-ae76-cfb7361bb6ad
 */
@Data
public class ProductCategory {
    /**
     * 分类id
     *
     * @pdOid ed39c571-8800-4395-bd3a-2e60b4a5f85c
     */
    private String categoryId = StringUtils.EMPTY;
    /**
     * 分类名称
     *
     * @pdOid f0ef4652-84fa-4ca7-8c71-465c41f56edd
     */
    private String categoryName = StringUtils.EMPTY;
    /**
     * 上级分类id
     *
     * @pdOid f170571e-f439-4655-bd7d-e4b4ac47079c
     */
    private String parentId = StringUtils.EMPTY;
    /**
     * 创建人
     *
     * @pdOid 93acaac1-87b7-4795-a98f-8fb26556a4b6
     */
    private String createBy = StringUtils.EMPTY;
    /**
     * 修改人
     *
     * @pdOid 8a85961d-4f2b-467d-bc81-2f8d5e47e909
     */
    private String updateBy = StringUtils.EMPTY;
    /**
     * 创建时间
     *
     * @pdOid 484eb2f1-5fa0-4977-a4e1-ffdd053ef5b6
     */
    private Date createTime;
    /**
     * 修改时间
     *
     * @pdOid 372733b9-08bd-4075-a412-2605e2dbc05d
     */
    private Date updateTime;
    private String delFlag = "0";
    private String dataSource = "EPMS";

}