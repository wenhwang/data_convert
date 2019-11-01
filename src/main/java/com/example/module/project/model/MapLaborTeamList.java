package com.example.module.project.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class MapLaborTeamList {
    private String workerType = StringUtils.EMPTY;
    private String userName = StringUtils.EMPTY;
    private String phone = StringUtils.EMPTY;
    private String idCard = StringUtils.EMPTY;
    private String fileUrl = StringUtils.EMPTY;

}
