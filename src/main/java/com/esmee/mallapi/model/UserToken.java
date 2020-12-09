package com.esmee.mallapi.model;

import lombok.Data;

import java.util.Date;

/**
 * @author Esmee Zhang
 * @date 12/6/20 9:34 下午
 * @projectName mall-api
 */
@Data
public class UserToken {
    private Long userId;

    private String token;

    private Date updateTime;

    private Date expireTime;
}
