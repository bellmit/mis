package com.syzc.mis.entity.checkup;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 免疫系列
 */
@Document
public class ImmuneSeries {
    @Id
    private String id;
    //IgE
    private Float igeAmount;
    //IgG
    private Float iggAmount;
    //IgA
    private Float igaAmount;
    //C3
    private Float c3Amount;
    //IgA/C3 比率
    private Float igaC3Ratio;

}