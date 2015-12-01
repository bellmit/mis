package com.syzc.mis.entity.checkup;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 肾脏功能
 */
@Document
public class RenalFunction {
    @Id
    private String id;
    //血肌酐
    private Float bloodCreatinineAmount;
    //Blood Urea Nitrogen, 血液尿素氮含量
    private Float bunAmount;
    //尿酸量
    private Float uricAcidAmount;
    //胱抑素C量
    private Float cystatinCAmount;
    //内生肌酐清除率 CrCl; creatinine clearance
    private Float crCl;
}