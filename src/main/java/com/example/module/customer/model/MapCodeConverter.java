package com.example.module.customer.model;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.example.config.SpringContextHolder;
import com.example.module.HelperService;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapCodeConverter implements Converter<String> {

    private static  List<Map> CUST_INDS = new ArrayList<>();

    private static  List<Map> CUST_FEATURES = new ArrayList<>();

    private static  List<Map> CUST_LEVELS = new ArrayList<>();

    private static List<Map> CUST_SOURCES = new ArrayList<>();

    private static  List<Map> CUST_STATUS = new ArrayList<>();


    static{
        HelperService helperService = SpringContextHolder.getBean(HelperService.class);
        //customer_industry
        CUST_INDS = helperService.query("label", "客户行业", new String[]{"dictId", "dictName"}, "sys_dict");
        //customer_feature
        CUST_FEATURES = helperService.query("label", "客户特征", new String[]{"dictId", "dictName"}, "sys_dict");
        //customer_level
        CUST_LEVELS = helperService.query("label", "客户等级", new String[]{"dictId", "dictName"}, "sys_dict");
        //customer_source
        CUST_SOURCES = helperService.query("label", "客户来源", new String[]{"dictId", "dictName"}, "sys_dict");
        //custStatus
        CUST_STATUS = helperService.query("label", "客户状态", new String[]{"dictId", "dictName"}, "sys_dict");
    }
    @Override
    public Class supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public String convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
                                    GlobalConfiguration globalConfiguration) {
        String data = cellData.getStringValue();
        String name = contentProperty.getHead().getHeadNameList().get(0);

        List<Map> maps = null;
        if("客户行业".equals(name)) maps = CUST_INDS;
        else if ("客户分级".equals(name)) maps = CUST_LEVELS;
        else if ("客户特征".equals(name)) maps = CUST_FEATURES;
        else if ("客户来源".equals(name)) maps = CUST_SOURCES;
        else if ("客户状态".equals(name)) maps = CUST_STATUS;

        //所属专业
        //客户性质
        //客户类型
        String refId = HelperService.replaceRefId(data, maps);
        if(!StringUtils.isEmpty(refId)) data += "-"+refId;
        return data;
    }

    @Override
    public CellData convertToExcelData(String value, ExcelContentProperty contentProperty,
        GlobalConfiguration globalConfiguration) {
        return new CellData(value);
    }

}