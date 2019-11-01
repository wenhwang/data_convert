package com.example.module.project.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

//标书制作
@Data
public class MapMakeBidDocument {
    private String isReplace = StringUtils.EMPTY;
    private String replaceTypeId = StringUtils.EMPTY;
    private String replaceType = StringUtils.EMPTY;
    private String expectedDeliveryDate = StringUtils.EMPTY;
    private String producer = StringUtils.EMPTY;
    private String completionTime = StringUtils.EMPTY;
    private String productionCost = StringUtils.EMPTY;
    private String brandContacts = StringUtils.EMPTY;
    private String brandContactInformation = StringUtils.EMPTY;
    private String productionRequirements = StringUtils.EMPTY;
    private String createBy = StringUtils.EMPTY;
    private String updateBy = StringUtils.EMPTY;
    private Date createTime;
    private Date updateTime;

}
