package com.esmee.mallapi.controller.param;

import lombok.Data;

/**
 * @author Esmee Zhang
 * @date 11/29/20 9:37 下午
 * @projectName mall-api
 */
@Data
public class UserAddressUpdateParam {

    private Long addressId;
    private Long userId;
    private String userName;
    private String userPhone;
    private Byte defaultFlag;//定义byte的原因 8 bit 能有很多状态
    private String provinceName;
    private String cityName;
    private String regionName;
    private String detailAddress;

}
