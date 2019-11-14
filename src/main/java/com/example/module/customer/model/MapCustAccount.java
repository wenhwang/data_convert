package com.example.module.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
@AllArgsConstructor
public class MapCustAccount {
    //账户名称
    private String accountName = StringUtils.EMPTY;
    //开户行
    private String bankName = StringUtils.EMPTY;
    //银行账号
    private String bankAccount = StringUtils.EMPTY;
}
