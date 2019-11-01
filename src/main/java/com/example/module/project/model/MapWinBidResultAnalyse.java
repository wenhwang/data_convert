package com.example.module.project.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

//开标结果分析
@Data
public class MapWinBidResultAnalyse {
    private String finalWinner = StringUtils.EMPTY;
    private String isWinBid = StringUtils.EMPTY;
    private double winBidAmount;
    private Date publicityDate;
    private String website = StringUtils.EMPTY;
    private String resultAnalyse = StringUtils.EMPTY;
    private String bidWinNotice = StringUtils.EMPTY;
}
