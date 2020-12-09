package com.esmee.mallapi.util;

import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author Esmee Zhang
 * @date 12/6/20 9:24 下午
 * @projectName mall-api
 */
public abstract class TokenUtil {
    //口令？
    public static String generateToken(String src) {
        if (StringUtils.hasText(src)) {
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(src.getBytes());
            String result = new BigInteger(1, md.digest()).toString(16);
            if (result.length() == 31) {
                result = result + "-";
            }

            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public static String generateTimeToken(String timeString, Long userId){
        return generateToken(timeString + userId + NumberUtil.genRandomNum(4));
    }

}
