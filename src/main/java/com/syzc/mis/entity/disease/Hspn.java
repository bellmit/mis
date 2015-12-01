package com.syzc.mis.entity.disease;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Henoch-Schonlein purpura nephritis
 * 过敏性紫癜肾炎
 */
@Document
public class Hspn {
    @Id
    private String id;

}