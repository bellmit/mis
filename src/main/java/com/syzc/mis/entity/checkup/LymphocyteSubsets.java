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

}