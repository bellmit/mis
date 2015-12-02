package com.syzc.mis.entity.checkup;

import com.syzc.mis.entity.enumtype.Sign;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 尿检（常规检测）
 */
@Document
public class UrineTest {
    @Id
    private String id;
    //蛋白尿程度
    private Sign ProteinuriaDs;
    //尿隐血程度
    private Sign urineOccultBloodDs;
    //24小时尿蛋白定量
    private Float protein24Amount;
    //红细胞计数
    private Float erythrocyteAmount;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Sign getProteinuriaDs() {
        return ProteinuriaDs;
    }

    public void setProteinuriaDs(Sign proteinuriaDs) {
        ProteinuriaDs = proteinuriaDs;
    }

    public Sign getUrineOccultBloodDs() {
        return urineOccultBloodDs;
    }

    public void setUrineOccultBloodDs(Sign urineOccultBloodDs) {
        this.urineOccultBloodDs = urineOccultBloodDs;
    }

    public Float getProtein24Amount() {
        return protein24Amount;
    }

    public void setProtein24Amount(Float protein24Amount) {
        this.protein24Amount = protein24Amount;
    }

    public Float getErythrocyteAmount() {
        return erythrocyteAmount;
    }

    public void setErythrocyteAmount(Float erythrocyteAmount) {
        this.erythrocyteAmount = erythrocyteAmount;
    }
}