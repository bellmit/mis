package com.syzc.mis.entity;

import com.syzc.mis.entity.enumtype.Sex;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 患者的一般资料
 */
@Document
public class Profile {
    @Id
    private String id;

    private String name;
    private Sex sex;
    private Short age;
    //发病年龄
    private Short ageOfOnset;
    //入院日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date admissionDate;
    //出院日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dischargeDate;
    //病区
    private String ward;
    private String patientId;
    private String bloodPressure;
    //过敏原
    private String allergens;
    private String renalPathology;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Short getAgeOfOnset() {
        return ageOfOnset;
    }

    public void setAgeOfOnset(Short ageOfOnset) {
        this.ageOfOnset = ageOfOnset;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public String getRenalPathology() {
        return renalPathology;
    }

    public void setRenalPathology(String renalPathology) {
        this.renalPathology = renalPathology;
    }
}