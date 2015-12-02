package com.syzc.mis.controller.converters;

import com.syzc.mis.entity.enumtype.Sign;
import org.springframework.core.convert.converter.Converter;

public class SignConverter implements Converter<String, Sign> {
    @Override
    public Sign convert(String source) {
        try {
            return Sign.get(Integer.parseInt(source));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}