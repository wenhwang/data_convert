package com.example.module.resource;


import com.example.module.HelperService;
import com.example.module.resource.model.ArchiveApply;
import com.example.module.resource.model.ArchiveFile;
import com.example.module.resource.model.ArchiveLendLog;
import com.example.module.resource.model.ArchiveManage;
import com.example.module.resource.model.ArchiveManageNew;
import com.example.module.system.SystemService;
import com.example.module.system.model.MapCodeCategory;
import com.example.module.system.model.MapcodeParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class ResourceService {

    public static final String TABLE_ARCHIVE_APPLY = "archive_apply";
    public static final String TABLE_ARCHIVE_FILE = "archive_file";
    public static final String TABLE_ARCHIVE_MANAGE = "archive_manage";
    public static final String TABLE_ARCHIVE_LEND_LOG = "archive_lend_log";

    @Autowired
    private HelperService helperService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Resource
    private ResourceMapper resourceMapper;

    @Resource
    private SystemService systemService;

    @Transactional
    public List<Map<String, String>> categoryHandler() {

        List<Map<String, String>> categorys = resourceMapper.selectResourceCategoryParent();
        categorys.forEach(m -> {
            String label = StringUtils.EMPTY;
            String resouceCategoryId = m.get("resouceCategoryId");
            String resouceCategoryName = m.get("resouceCategoryName");
            switch (resouceCategoryName) {
                case "招投标账户":
                    label = "招投标账户";
                    break;
                case "公司证照":
                    label = "公司证照";
                    break;
                case "人员证照":
                    label = "人员证照";
                    break;
                case "印章":
                    resouceCategoryName = "印章证照";
                    label = "印章证照";
                    break;
                case "合同业绩":
                    label = "项目业绩";
                    resouceCategoryName = "项目业绩";
                    break;
            }
            List<String> items = resourceMapper.selectResourceCategoryChild(resouceCategoryId);
            MapCodeCategory category = systemService.insertCategory(label, resouceCategoryName, "144b6c2866f448e58a2983ded95b24e0");
            log.info("新增分类 :{}", resouceCategoryName);
            MapcodeParam mapcodeParam = new MapcodeParam();
            String[] itemNames = new String[items.size()];
            items.toArray(itemNames);
            mapcodeParam.setLabel(label);
            mapcodeParam.setCategoryId(category.getCategoryId());
            mapcodeParam.setDictNames(itemNames);
            systemService.insertCategoryItems(mapcodeParam);
            log.info("新增分类 :{} 下子类别 :{}", resouceCategoryName, items);
        });
        return categorys;
    }


    public List<ArchiveApply> applyReceiptHandler() {
        List<ArchiveApply> archiveApplies = resourceMapper.selectApplyReceipts();
        log.info("已查询供应商数据:{} 条记录", archiveApplies.size());

        //处理事情单状态 :状态,使用状态 useStatus
        archiveApplies.parallelStream().forEach(archiveApply -> {
            String applyId = archiveApply.getApplyId();
            log.info("hanldler apply id {}:", applyId);
            Map<String,String> statMap = resourceMapper.selectApplyReceiptDetail(applyId);
            if(statMap == null){
                log.info("no detail of：{} ", applyId);
                archiveApply.setUseStatus("0");
                archiveApply.setStatus("5");
                return ;
            }
            String stat = statMap.get("STAT");

            if(StringUtils.contains(stat, "0")){//待借出
                archiveApply.setUseStatus("0");
            }else if(StringUtils.contains(stat, "1")){//已借出
                archiveApply.setUseStatus("1");
                archiveApply.setStatus("4");
           }else if(StringUtils.contains(stat, "2")) {//已归还
                archiveApply.setUseStatus("0");
                archiveApply.setStatus("5");
                //设置时间归还时间
                Map<String, Date> dateMap = resourceMapper.selectApplyReceiptReturnTime(applyId);
                if(!Objects.isNull(dateMap)){
                    archiveApply.setActualReturnTime(dateMap.get("RETURN_DATE"));
                }

           }
        });


        if (!Objects.isNull(archiveApplies)) {
            mongoTemplate.insert(archiveApplies, TABLE_ARCHIVE_APPLY);
            log.info("保存数据 ---> :{} ", TABLE_ARCHIVE_APPLY);
        }
        return archiveApplies;
    }


    @Transactional
    public List<ArchiveFile> attachementHandler() {
        List<ArchiveFile> archiveFiles = resourceMapper.selectAttachements();
        log.info("Query {} data of {} type ", "资源附件", archiveFiles.size());
        //TODO:上传到OSS
        if (!Objects.isNull(archiveFiles)) {
            mongoTemplate.insert(archiveFiles, TABLE_ARCHIVE_FILE);
            log.info("Save new data to ", TABLE_ARCHIVE_FILE);
        }
        return archiveFiles;
    }

    @Transactional
    public List<ArchiveManage> companyCertHandler() {

        List<Map> categorys = helperService.query("label", "公司证照", new String[]{"categoryId"}, "sys_dict_category");
        List<Map> childTypes = helperService.query("label", "公司证照", new String[]{"dictId", "dictName"}, "sys_dict");
        String categoryId = categorys.get(0).get("categoryId") + "";
        List<ArchiveManage> companyCerts = resourceMapper.selectCompanyCerts();
        log.info("Query {} data of {} type ", "公司证照", companyCerts.size());
        if (!Objects.isNull(companyCerts)) {
            //todo:查询附件
            companyCerts.forEach(r -> {
                r.setParentTypeId(categoryId);
                r.setTypeId(HelperService.replaceRefId(r.getType(), childTypes));
            });
            mongoTemplate.insert(companyCerts, TABLE_ARCHIVE_MANAGE);
            log.info("Save new data to {}", TABLE_ARCHIVE_MANAGE);
        }
        return companyCerts;
    }

    @Transactional
    public List<ArchiveManage> emplyeeCertHandler() {
        List<Map> categorys = helperService.query("label", "人员证照", new String[]{"categoryId"}, "sys_dict_category");
        List<Map> childTypes = helperService.query("label", "人员证照", new String[]{"dictId", "dictName"}, "sys_dict");
        String categoryId = categorys.get(0).get("categoryId") + "";
        List<ArchiveManage> emplyeeCerts = resourceMapper.selectEmplyeeCerts();
        log.info("Query {} data of {} type ", "人员证照", emplyeeCerts.size());
        if (!Objects.isNull(emplyeeCerts)) {
            //todo:查询附件
            emplyeeCerts.forEach(r -> {
                r.setParentTypeId(categoryId);
                r.setTypeId(HelperService.replaceRefId(r.getType(), childTypes));
            });
            mongoTemplate.insert(emplyeeCerts, TABLE_ARCHIVE_MANAGE);
            log.info("Save new data to {} ", TABLE_ARCHIVE_MANAGE);
        }
        return emplyeeCerts;
    }

    @Transactional
    public List<ArchiveManage> stampCertHandler() {
        List<Map> categorys = helperService.query("label", "印章证照", new String[]{"categoryId"}, "sys_dict_category");
        List<Map> childTypes = helperService.query("label", "印章证照", new String[]{"dictId", "dictName"}, "sys_dict");
        String categoryId = categorys.get(0).get("categoryId") + "";
        List<ArchiveManage> stampCerts = resourceMapper.selectStampCerts();
        log.info("Query {} data of {} type ", "印章证照", stampCerts.size());
        if (!Objects.isNull(stampCerts)) {
            //todo:查询附件
            stampCerts.forEach(r -> {
                r.setParentTypeId(categoryId);
                r.setTypeId(HelperService.replaceRefId(r.getType(), childTypes));
            });
            mongoTemplate.insert(stampCerts, TABLE_ARCHIVE_MANAGE);
            log.info("Save new data to {} ", TABLE_ARCHIVE_MANAGE);
        }
        return stampCerts;
    }

    @Transactional
    public List<ArchiveManage> bidAccountHandler() {
        List<ArchiveManage> bidAccounts = resourceMapper.selectBidAccounts();
        log.info("Query {} data of {} type ", "招投标账户", bidAccounts.size());
        if (!Objects.isNull(bidAccounts)) {
            mongoTemplate.insert(bidAccounts, TABLE_ARCHIVE_MANAGE);
            log.info("Save new data to {}", TABLE_ARCHIVE_MANAGE);
        }
        return bidAccounts;
    }

    @Transactional
    public List<ArchiveManage> projectPerformanceHandler() {
        List<Map> categorys = helperService.query("label", "项目业绩", new String[]{"categoryId"}, "sys_dict_category");
        List<Map> childTypes = helperService.query("label", "项目业绩", new String[]{"dictId", "dictName"}, "sys_dict");
        String categoryId = categorys.get(0).get("categoryId") + "";

        List<ArchiveManage> projectPerformances = resourceMapper.selectProjectPerformances();
        log.info("Query {} data of {} type ", "项目业绩", projectPerformances.size());
        if (!Objects.isNull(projectPerformances)) {
            projectPerformances.forEach(r -> {
                r.setParentTypeId(categoryId);
                r.setTypeId(HelperService.replaceRefId(r.getType(), childTypes));
            });
            mongoTemplate.insert(projectPerformances, TABLE_ARCHIVE_MANAGE);
            log.info("Save new data to {} ", TABLE_ARCHIVE_MANAGE);
        }
        return projectPerformances;
    }

    @Transactional
    public List<ArchiveManageNew> newProjectPerformanceHandler() {
        List<Map> categorys = helperService.query("label", "项目业绩", new String[]{"categoryId"}, "sys_dict_category");
        List<Map> childTypes = helperService.query("label", "项目业绩", new String[]{"dictId", "dictName"}, "sys_dict");
        String categoryId = categorys.get(0).get("categoryId") + "";

        List<ArchiveManageNew> projectPerformances = resourceMapper.selectNewProjectPerformances();
        log.info("Query {} data of {} type ", "项目业绩", projectPerformances.size());
        if (!Objects.isNull(projectPerformances)) {
            projectPerformances.forEach(r -> {
                r.setParentTypeId(categoryId);
                r.setTypeId(HelperService.replaceRefId(r.getType(), childTypes));
            });
            mongoTemplate.insert(projectPerformances, TABLE_ARCHIVE_MANAGE);
            log.info("Save new data to {} ", TABLE_ARCHIVE_MANAGE);
        }
        return projectPerformances;
    }



    public List<ArchiveLendLog> cmpEmyStampRecordHandler() {
        List<ArchiveLendLog> lendLogs = resourceMapper.selectCmpEmyStampRecords();
        log.info("Query {} data of {} type ", "档案使用记录", lendLogs.size());
        if (!Objects.isNull(lendLogs)) {
            mongoTemplate.insert(lendLogs, TABLE_ARCHIVE_LEND_LOG);
            log.info("Save new data to {}", TABLE_ARCHIVE_LEND_LOG);
        }
        return lendLogs;
    }

    public List<ArchiveLendLog> bidAccountRecordHandler() {
        List<ArchiveLendLog> lendLogs = resourceMapper.selectBidAccountRecords();
        log.info("Query {} data of {} type ", "招投标账户使用记录", lendLogs.size());
        if (!Objects.isNull(lendLogs)) {
            mongoTemplate.insert(lendLogs, TABLE_ARCHIVE_LEND_LOG);
            log.info("Save new data to {}", TABLE_ARCHIVE_LEND_LOG);
        }
        return lendLogs;
    }

    public List<ArchiveLendLog> projectPerformanceRecordandler() {
        List<ArchiveLendLog> lendLogs = resourceMapper.selectProjectPerformanceRecors();
        log.info("Query {} data of {} type ", "项目业绩使用记录", lendLogs.size());
        if (!Objects.isNull(lendLogs)) {
            mongoTemplate.insert(lendLogs, TABLE_ARCHIVE_LEND_LOG);
            log.info("Save new data to {}", TABLE_ARCHIVE_LEND_LOG);
        }
        return lendLogs;
    }

    public static void main(String[] args) {
        String stat = "0,1,2";
        boolean contains = StringUtils.contains(stat, "0");
        System.out.println(contains);
    }
}
