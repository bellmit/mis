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
}