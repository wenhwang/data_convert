package com.example.module.project;


import com.example.module.project.model.MapAgreement;
import com.example.module.project.model.MapBidDocument;
import com.example.module.project.model.MapBidList;
import com.example.module.project.model.MapCloseBidDocument;
import com.example.module.project.model.MapDeposit;
import com.example.module.project.model.MapMakeBidDocument;
import com.example.module.project.model.MapProjectBusinessAudit;
import com.example.module.project.model.MapProjectQualificationAudit;
import com.example.module.project.model.MapProjectSkillAudit;
import com.example.module.project.model.MapWinBidResultAnalyse;
import com.example.module.project.model.ProjectAgreement;
import com.example.module.project.model.ProjectAnswer;
import com.example.module.project.model.ProjectBid;
import com.example.module.project.model.ProjectInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ProjectService {


    public static final String TABLE_PROJECT_INFO = "project_info";
    public static final String TABLE_PROJECT_AGREEMENT = "project_agreement";
    public static final String TABLE_PROJECT_BID = "project_bid";
    public static final String TABLE_PROJECT_ANSWER = "project_answer";

    @Autowired
    private MongoTemplate mongoTemplate;

    @Resource
    private ProjectMapper projectMapper;


    @Transactional
    public List<ProjectInfo> projectInfoHandler(){
        List<ProjectInfo> projectInfos = projectMapper.selectProjectInfo();
        log.info("查询到项目基本信息数据:{}条记录",projectInfos.size());
        if(!Objects.isNull(projectInfos)){
            mongoTemplate.insert(projectInfos, TABLE_PROJECT_INFO);
            log.info("批量插入MongoDB 集合 :{} ",TABLE_PROJECT_INFO);
        }
        return projectInfos;
    }

    //招投标合同数据
    @Transactional
    public List<ProjectBid> tenderInfoHandler() {

        //项目答疑
        List<ProjectAnswer> allAnswers = new ArrayList<>();
        //查询项目报名表招投标信息
        List<ProjectBid> projectBids = projectMapper.selectTenderInfoHandler();

        log.info("查询到招投标 {} 条数据",projectBids.size());
        projectBids.parallelStream().forEach(projectBid -> {
            String  projectId = projectBid.getProjectId();
            //项目报名 enrollQualifications

            //查询缴纳保证金信息 deposits
            setProjectBidProperties(projectBid,projectId,"缴纳保证金",projectMapper.selectEnrollQualifications(projectId),MapDeposit.class);

           //查询招投标文件解读 bidDocument
            setProjectBidProperties(projectBid,projectId,"文件解读",projectMapper.selectBidDocuments(projectId), MapBidDocument.class);

            //项目资格审核  projectQualificationAudit
            setProjectBidProperties(projectBid,projectId,"资格审核",projectMapper.selectProjectQualificationAudits(projectId), MapProjectQualificationAudit.class);

            //项目技术审核 projectSkillAudit
            setProjectBidProperties(projectBid,projectId,"技术审核",projectMapper.selectProjectSkillAudits(projectId), MapProjectSkillAudit.class);

            //项目商务评审 projectBusinessAudit
            setProjectBidProperties(projectBid,projectId,"商务评审",projectMapper.selectProjectBusinessAudits(projectId), MapProjectBusinessAudit.class);

            //标书制作  makeBidDocument
            setProjectBidProperties(projectBid,projectId,"标书制作",projectMapper.selectMakeBidDocuments(projectId), MapMakeBidDocument.class);

            //封标 closeBidDocument
            setProjectBidProperties(projectBid,projectId,"封标",projectMapper.selectCloseBidDocuments(projectId), MapCloseBidDocument.class);

            //开标竞争对手信息
            setProjectBidProperties(projectBid,projectId,"开标竞争对手",projectMapper.selectBidList(projectId), MapBidList.class);

            //开标结果分析 winBidResultAnalyse
            setProjectBidProperties(projectBid,projectId,"开标结果分析",projectMapper.selectWinBidResultAnalyses(projectId), MapWinBidResultAnalyse.class);

            //项目答疑
            List<ProjectAnswer> projectAnswers = projectMapper.selectProjectAsks(projectId);
            projectAnswers.forEach(projectAnswer -> projectAnswer.setBidId(projectBid.getBidId()));
            allAnswers.addAll(projectAnswers);
        });

        //查询项目表'已报备', '报备中', '已立项'数据
       // List<ProjectBid> baseProjectBids = projectMapper.selectBaseProjectHandler();

        //合并数据
        //projectBids.addAll(baseProjectBids);

        if(!Objects.isNull(projectBids)) {
            log.info("保存数据:project_bid");
            mongoTemplate.insert(projectBids, TABLE_PROJECT_BID);
        }
        if(!Objects.isNull(allAnswers)) {
            log.info("保存数据:project_answer");
            mongoTemplate.insert(allAnswers, TABLE_PROJECT_ANSWER);
        }
        return projectBids;
    }

    private void setProjectBidProperties(ProjectBid projectBid, String projectId, String attrDesc, List props, Class clazz) {
        if(props != null &&props.size()>0) {
           // log.info("查询招投标项目：{} {} 信息：{}条记录", projectId,attrDesc, props);
            switch (clazz.getSimpleName()) {
                case "MapDeposit": projectBid.setDeposit((MapDeposit) props.get(0));break;
                case "MapBidDocument": projectBid.setBidDocument((MapBidDocument) props.get(0));break;
                case "MapProjectQualificationAudit": projectBid.setProjectQualificationAudit((MapProjectQualificationAudit) props.get(0));break;
                case "MapProjectSkillAudit": projectBid.setProjectSkillAudit((MapProjectSkillAudit) props.get(0));break;
                case "MapProjectBusinessAudit": projectBid.setProjectBusinessAudit((MapProjectBusinessAudit) props.get(0));break;
                case "MapMakeBidDocument": projectBid.setMakeBidDocument((MapMakeBidDocument) props.get(0));break;
                case "MapCloseBidDocument": projectBid.setCloseBidDocument((MapCloseBidDocument) props.get(0));break;
                case "MapBidList": projectBid.setBidList(props);break;
                case "MapWinBidResultAnalyse": projectBid.setWinBidResultAnalyse((MapWinBidResultAnalyse) props.get(0));break;
            }
        }else {
            log.debug("未查询招投标项目：{} {} 信息", projectId,attrDesc);
        }
    }

    //工程项目数据处理 TODO:合同类型ID处理
    @Transactional
    public List<ProjectAgreement> agreementHandler() {
        //查询状态为已签约的项目
        List<ProjectAgreement> agreements = projectMapper.selectAgreementProjects();
        log.info("查询到工程项目数据:{}条记录",agreements.size());
        agreements.parallelStream().forEach(projectAgreement -> {
            String projectId = projectAgreement.getProjectId();
            MapAgreement projectMap = projectAgreement.getProjectMap();
            //查询建设单位 buildCompany
            //查询监理单位 manageCompany
            projectMap.setManageCompany(projectMapper.selectAgreementManageCompany(projectId));
            //查询设计单位 designCompany
            //查询总包单位 contractCompany
            projectMap.setContractCompany(projectMapper.selectAgreementContractCompany(projectId));
            //查询其他单位 otherCompany
            //查询劳务班组集合 laborTeamList
            projectMap.setLaborTeamList(projectMapper.selectAgreementLaborTeamList(projectId));
        });

        if(!Objects.isNull(agreements)){
            mongoTemplate.insert(agreements, TABLE_PROJECT_AGREEMENT);
            log.info("保存数据 :{} ",TABLE_PROJECT_AGREEMENT);
        }
        return agreements;
    }
}
