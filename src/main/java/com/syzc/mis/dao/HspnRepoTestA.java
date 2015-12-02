package com.syzc.mis.dao;

import com.alibaba.fastjson.JSON;
import com.syzc.mis.dao.repo.HspnRepo;
import com.syzc.mis.entity.Profile;
import com.syzc.mis.entity.checkup.BloodTest;
import com.syzc.mis.entity.disease.Hspn;
import com.syzc.mis.entity.report.HspnCheckup;
import com.syzc.util.LocalAcUtil;

public class HspnRepoTestA {
    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(LocalAcUtil.getAc().getBeanDefinitionNames(), true));
        HspnRepo repo = (HspnRepo) LocalAcUtil.getAc().getBean("hspnRepo");
        System.out.println(JSON.toJSONString(repo.findAll(), true));
        Hspn hspn = new Hspn();
        Hspn result;

        HspnCheckup checkup = new HspnCheckup();
        hspn.setBefore(checkup);

        BloodTest bloodTest = new BloodTest();
        checkup.setBloodTest(bloodTest);

        Profile profile = new Profile();
        hspn.setProfile(profile);

        result = repo.save(hspn);
        System.out.println(JSON.toJSONString(result, true));
    }
}