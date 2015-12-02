package com.syzc.mis.entity.checkup;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 肾脏CT，核磁共振，微量放射性
 */
@Document
public class RenalScan {
    @Id
    private String id;
    private Float lPerfusion;
    private Float rPerfusion;
    //both肾脏结构描述
    private String lKidney;
    private String rKidney;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Float getlPerfusion() {
        return lPerfusion;
    }

    public void setlPerfusion(Float lPerfusion) {
        this.lPerfusion = lPerfusion;
    }

    public Float getrPerfusion() {
        return rPerfusion;
    }

    public void setrPerfusion(Float rPerfusion) {
        this.rPerfusion = rPerfusion;
    }

    public String getlKidney() {
        return lKidney;
    }

    public void setlKidney(String lKidney) {
        this.lKidney = lKidney;
    }

    public String getrKidney() {
        return rKidney;
    }

    public void setrKidney(String rKidney) {
        this.rKidney = rKidney;
    }
}