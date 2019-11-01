package com.example.module.project.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class MapBuildCompany {
    private String companyName = StringUtils.EMPTY;
    private String address = StringUtils.EMPTY;
    private String userName1 = StringUtils.EMPTY;
    private String phone1 = StringUtils.EMPTY;
    private String userName2 = StringUtils.EMPTY;
    private String phone2 = StringUtils.EMPTY;
}
