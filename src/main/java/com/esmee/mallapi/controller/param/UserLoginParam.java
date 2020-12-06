package com.esmee.mallapi.controller.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author Esmee Zhang
 * @date 12/4/20 9:09 下午
 * @projectName mall-api
 */
@Data
public class UserLoginParam implements Serializable {

    @NotBlank(message = "Login name NOT empty")
    //配合validation使用 传值的时候会fail
    private String loginName;

    @NotBlank(message = "passwort NOT empty")
    private String passwordMd5;
}
