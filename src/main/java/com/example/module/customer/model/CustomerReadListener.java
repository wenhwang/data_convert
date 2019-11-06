package com.example.module.customer.model;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.config.SpringContextHolder;
import com.example.utils.Documents;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
public class CustomerReadListener extends AnalysisEventListener<Customer> {
        private static final int BATCH_COUNT = 100;
        List<Customer> seasCusts = new ArrayList<Customer>();
        @Override
        public void invoke(Customer data, AnalysisContext analysisContext) {

            data.setCustomerTypeId(getFieldValue(data.getCustomerType()));
            data.setMajorTypeId(getFieldValue(data.getMajorType()));
            data.setFeatureId(getFieldValue(data.getFeature()));
            data.setStatusId(getFieldValue(data.getStatus()));
            data.setSourceId(getFieldValue(data.getSource()));
            data.setNatureId(getFieldValue(data.getNatures()));
            data.setLevelId(getFieldValue(data.getLevel()));
            data.setIndustryId(getFieldValue(data.getIndustry()));

            data.setCustomerType(getFieldKey(data.getCustomerType()));
            data.setMajorType(getFieldKey(data.getMajorType()));
            data.setFeature(getFieldKey(data.getFeature()));
            data.setStatus(getFieldKey(data.getStatus()));
            data.setSource(getFieldKey(data.getSource()));
            data.setNatures(getFieldKey(data.getNatures()));
            data.setLevel(getFieldKey(data.getLevel()));
            data.setIndustry(getFieldKey(data.getIndustry()));


           // log.info("解析到一条数据:{}",data);
            seasCusts.add(data);
            if (seasCusts.size() >= BATCH_COUNT) {
                saveData();
                seasCusts.clear();
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext analysisContext) {
            saveData();
            log.info("所有数据解析完成！");
        }


        private void saveData() {
            MongoTemplate mongoTemplate = SpringContextHolder.getBean(MongoTemplate.class);
            log.info("{}条数据，开始存储数据库！", seasCusts.size());
            Collection<Customer> insert = mongoTemplate.insert(seasCusts, Documents.CUSTOMER.CUSTOMER_INFO_DOC.docName);
            log.info("存储数据库成功:{} ",Documents.CUSTOMER.CUSTOMER_INFO_DOC.docName);
        }

        private String getFieldKey(String value){
            String[] split = value.split("-");
            return split.length>=2 ? split[0]:value;
        }

        private String getFieldValue(String value){
            String[] split = value.split("-");
            return split.length>=2 ? split[1]: StringUtils.EMPTY;
        }

    }