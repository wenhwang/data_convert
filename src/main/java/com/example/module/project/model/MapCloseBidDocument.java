package com.example.module.project.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

//封标
@Data
public class MapCloseBidDocument {
    private Date closeBidTime;
    private String closeBidUser = StringUtils.EMPTY;
    private String closeBidAddress = StringUtils.EMPTY;
    private String checkUser = StringUtils.EMPTY;
    private String sealResult = StringUtils.EMPTY;
    private String sealConclusion = StringUtils.EMPTY;
    private String signResult = StringUtils.EMPTY;
    private String signConclusion = StringUtils.EMPTY;
    private String scrapClauseResult = StringUtils.EMPTY;
    private String scrapClauseConclusion = StringUtils.EMPTY;
    private String qualificationResult = StringUtils.EMPTY;
    private String qualificationConclusion = StringUtils.EMPTY;
    private String bonusPointsResult = StringUtils.EMPTY;
    private String bonusPointsConclusion = StringUtils.EMPTY;
    private String quoteResult = StringUtils.EMPTY;
    private String quoteConclusion = StringUtils.EMPTY;
    private String closeResult = StringUtils.EMPTY;
    private String closeConclusion = StringUtils.EMPTY;
    private String scriptResult = StringUtils.EMPTY;
    private String scriptConclusion = StringUtils.EMPTY;
    private String remarks = StringUtils.EMPTY;

}
