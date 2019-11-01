package com.example.module.project.model;


import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Document("project_bid")
public class ProjectBid {
    private String bidId = UUID.randomUUID().toString().replace("-","");
    private String projectId = StringUtils.EMPTY;
    private String status = StringUtils.EMPTY; //招投标状态
    private String step = StringUtils.EMPTY;//招投标进度
    private String isEnroll = StringUtils.EMPTY;//是否报名成功
    private String enrollWay = StringUtils.EMPTY;//报名方式
    private String enrollCost = StringUtils.EMPTY;//报名费用
    private String enrollUserId = StringUtils.EMPTY;//实际报名人id
    private String enrollUserName = StringUtils.EMPTY;//实际报名人
    private String annualFee = StringUtils.EMPTY;//年费金额
    private String realityEnrollTime = StringUtils.EMPTY;//实际报名时间
    private String createBy = StringUtils.EMPTY;
    private String createTime = StringUtils.EMPTY;
    private String updateBy = StringUtils.EMPTY;
    private String updateTime = StringUtils.EMPTY;
    private String delFlag = StringUtils.EMPTY;
    private MapDeposit deposit = new MapDeposit();
    private MapBidDocument bidDocument = new MapBidDocument();
    private MapProjectQualificationAudit projectQualificationAudit = new MapProjectQualificationAudit();
    private MapProjectSkillAudit projectSkillAudit = new MapProjectSkillAudit();
    private MapProjectBusinessAudit projectBusinessAudit = new MapProjectBusinessAudit();
    private MapMakeBidDocument makeBidDocument = new MapMakeBidDocument();
    private MapCloseBidDocument closeBidDocument = new MapCloseBidDocument();
    private MapWinBidResultAnalyse winBidResultAnalyse = new MapWinBidResultAnalyse();
    private List<MapBidList> bidList = new ArrayList<>();
    private String dataSource = "EPMS";
}
