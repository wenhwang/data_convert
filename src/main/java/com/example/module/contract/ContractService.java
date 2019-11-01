package com.example.module.contract;

import com.example.module.HelperService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class ContractService {

    public static final String CONTRACT_TYPE_1 = "工程合同";
    public static final String CONTRACT_TYPE_2 = "增补合同";
    public static final String CONTRACT_TYPE_3 = "劳务合同";
    public static final String CONTRACT_TYPE_4 = "采购合同";
    public static final String CONTRACT_TYPE_5= "分包合同";
    public static final String CONTRACT_TYPE_6 = "合伙人合同";

    public static final String TABLE_NAME = "contract_manage";
    public static final String PAY_PLAN_TABLE_NAME = "contract_partner_receivables_plan";

    @Resource
    private ContractMapper contractMapper;

    @Resource
    private HelperService helperService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Transactional
    public List<Map<String,String>> contractHandler(String contractType){
        List<Map> contractTypes = null;
        List<Map<String, String>> reuslts = null;
        if(CONTRACT_TYPE_1.equals(contractType)){//project_contract_type
            log.info("handler:{}",CONTRACT_TYPE_1);
            contractTypes = helperService.query("label", "工程合同类型", new String[]{"dictId", "dictName"}, "sys_dict");
            reuslts = contractMapper.selectEngineeringContract();

        }else if (CONTRACT_TYPE_2.equals(contractType)){//project_contract_type
            log.info("handler:{}",CONTRACT_TYPE_2);
            contractTypes = helperService.query("label", "工程合同类型", new String[]{"dictId", "dictName"}, "sys_dict");
            reuslts = contractMapper.selectExtEngineeringContract();
        }else if (CONTRACT_TYPE_3.equals(contractType)){//project_contract_type
            log.info("handler:{}",CONTRACT_TYPE_3);
            contractTypes = helperService.query("label", "工程合同类型", new String[]{"dictId", "dictName"}, "sys_dict");
            reuslts = contractMapper.selectLaborContract();
        }else if (CONTRACT_TYPE_4.equals(contractType)){//purchase_contract_type
            log.info("handler:{}",CONTRACT_TYPE_4);
            contractTypes = helperService.query("label", "采购合同类型", new String[]{"dictId", "dictName"}, "sys_dict");
            reuslts = contractMapper.selectPurchaseContract();

        }else if (CONTRACT_TYPE_5.equals(contractType)){
            reuslts = contractMapper.selectSubContract();
            log.info("handler:{}",CONTRACT_TYPE_5);
        }else if (CONTRACT_TYPE_6.equals(contractType)){//partner_contract_type
            contractTypes = helperService.query("label", "合伙人合同类型", new String[]{"dictId", "dictName"}, "sys_dict");
            reuslts = contractMapper.selectCobberContract();
            log.info("handler:{}",CONTRACT_TYPE_6);
        }

        //invoice_type
        List<Map> invoiceTypes = helperService.query("label", "发票类型", new String[]{"dictId", "dictName"}, "sys_dict");
        List<Map> finalContractTypes = contractTypes;
        reuslts.forEach(s ->{
            s.put("dataSource", "EPMS");
            //处理开票方式
            String invoiceType = s.get("invoiceType");
            if(StringUtils.isNotBlank(invoiceType)){
                s.put("invoiceTypeId", replaceRefId(invoiceType,invoiceTypes));
            }
            //处理其他合同类型
            String type = s.get("contractType");
            if (StringUtils.isNotBlank(type)) {
                s.put("contractTypeId", replaceRefId(type, finalContractTypes));
            }

            //处理采购合同类型
            if(CONTRACT_TYPE_4.equals(contractType) && Objects.nonNull(finalContractTypes)) {
                String purchaseType = s.get("contractType");
                if (StringUtils.isNotBlank(purchaseType)) {
                    s.put("contractTypeId", replaceRefId(purchaseType, finalContractTypes));
                }
            }
        });

        log.info("查询到{}数据:{}条记录",contractType,reuslts.size());
        if(!Objects.isNull(reuslts)){
            mongoTemplate.insert(reuslts, TABLE_NAME);
            log.info("批量插入MongoDB 集合 :{} ",TABLE_NAME);
        }
        return reuslts;
    }

    private String replaceRefId(String val, List<Map> custInds) {
        if(Objects.isNull(custInds) || custInds.isEmpty()) return StringUtils.EMPTY;
        Map<String,String> empty = new HashMap<>();
        empty.put("dictId",StringUtils.EMPTY);
        return (String) custInds.stream().filter(map ->  map.containsValue(val)).findFirst().orElseGet(() -> empty).get("dictId");
    }

    @Transactional
    public List<Map<String, String>> payPlanContract() {
        List<Map<String, String>> reuslts  = contractMapper.selectPayPlanContract();
        log.info("查询到合同回款计划数据:{}条记录",reuslts.size());
        if(!Objects.isNull(reuslts)){
            mongoTemplate.insert(reuslts, PAY_PLAN_TABLE_NAME);
            log.info("批量插入MongoDB 集合 :{} ",PAY_PLAN_TABLE_NAME);
        }
        return reuslts;
    }
}
