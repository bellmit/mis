package com.syzc.mis.entity.disease;

import com.syzc.mis.entity.Profile;
import com.syzc.mis.entity.report.HspnCheckup;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Henoch-Schonlein purpura nephritis
 * 过敏性紫癜肾炎
 */
@Document
public class Hspn {
    @Id
    private String id;
    private Profile profile;

    private HspnCheckup before;
    private List<HspnCheckup> during;
    private HspnCheckup during0;
    private HspnCheckup after;

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

    public HspnCheckup getBefore() {
        return before;
    }

    public void setBefore(HspnCheckup before) {
        this.before = before;
    }

    public List<HspnCheckup> getDuring() {
        return during;
    }

    public void setDuring(List<HspnCheckup> during) {
        this.during = during;
    }

    public HspnCheckup getAfter() {
        return after;
    }

    public void setAfter(HspnCheckup after) {
        this.after = after;
    }

    public HspnCheckup getDuring0() {
        return during0;
    }

    public void setDuring0(HspnCheckup during0) {
        this.during0 = during0;
    }
}