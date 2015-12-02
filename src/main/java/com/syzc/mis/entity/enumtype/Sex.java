package com.syzc.mis.entity.enumtype;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public enum Sex {
    FEMALE(1, "女性"), MALE(2, "男性");
    protected int code;
    protected String text;

    Sex(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public static Sex get(Integer code) {
        if (code == null) {
            return null;
        }
        return map.get(code);
    }

    private static Map<Integer, Sex> map = new HashMap<>();

    static {
        for (Sex r : Sex.values()) {
            map.put(r.code, r);
        }
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(Sex.values(), true));
        for (Sex w : Sex.values()) {
            System.out.println(w.getText());
            System.out.println(w.getCode());
        }
    }
}