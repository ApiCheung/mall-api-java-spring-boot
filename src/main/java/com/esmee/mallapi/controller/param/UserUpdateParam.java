package com.esmee.mallapi.controller.param;

import lombok.Data;

/**
 * @author Esmee Zhang
 * @date 12/4/20 9:09 下午
 * @projectName mall-api
 */
@Data
public class UserUpdateParam {

    private String nickName;
    private String passwordMd5;
    private String introduceSign;

}
