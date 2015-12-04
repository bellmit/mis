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
    private Float bloodBunAmount;
    //肾功能，血尿酸量
    private Float bloodUricAcidAmount;
    //胱抑素C量
    private Float cystatinCAmount;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Float getBloodCreatinineAmount() {
        return bloodCreatinineAmount;
    }

    public void setBloodCreatinineAmount(Float bloodCreatinineAmount) {
        this.bloodCreatinineAmount = bloodCreatinineAmount;
    }

    public Float getBloodBunAmount() {
        return bloodBunAmount;
    }

    public void setBloodBunAmount(Float bloodBunAmount) {
        this.bloodBunAmount = bloodBunAmount;
    }

    public Float getBloodUricAcidAmount() {
        return bloodUricAcidAmount;
    }

    public void setBloodUricAcidAmount(Float bloodUricAcidAmount) {
        this.bloodUricAcidAmount = bloodUricAcidAmount;
    }

    public Float getCystatinCAmount() {
        return cystatinCAmount;
    }

    public void setCystatinCAmount(Float cystatinCAmount) {
        this.cystatinCAmount = cystatinCAmount;
    }
}