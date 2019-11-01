package com.example.module.project.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class ProjectAnswer {
    private String bidId = StringUtils.EMPTY;//	招投标id
    private String answerEndDate = StringUtils.EMPTY;//答疑截止日期
    private String clarifyEndDate = StringUtils.EMPTY;//澄清截止日期
    private String email = StringUtils.EMPTY;//答疑接收邮箱
    private String answerDate = StringUtils.EMPTY;//答疑日期
    private String addUser = StringUtils.EMPTY;//发起人
    private String content = StringUtils.EMPTY;//答疑内容
    private List<Map> answerFile = new ArrayList<>();//答疑附件集合
    private String replyDate = StringUtils.EMPTY;//回复日期
    private String replyUser = StringUtils.EMPTY;//回复人
    private String replyContent = StringUtils.EMPTY;//回复内容
    private List<Map> replyFile	 = new ArrayList<>();//回复附件集合
    private String dataSource = "EPMS";
}
