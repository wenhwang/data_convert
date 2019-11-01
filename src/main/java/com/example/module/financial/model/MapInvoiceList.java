package com.example.module.financial.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * 收票明细
 *
 * @pdOid 50d70760-071c-4458-b71c-6fe91a8b9e97
 */
@Data
public class MapInvoiceList {
    /**
     * 发票号
     *
     * @pdOid befd32f0-9177-4158-b162-a6decf78a79c
     */
    private String invoiceNumber = StringUtils.EMPTY;
    /**
     * 发票类型ID
     *
     * @pdOid 130655fd-2b8c-4a29-82b8-24952ecdf691
     */
    private String typeId = StringUtils.EMPTY;
    /**
     * 发票类型名称
     *
     * @pdOid 4aadad09-1447-462a-abcd-fe20cb249411
     */
    private String typeName = StringUtils.EMPTY;
    /**
     * 发票日期
     *
     * @pdOid 81a17440-59e0-4f00-be3b-783be6fab848
     */
    private Date invoiceDate;
    /**
     * 除税金额
     *
     * @pdOid fafba3d4-268f-4cdb-b2f9-a342c94b933d
     */
    private double deductTaxAmount;
    /**
     * 税额
     *
     * @pdOid 844dab9c-92c9-46b0-8b0c-01cf3435c911
     */
    private String taxAmount = StringUtils.EMPTY;
    /**
     * 价税合计
     *
     * @pdOid 9f4ee3a6-6058-429f-bf91-8c48acec16e7
     */
    private String totalAmount = StringUtils.EMPTY;

}