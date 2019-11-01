package com.example.module.project.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

//投标单位（开标结果分析竞争对手）
@Data
public class MapBidList {
    private String company = StringUtils.EMPTY; //投标单位
    private String brand = StringUtils.EMPTY; //投标品牌
    private String architect = StringUtils.EMPTY; //建造师
    private String quote = StringUtils.EMPTY; //报价
    private String rank = StringUtils.EMPTY; //名次

}
