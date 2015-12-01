package com.syzc.mis.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document
public class CuDe {
    private BigInteger id;
    private String name;
    private Double val;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getVal() {
        return val;
    }

    public void setVal(Double val) {
        this.val = val;
    }
}