package com.syzc.mis.dao;

import com.alibaba.fastjson.JSON;
import com.syzc.mis.dao.repo.HspnRepo;
import com.syzc.mis.entity.Profile;
import com.syzc.mis.entity.checkup.BloodTest;
import com.syzc.mis.entity.disease.Hspn;
import com.syzc.mis.entity.enumtype.Sex;
import com.syzc.util.LocalAcUtil;

import java.util.Date;

public class HspnRepoTestC {
    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(LocalAcUtil.getAc().getBeanDefinitionNames(), true));
        HspnRepo repo = (HspnRepo) LocalAcUtil.getAc().getBean("hspnRepo");
        System.out.println(JSON.toJSONString(repo.findAll(), true));
        Hspn hspn = new Hspn();
        Hspn result;

        BloodTest bloodTest = new BloodTest();
        hspn.setBloodTest(bloodTest);
        bloodTest.setErythrocyteAmount(2.3f);
        bloodTest.setHemoglobinAmount(3.2f);
        bloodTest.setLeukocyteAmount(4.3f);
        bloodTest.setPlateletAmount(5.5f);

        Profile profile = new Profile();
        hspn.setProfile(profile);
        profile.setName("noob");
        profile.setAdmissionDate(new Date());
        profile.setAge((short) 33);
        profile.setAgeOfOnset((short) 27);
        profile.setBloodPressure("130/90");
        profile.setSex(Sex.FEMALE);

        result = repo.save(hspn);
        System.out.println(JSON.toJSONString(result, true));
    }
}