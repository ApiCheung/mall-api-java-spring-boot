package com.esmee.mallapi.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Esmee Zhang
 * @date 12/6/20 9:24 下午
 * @projectName mall-api
 */
public abstract class NumberUtil {
    public static boolean isPhone(String phone) {
        Pattern pattern = Pattern.compile("^((13[0-9])|(14[5,7])|(15[^4,\\D])|(17[0-8])|(18[0-9]))\\d{8}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }


    public static int genRandomNum(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) ((random * num));
    }


    public static String genOrderNo() {
        StringBuffer buffer = new StringBuffer(String.valueOf(System.currentTimeMillis()));
        int num = genRandomNum(4);
        buffer.append(num);
        return buffer.toString();
    }
}
