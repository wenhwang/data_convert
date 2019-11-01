package com.example.module.project;

import com.example.module.project.model.MapBidDocument;
import com.example.module.project.model.MapBidList;
import com.example.module.project.model.MapCloseBidDocument;
import com.example.module.project.model.MapContractCompany;
import com.example.module.project.model.MapDeposit;
import com.example.module.project.model.MapLaborTeamList;
import com.example.module.project.model.MapMakeBidDocument;
import com.example.module.project.model.MapManageCompany;
import com.example.module.project.model.MapProjectBusinessAudit;
import com.example.module.project.model.MapProjectQualificationAudit;
import com.example.module.project.model.MapProjectSkillAudit;
import com.example.module.project.model.MapWinBidResultAnalyse;
import com.example.module.project.model.ProjectAgreement;
import com.example.module.project.model.ProjectAnswer;
import com.example.module.project.model.ProjectBid;
import com.example.module.project.model.ProjectInfo;

import java.util.List;

public interface ProjectMapper {

    List<ProjectBid> selectTenderInfoHandler();

    List<ProjectInfo> selectProjectInfo();

    List<MapDeposit> selectEnrollQualifications(String projectId);

    List<MapBidDocument> selectBidDocuments(String projectId);

    List<MapProjectQualificationAudit> selectProjectQualificationAudits(String projectId);

    List<MapProjectSkillAudit> selectProjectSkillAudits(String projectId);

    List<MapProjectBusinessAudit> selectProjectBusinessAudits(String projectId);

    List<MapMakeBidDocument> selectMakeBidDocuments(String projectId);

    List<MapCloseBidDocument> selectCloseBidDocuments(String projectId);

    List<MapWinBidResultAnalyse> selectWinBidResultAnalyses(String projectId);

    List<MapBidList> selectBidList(String projectId);

    List<ProjectAnswer> selectProjectAsks(String projectId);

    List<ProjectAgreement> selectAgreementProjects();

    List<MapManageCompany> selectAgreementManageCompany(String projectId);

    List<MapContractCompany> selectAgreementContractCompany(String projectId);

    List<MapLaborTeamList> selectAgreementLaborTeamList(String projectId);

    List<ProjectBid> selectBaseProjectHandler();

}
