package com.example.module.customer;

import com.example.module.HelperService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class CustomerService {

    public static final String CUST_TYPE_1 = "合伙人";
    public static final String CUST_TYPE_2 = "业主";
    public static final String CUST_TYPE_3 = "招投标单位";
    public static final String CUST_TYPE_4 = "劳务单位";

    public static final String TABLE_NAME = "customer_info";

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private HelperService helperService;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 处理合伙人数据
     *
     * @return
     */
    @Transactional
    public List<Map<String, String>> customerHandler(String custType) {
        List<Map<String, String>> reuslts = null;
        if (CUST_TYPE_1.equals(custType)) {
            reuslts = customerMapper.selectCustomerInfoCobberList();
        } else if (CUST_TYPE_2.equals(custType)) {
            reuslts = customerMapper.selectCustomerInfoSubjectPersonList();
        } else if (CUST_TYPE_3.equals(custType)) {
            reuslts = customerMapper.selectCustomerInfoTenderCompanyList();
        } else if (CUST_TYPE_4.equals(custType)) {
            reuslts = customerMapper.selectCustomerInfoLabourCompanyList();
            reuslts.addAll(customerMapper.selectAnotherCustomerInfoLabourCompanyList());
        }
        //处理客户类型customer_type
        String customerTypeId = helperService.querySignleField("label", "客户类型", "dictId", "sys_dict", custType);

        //customer_industry
        List<Map> custInds = helperService.query("label", "客户行业", new String[]{"dictId", "dictName"}, "sys_dict");
        //customer_feature
        List<Map> custFeatures = helperService.query("label", "客户特征", new String[]{"dictId", "dictName"}, "sys_dict");
        //customer_level
        List<Map> custLevels = helperService.query("label", "客户等级", new String[]{"dictId", "dictName"}, "sys_dict");
        //customer_source
        List<Map> custSources = helperService.query("label", "客户来源", new String[]{"dictId", "dictName"}, "sys_dict");
        reuslts.forEach(s -> {
            s.put("dataSource", "EPMS");
            s.put("delFlag", "0");
            // s.put("customerId", UUID.randomUUID().toString().replace("-",""));

            s.put("customerTypeId", customerTypeId);

            //处理所属行业ID
            String industry = s.get("industry");
            if (StringUtils.isNotBlank(industry)) {
                s.put("industryId", HelperService.replaceRefId(industry, custInds));
            }

            //处理客户特征ID
            String feature = s.get("feature");
            if (StringUtils.isNotBlank(feature)) {
                s.put("featureId", HelperService.replaceRefId(feature, custFeatures));
            }

            //处理客户等级ID
            String level = s.get("level");
            if (StringUtils.isNotBlank(level)) {
                s.put("levelId", HelperService.replaceRefId(level, custLevels));
            }

            //处理客户来源ID
            String source = s.get("source");
            if (StringUtils.isNotBlank(source)) {
                s.put("sourceId", HelperService.replaceRefId(source, custSources));
            }

        });

        log.info("查询到{}数据:{}条记录", custType, reuslts.size());
        if (!Objects.isNull(reuslts)) {
            mongoTemplate.insert(reuslts, TABLE_NAME);
            log.info("批量插入MongoDB 集合 :{} ", TABLE_NAME);
        }
        return reuslts;
    }

}
