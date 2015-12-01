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
}