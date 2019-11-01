package com.example.module.resource.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class ArchiveManage {
    //档案id
    private String archiveId  = StringUtils.EMPTY;
    //证件编号
    private String number = StringUtils.EMPTY;
    //档案名称
    private String name = StringUtils.EMPTY;
    private String area = StringUtils.EMPTY;
    private String isCA = StringUtils.EMPTY;
    //保管人
    private String safekeepUser = StringUtils.EMPTY;
    //保管人ID
    private String safekeepUserId = StringUtils.EMPTY;
    //删除标识
    private String delFlag = "0";
    //创建人
    private String createBy = StringUtils.EMPTY;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //修改人
    private String updateBy = StringUtils.EMPTY;
    //是否可用
    private String isEnabled = "0";
    //使用状态
    private String useStatus = StringUtils.EMPTY;
    //生效时间
    private Date startDate;
    //失效时间
    private Date endDate;
    //备注
    private String remarks = StringUtils.EMPTY;
    //档案编号
    private String sysNumber = StringUtils.EMPTY;
    //档案类型
    private String archiveType = StringUtils.EMPTY;
    //证件类型父类
    private String parentType = StringUtils.EMPTY;
    //证件类型父类ID
    private String parentTypeId = StringUtils.EMPTY;
    //证件类型子类Id
    private String typeId = StringUtils.EMPTY;
    //证件类型子类
    private String type = StringUtils.EMPTY;

    //附件
    private Set<String> files = new HashSet<>();

    //原项目Id
    private String originalProjectId;
    //原项目名
    private String originalProjectName;
    //原合同名
    private String originalContractName;
    //原合同Id
    private String originalContractId;
    //业绩金额
    private String performance;
    //开工日期
    private String startWorkDate;
    //验收日期
    private String checkWorkDate;
    //有效期状态
    private String validityStatus;
    //招标网址
    private String biddingWebSite = StringUtils.EMPTY;
    //账号所属平台名称
    private String platformName = StringUtils.EMPTY;
    //账号
    private String account = StringUtils.EMPTY;
    //使用次数
    private int useNum;
    //即将到期提醒时间
    private String aheadTimeRemindDate = StringUtils.EMPTY;
    //合伙人
    private String partnerName =  StringUtils.EMPTY;
    //合伙人Id
    private String partnerId =  StringUtils.EMPTY;

    private String dataSource = "EPMS";
}
