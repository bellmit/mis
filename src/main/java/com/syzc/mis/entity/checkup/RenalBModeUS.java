package com.syzc.mis.entity.checkup;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 肾脏B超
 */
@Document
public class RenalBModeUS {
    @Id
    private String id;
    //肾大小
    private String lKidneySize;
    private String rKidneySize;
    //肾实质厚度
    private Float lRenalParenchymaThickness;
    private Float rRenalParenchymaThickness;
    //血流情况
    private String bloodFlow;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getlKidneySize() {
        return lKidneySize;
    }

    public void setlKidneySize(String lKidneySize) {
        this.lKidneySize = lKidneySize;
    }

    public String getrKidneySize() {
        return rKidneySize;
    }

    public void setrKidneySize(String rKidneySize) {
        this.rKidneySize = rKidneySize;
    }

    public Float getlRenalParenchymaThickness() {
        return lRenalParenchymaThickness;
    }

    public void setlRenalParenchymaThickness(Float lRenalParenchymaThickness) {
        this.lRenalParenchymaThickness = lRenalParenchymaThickness;
    }

    public Float getrRenalParenchymaThickness() {
        return rRenalParenchymaThickness;
    }

    public void setrRenalParenchymaThickness(Float rRenalParenchymaThickness) {
        this.rRenalParenchymaThickness = rRenalParenchymaThickness;
    }

    public String getBloodFlow() {
        return bloodFlow;
    }

    public void setBloodFlow(String bloodFlow) {
        this.bloodFlow = bloodFlow;
    }
}