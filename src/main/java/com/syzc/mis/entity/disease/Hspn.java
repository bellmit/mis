package com.syzc.mis.entity.disease;

import com.syzc.mis.entity.Profile;
import com.syzc.mis.entity.checkup.*;
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
    private Profile profile;

    private BloodTest bloodTest;
    private ImmuneSeries immuneSeries;
    private LymphocyteSubsets lymphocyteSubsets;
    private Ngal ngal;
    private RenalBModeUS renalBModeUS;
    private RenalFunction renalFunction;
    private RenalScan renalScan;
    private UrineTest urineTest;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
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
}