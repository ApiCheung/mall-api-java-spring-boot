package com.esmee.mallapi.controller.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Esmee Zhang
 * @date 11/29/20 9:10 下午
 * @projectName mall-api
 */
//seializeable io 传输 的时候吧object变成byte code 防止错误 增加速度


    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int resultCode;
    private String message;
    private T data;

    public Result(int resultCode, String message) {

        this.resultCode = resultCode;
        this.message = message;
    }
}
