package com.example.module.resource.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class ArchiveManageNew {
    private String number = StringUtils.EMPTY;	//		业绩编码 > 合同编号
    private String sysNumber = StringUtils.EMPTY;//			业绩编号
    private String archiveId = StringUtils.EMPTY;//			业绩id
    private String archiveType	 = StringUtils.EMPTY;//		档案类型
    private String  projectId = StringUtils.EMPTY;//			项目Id
    private String  projectName	 = StringUtils.EMPTY;//		项目名
    private String  name	 = StringUtils.EMPTY;//		合同名
    private String  contractId	 = StringUtils.EMPTY;//		合同Id
    private String createBy	 = StringUtils.EMPTY;//		创建人
    private Date createTime;//		创建时间
    private String updateBy	 = StringUtils.EMPTY;//		修改人
    private Date updateTime	;//		修改时间
    private String delFlag	 = StringUtils.EMPTY;//		删除标识
    private String type		 = StringUtils.EMPTY;//	业绩类别 > 项目类别
    private String typeId	 = StringUtils.EMPTY;//		业绩类别Id > 项目类别Id
    private Date startWorkDate;//		开工日期
    private Date checkWorkDate;//			验收日期
    private String useStatus	 = StringUtils.EMPTY;//		使用状态
    private String validityStatus = StringUtils.EMPTY;//			有效期状态
    private String useNum	 = StringUtils.EMPTY;//		使用次数
    private String aheadTimeRemindDate	 = StringUtils.EMPTY;//		即将到期提醒时间
    private String partnerName		 = StringUtils.EMPTY;//	合伙人
    private String partnerId	 = StringUtils.EMPTY;//		合伙人Id
    private String safekeepUser	 = StringUtils.EMPTY;//		保管人
    private String safekeepUserId = StringUtils.EMPTY;//		保管人Id
    private String parentType	 = StringUtils.EMPTY;//		证件类型父类
    private String parentTypeId		 = StringUtils.EMPTY;//	证件类型父类Id
    private String safekeepUserRealName	 = StringUtils.EMPTY;//		保管人真实姓名
    private String completionDate		 = StringUtils.EMPTY;//	竣工日期
    private double actualContractAmount	;//		合同金额
    private Date publicityDate	;//		中标时间
    private double winBidAmount;//		中标金额
    private String isEnabled	 = StringUtils.EMPTY;//		是否可用
    private String remarks		 = StringUtils.EMPTY;//	备注
    private String acceptanceCriteriaId	 = StringUtils.EMPTY;//		验收标准Id
    private String acceptanceCriteria	 = StringUtils.EMPTY;//		验收标准
    private String constructionArea	 = StringUtils.EMPTY;//		建设面积
    private String builder		 = StringUtils.EMPTY;//	项目经理
    private String brand	 = StringUtils.EMPTY;//		品牌
    private Date endDat;//		失效日期
    private Date startDate;//		生效日期
    private double projectContractTotalAmount;//		项目合同总金额
    private String contractType		 = StringUtils.EMPTY;//	合同类别
    private String contractTypeId	 = StringUtils.EMPTY;//		合同类别Id
    private String projectCode	 = StringUtils.EMPTY;//		项目编号
    private String dataSource = "EPMS";
}
