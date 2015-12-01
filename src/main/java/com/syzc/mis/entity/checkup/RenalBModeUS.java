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
}