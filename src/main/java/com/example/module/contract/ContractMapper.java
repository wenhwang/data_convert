package com.example.module.contract;

import java.util.List;
import java.util.Map;

public interface ContractMapper {

    //工程合同
    List<Map<String,String>> selectEngineeringContract();

    //增补合同
    List<Map<String,String>> selectExtEngineeringContract();

    //劳务合同
    List<Map<String, String>> selectLaborContract();

    //采购合同
    List<Map<String, String>> selectPurchaseContract();

    //分包合同
    List<Map<String, String>> selectSubContract();

    //合伙人合同
    List<Map<String, String>> selectCobberContract();

    //回款计划
    List<Map<String, String>> selectPayPlanContract();
}
