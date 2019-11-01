package com.example.module.resource.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

@Data
public class ArchiveFile {
    private String fileId = StringUtils.EMPTY;
    private String fileName = StringUtils.EMPTY;
    private String fileUrl = StringUtils.EMPTY;
    private String createBy = StringUtils.EMPTY;
    private Date createTime;
    private Date updateTime;
    private String updateBy = StringUtils.EMPTY;
    private String delFlag = "0";
    private String dataSource = "EPMS";
}
