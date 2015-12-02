package com.syzc.mis.entity.checkup;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 中性粒明胶酶载脂蛋白
 */
@Document
public class Ngal {
    @Id
    private String id;
    private Float urinaryNgal;
    private Float bloodNgal;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Float getUrinaryNgal() {
        return urinaryNgal;
    }

    public void setUrinaryNgal(Float urinaryNgal) {
        this.urinaryNgal = urinaryNgal;
    }

    public Float getBloodNgal() {
        return bloodNgal;
    }

    public void setBloodNgal(Float bloodNgal) {
        this.bloodNgal = bloodNgal;
    }
}