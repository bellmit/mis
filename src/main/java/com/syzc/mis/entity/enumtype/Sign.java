package com.syzc.mis.entity.enumtype;

import java.util.HashMap;
import java.util.Map;

public enum Sign {
    NONE(0, "-"), HALF(1, "±"), ONE(2, "+"), TWO(3, "++"), THREE(4, "+++"), FOUR(5, "++++");
    protected int code;
    protected String text;
    private static Map<Integer, Sign> map = new HashMap<>();

    Sign(int code, String textName) {
        this.code = code;
        this.text = textName;
    }

    public int getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public static Sign get(Integer code) {
        if (code == null) {
            return null;
        }
        return map.get(code);
    }

    static {
        for (Sign sign : Sign.values()) {
            map.put(sign.code, sign);
        }
    }
}