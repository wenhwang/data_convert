package com.example.module;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Field;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class HelperService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public String querySignleField(String fieldName,String fieldVal,String returnField,String collectionName,String dictNameWheres){
        Criteria criteria = Criteria.where(fieldName).is(fieldVal).and("dictName").is(dictNameWheres).and("isEnable").is("0").and("delFlag").is("0");
        Query query = Query.query(criteria);
        query.fields().include(returnField).exclude("_id");
        Map one = mongoTemplate.findOne(query, Map.class, collectionName);
        return one.get(returnField)+"";
    }

    public List<Map> queryMutilField(String fieldName, String[] fieldVals, String returnField, String collectionName){
        Criteria criteria = Criteria.where(fieldName).in(fieldVals).and("isEnable").is("0").and("delFlag").is("0");
        Query query = Query.query(criteria);
        query.fields().include(returnField).exclude("_id");
        List<Map> result = mongoTemplate.find(query, Map.class, collectionName);
        return result;
    }

    public List<Map> query(String fieldName, String fieldVal, String[] returnFields, String collectionName){
        Criteria criteria = Criteria.where(fieldName).is(fieldVal)/*.and("isEnable").is("0")*/.and("delFlag").is("0");
        Query query = Query.query(criteria);
        Field fields = query.fields();
        for (String returnField : returnFields) {
            fields.include(returnField);
        }
        fields.exclude("_id");
        List<Map> result = mongoTemplate.find(query, Map.class, collectionName);
        return result;
    }

    public <T> List<T> query(String fieldName, String fieldVal, String returnField, String collectionName,Class<T> returnClass){
        Criteria criteria = Criteria.where(fieldName).is(fieldVal)/*.and("isEnable").is("0")*/.and("delFlag").is("0");
        Query query = Query.query(criteria);
        query.fields().include(returnField).exclude("_id");
        List<T> result = mongoTemplate.find(query, returnClass, collectionName);
        return result;
    }


    public static String replaceRefId(String val, List<Map> custInds) {
        if(Objects.isNull(custInds) || custInds.isEmpty()) return StringUtils.EMPTY;
        Map<String,String> empty = new HashMap<>();
        empty.put("dictId",StringUtils.EMPTY);
        return (String) custInds.stream().filter(map ->  map.containsValue(val)).findFirst().orElseGet(() -> empty).get("dictId");
    }


    /**
     * 用户真实名称查询登录账号
     * @param realName
     * @return
     */
    public  String findUserNameByRealName(String realName){
        if(StringUtils.isEmpty(realName)){
            return StringUtils.EMPTY;
        }
        Map<String,String> defaultMap = new HashMap<>();
        defaultMap.put("username",realName);
        List<Map> results = this.query("realName", realName, "username", "sys_user",Map.class);
        return Optional.ofNullable(results).orElseGet(() -> (List<Map>) defaultMap).stream().findFirst().orElseGet(() -> defaultMap).get("username")+"";
    }

}
