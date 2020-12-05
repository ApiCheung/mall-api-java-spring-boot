package com.esmee.mallapi.controller.param;

import lombok.Data;

/**
 * @author Esmee Zhang
 * @date 11/29/20 9:33 下午
 * @projectName mall-api
 */
@Data
public class UserAddressSaveParam {

    private String UserName;
    private String userPhone;
    private Byte defaultFlag;//默认地址
    private String provinceName;
    private String cityName;
    private String regionName;
    private String detailAddress;
}
