package com.example.module.system.model;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @program: data_convert
 * @description:
 * @author: Administrator
 * @create: 2019-10-18 14:53
 **/
@Data
public class MapcodeParam{
    @ApiModelProperty(value = "数据项标签",required = true,dataType = "String")
    String label;

    @ApiModelProperty(value = "所属分类ID",required = true,dataType = "String")
    String categoryId;

    @ApiModelProperty(value = "数据项",required = true,dataType = "String[]")
    String[] dictNames;

}
