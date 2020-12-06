package com.esmee.mallapi.controller.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Esmee Zhang
 * @date 12/4/20 9:12 下午
 * @projectName mall-api
 */
@Data
public class UserVO implements Serializable {
    private String nickName;
    private String loginName;
    private String introduceSign;
}
