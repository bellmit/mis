package com.syzc.mis.entity.checkup;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 血常规
 */
@Document
public class BloodTest {
    @Id
    private String id;
    //红细胞计数
    private Float erythrocyteAmount;
    //血红蛋白，血红素
    private Float hemoglobinAmount;
    //白细胞
    private Float leukocyteAmount;
    //血小板
    private Float plateletAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getErythrocyteAmount() {
        return erythrocyteAmount;
    }

    public void setErythrocyteAmount(Float erythrocyteAmount) {
        this.erythrocyteAmount = erythrocyteAmount;
    }

    public Float getHemoglobinAmount() {
        return hemoglobinAmount;
    }

    public void setHemoglobinAmount(Float hemoglobinAmount) {
        this.hemoglobinAmount = hemoglobinAmount;
    }

    public Float getLeukocyteAmount() {
        return leukocyteAmount;
    }

    public void setLeukocyteAmount(Float leukocyteAmount) {
        this.leukocyteAmount = leukocyteAmount;
    }

    public Float getPlateletAmount() {
        return plateletAmount;
    }

    public void setPlateletAmount(Float plateletAmount) {
        this.plateletAmount = plateletAmount;
    }
}