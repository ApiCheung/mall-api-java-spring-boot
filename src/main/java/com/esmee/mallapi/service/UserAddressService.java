package com.esmee.mallapi.service;

import com.esmee.mallapi.controller.vo.UserAddressVO;
import com.esmee.mallapi.model.UserAddress;

import java.util.List;

/**
 * @author Esmee Zhang
 * @date 11/29/20 9:49 下午
 * @projectName mall-api
 */

public interface UserAddressService {
    //create
    Boolean saveUserAddress(UserAddress userAddress);

    //read
    List<UserAddressVO> getUserAddressListByUserId(Long userId);
    UserAddress getUserAddressByAddressId(Long addressId);
    UserAddress getDefaultAddressByUserId(Long userId);

    //update
    Boolean updateUserAddress(UserAddress userAddress);

    //delete
    Boolean deleteByAddressId(Long addressId);

}
