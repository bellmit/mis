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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getIgeAmount() {
        return igeAmount;
    }

    public void setIgeAmount(Float igeAmount) {
        this.igeAmount = igeAmount;
    }

    public Float getIggAmount() {
        return iggAmount;
    }

    public void setIggAmount(Float iggAmount) {
        this.iggAmount = iggAmount;
    }

    public Float getIgaAmount() {
        return igaAmount;
    }

    public void setIgaAmount(Float igaAmount) {
        this.igaAmount = igaAmount;
    }

    public Float getC3Amount() {
        return c3Amount;
    }

    public void setC3Amount(Float c3Amount) {
        this.c3Amount = c3Amount;
    }

    public Float getIgaC3Ratio() {
        return igaC3Ratio;
    }

    public void setIgaC3Ratio(Float igaC3Ratio) {
        this.igaC3Ratio = igaC3Ratio;
    }
}