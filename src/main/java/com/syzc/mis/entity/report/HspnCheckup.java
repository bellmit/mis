package com.syzc.mis.entity.report;

import com.syzc.mis.entity.checkup.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class HspnCheckup {
    @Id
    private String id;

    private BloodTest bloodTest;
    private ImmuneSeries immuneSeries;
    private LymphocyteSubsets lymphocyteSubsets;
    private Ngal ngal;
    private RenalBModeUS renalBModeUS;
    private RenalFunction renalFunction;
    private RenalScan renalScan;
    private UrineTest urineTest;

    //内生肌酐清除率 CrCl; creatinine clearance
    private Float crCl;

    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BloodTest getBloodTest() {
        return bloodTest;
    }

    public void setBloodTest(BloodTest bloodTest) {
        this.bloodTest = bloodTest;
    }

    public ImmuneSeries getImmuneSeries() {
        return immuneSeries;
    }

    public void setImmuneSeries(ImmuneSeries immuneSeries) {
        this.immuneSeries = immuneSeries;
    }

    public LymphocyteSubsets getLymphocyteSubsets() {
        return lymphocyteSubsets;
    }

    public void setLymphocyteSubsets(LymphocyteSubsets lymphocyteSubsets) {
        this.lymphocyteSubsets = lymphocyteSubsets;
    }

    public Ngal getNgal() {
        return ngal;
    }

    public void setNgal(Ngal ngal) {
        this.ngal = ngal;
    }

    public RenalBModeUS getRenalBModeUS() {
        return renalBModeUS;
    }

    public void setRenalBModeUS(RenalBModeUS renalBModeUS) {
        this.renalBModeUS = renalBModeUS;
    }

    public RenalFunction getRenalFunction() {
        return renalFunction;
    }

    public void setRenalFunction(RenalFunction renalFunction) {
        this.renalFunction = renalFunction;
    }

    public RenalScan getRenalScan() {
        return renalScan;
    }

    public void setRenalScan(RenalScan renalScan) {
        this.renalScan = renalScan;
    }

    public UrineTest getUrineTest() {
        return urineTest;
    }

    public void setUrineTest(UrineTest urineTest) {
        this.urineTest = urineTest;
    }

    public Float getCrCl() {
        return crCl;
    }

    public void setCrCl(Float crCl) {
        this.crCl = crCl;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}