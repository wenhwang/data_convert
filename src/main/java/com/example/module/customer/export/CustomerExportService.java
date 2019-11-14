package com.example.module.customer.export;

import com.alibaba.excel.EasyExcel;
import com.example.module.HelperService;
import com.example.module.customer.CustomerMapper;
import com.example.module.customer.model.Cust;
import com.example.module.customer.model.Customer;
import com.example.module.customer.model.CustomerReadListener;
import com.example.module.customer.model.MapCustAccount;
import com.example.utils.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CustomerExportService {
    public static final String SAVE_PATH = new File("files/export/customer/").getPath();
    public static final String FILE_EXT = ".xlsx";


    public static final String CUST_TYPE_1 = "合伙人";
    public static final String CUST_TYPE_2 = "业主";
    public static final String CUST_TYPE_3 = "招投标单位";
    public static final String CUST_TYPE_4 = "劳务单位";


    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private HelperService helperService;


    /**
     * 处理合伙人数据
     *
     * @return
     */
    @Transactional
    public List<Cust> customerHandler(String custType) {
        List<Cust> reuslts = null;
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
            s.setDataSource("EPMS");
            s.setDelFlag("0");
            // s.put("customerId", UUID.randomUUID().toString().replace("-",""));

            s.setCustomerTypeId(customerTypeId);

            //账户信息
            List<MapCustAccount> custAccounts = new ArrayList<>();
            MapCustAccount custAccount = new MapCustAccount(s.getAccountName(),s.getBankName(),s.getBankAccount());
            custAccounts.add(custAccount);
            s.setAccountList(custAccounts);
            //处理所属行业ID
            String industry = s.getIndustry();
            if (StringUtils.isNotBlank(industry)) {
                s.setIndustryId(HelperService.replaceRefId(industry, custInds));
            }

            //处理客户特征ID
            String feature = s.getFeature();
            if (StringUtils.isNotBlank(feature)) {
                s.setFeatureId(HelperService.replaceRefId(feature, custFeatures));
            }

            //处理客户等级ID
            String level = s.getLevel();
            if (StringUtils.isNotBlank(level)) {
                s.setLevelId(HelperService.replaceRefId(level, custLevels));
            }

            //处理客户来源ID
            String source = s.getSource();
            if (StringUtils.isNotBlank(source)) {
                s.setSourceId(HelperService.replaceRefId(source, custSources));
            }

        });

        //reuslts.parallelStream().map(r -> BeanUtils.populate(C))

        log.info("查询到{}数据:{}条记录", custType, reuslts.size());
        String filePath = SAVE_PATH+"/"+custType+FILE_EXT;
        log.info("save to File:{}",filePath);
        ExcelUtils.saveToFile(filePath,custType, Cust.class,reuslts);
        return reuslts;
    }

    //公海客户
    @Transactional
    public List<Customer> seasHandler(){
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("files/公海客户2019-11-04.xlsx");
        EasyExcel.read(resourceAsStream, Customer.class,new CustomerReadListener()).sheet().doRead();
        return null;
    }

}