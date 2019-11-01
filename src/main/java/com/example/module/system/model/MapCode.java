package com.example.module.system.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

/**
 * @program: data_convert
 * @description:
 * @author: Administrator
 * @create: 2019-10-18 14:53
 **/
@Data
@Document
@RequiredArgsConstructor(staticName = "getInstace")
public class MapCode{

    @NonNull
    private String dictName;

    @NonNull
    private String label;

    @NonNull
    private String categoryId;

    private String remarks = "";

    private String isEnable = "0";

    private String createBy = "admin";

    private String updateBy;

    private String dictId = UUID.randomUUID().toString().replace("-","");

    private String delFlag = "0";

    private String createTime = System.currentTimeMillis()+"";

    private String updateTime;

}
