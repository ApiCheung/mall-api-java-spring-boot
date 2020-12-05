package com.esmee.mallapi.common;

/**
 * @author Esmee Zhang
 * @date 11/29/20 10:20 下午
 * @projectName mall-api
 */
public class ApiException extends RuntimeException {

    public ApiException() {
    }

    public ApiException(String message) {
        super(message);
    }

    //throw exception
    public static void fail(String message){

        throw new ApiException(message);
    }
}
