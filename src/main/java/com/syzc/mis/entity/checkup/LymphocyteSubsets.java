package com.syzc.mis.entity.checkup;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 淋巴细胞亚群
 */
@Document
public class LymphocyteSubsets {
    @Id
    private String id;
    //Tregs, regulatory T cells, T抑制细胞
    private Float tregsAmount;
    //T辅助细胞 Th cells, T helper cells
    private Float thCellsAmount;
    private Float bCellAmount;
    private Float hrRatio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getTregsAmount() {
        return tregsAmount;
    }

    public void setTregsAmount(Float tregsAmount) {
        this.tregsAmount = tregsAmount;
    }

    public Float getThCellsAmount() {
        return thCellsAmount;
    }

    public void setThCellsAmount(Float thCellsAmount) {
        this.thCellsAmount = thCellsAmount;
    }

    public Float getbCellAmount() {
        return bCellAmount;
    }

    public void setbCellAmount(Float bCellAmount) {
        this.bCellAmount = bCellAmount;
    }

    public Float getHrRatio() {
        return hrRatio;
    }

    public void setHrRatio(Float hrRatio) {
        this.hrRatio = hrRatio;
    }
}