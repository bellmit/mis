package com.syzc.mis.entity.filter;

import com.syzc.mis.entity.enumtype.Sex;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BaseFilter {
    private Sex sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date admissionDateMin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date admissionDateMax;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date admissionDate;
    private Short ageOfOnsetMin;
    private Short ageOfOnsetMax;
    private Short ageOfOnset;

    public BaseFilter() {
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getAdmissionDateMin() {
        return admissionDateMin;
    }

    public void setAdmissionDateMin(Date admissionDateMin) {
        this.admissionDateMin = admissionDateMin;
    }

    public Date getAdmissionDateMax() {
        return admissionDateMax;
    }

    public void setAdmissionDateMax(Date admissionDateMax) {
        this.admissionDateMax = admissionDateMax;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Short getAgeOfOnsetMin() {
        return ageOfOnsetMin;
    }

    public void setAgeOfOnsetMin(Short ageOfOnsetMin) {
        this.ageOfOnsetMin = ageOfOnsetMin;
    }

    public Short getAgeOfOnsetMax() {
        return ageOfOnsetMax;
    }

    public void setAgeOfOnsetMax(Short ageOfOnsetMax) {
        this.ageOfOnsetMax = ageOfOnsetMax;
    }

    public Short getAgeOfOnset() {
        return ageOfOnset;
    }

    public void setAgeOfOnset(Short ageOfOnset) {
        this.ageOfOnset = ageOfOnset;
    }
}