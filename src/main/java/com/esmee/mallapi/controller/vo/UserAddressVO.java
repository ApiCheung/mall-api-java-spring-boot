package com.esmee.mallapi.controller.vo;

import lombok.Data;

/**
 * @author Esmee Zhang
 * @date 11/29/20 9:07 下午
 * @projectName mall-api
 */

@Data
public class UserAddressVO {

    private Long addressId;
    private Long userId;
    private String userName;
    private String userPhone;
    private Byte defaultFlag;
    private String provinceName;
    private String cityName;
    private String regionName;
    private String detailAddress;

}

//street: number street: name
//address line 2: apt/suite/
//city state zip code
