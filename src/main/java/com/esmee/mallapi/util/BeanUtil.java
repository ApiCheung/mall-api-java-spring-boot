package com.esmee.mallapi.util;

import java.util.*;
import org.springframework.beans.BeanUtils;

/**
 * @author Esmee Zhang
 * @date 12/1/20 9:18 下午
 * @projectName mall-api
 */
public abstract class BeanUtil {

    public static <T> List<T> copyList(List sources, Class<T> clazz){
        return copyList(sources, clazz);
    }

    public static Object CopyProperties(Object source, Object target, String... ignoreProperties){
        if(source == null) return target;
        BeanUtil.CopyProperties(source, target, ignoreProperties);
        return target;
    }
}
