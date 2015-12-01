package com.syzc.mis.entity.checkup;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 中性粒明胶酶载脂蛋白
 */
@Document
public class Nagl {
    @Id
    private String id;
}