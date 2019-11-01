package com.example.module.customer;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {

    /**
     * 查询合伙人
     *
     * @return
     */
    List<Map<String, String>> selectCustomerInfoCobberList();

    /**
     * 查询业主
     *
     * @return
     */
    List<Map<String, String>> selectCustomerInfoSubjectPersonList();

    /**
     * 查询招标单位
     *
     * @return
     */
    List<Map<String, String>> selectCustomerInfoTenderCompanyList();

    //劳务单位1
    List<Map<String, String>> selectCustomerInfoLabourCompanyList();

    //劳务单位1
    List<Map<String, String>> selectAnotherCustomerInfoLabourCompanyList();
}
