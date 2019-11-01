package com.example.module.system.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
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
public class MapCodeCategory{
    private String createBy = "admin";
    private String updateBy = StringUtils.EMPTY;
    private LocalDate createTime = LocalDate.now();
    private LocalDate updateTime;
    @NonNull
    private String label;
    private String delFlag =  "0";
    private String isEnable = "0";
    @NonNull
    private String categoryName;
    @NonNull
    private String parentId;
    private String categoryId = UUID.randomUUID().toString().replace("-","");
}
