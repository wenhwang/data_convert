package com.example.module.customer;

import com.example.module.customer.model.Cust;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {

    /**
     * 查询合伙人
     *
     * @return
     */
    List<Cust> selectCustomerInfoCobberList();

    /**
     * 查询业主
     *
     * @return
     */
    List<Cust> selectCustomerInfoSubjectPersonList();

    /**
     * 查询招标单位
     *
     * @return
     */
    List<Cust> selectCustomerInfoTenderCompanyList();

    //劳务单位1
    List<Cust> selectCustomerInfoLabourCompanyList();

    //劳务单位1
    List<Cust> selectAnotherCustomerInfoLabourCompanyList();
}
