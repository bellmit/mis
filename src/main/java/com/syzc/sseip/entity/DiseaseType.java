package com.syzc.sseip.entity;

import java.io.Serializable;

public class DiseaseType implements Serializable {
    private static final long serialVersionUID = 3407493996319487086L;
    private Long id;
    private String name;

    public DiseaseType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}