package com.esmee.mallapi.service.impl;

import com.esmee.mallapi.common.ApiException;
import com.esmee.mallapi.controller.vo.UserAddressVO;
import com.esmee.mallapi.model.User;
import com.esmee.mallapi.model.UserAddress;
import com.esmee.mallapi.model.dao.UserAddressRepository;
import com.esmee.mallapi.service.UserAddressService;
import com.esmee.mallapi.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Esmee Zhang
 * @date 11/29/20 9:58 下午
 * @projectName mall-api
 */

@Service
public class UserAddressServiceImpl implements UserAddressService {

    //定义repository
    @Autowired
    private UserAddressRepository userAddressRepository;

    @Override
    public Boolean saveUserAddress(UserAddress userAddress) {
        Date now = new Date();
        if(userAddress.getDefaultFlag().intValue() == 1){

            UserAddress defaultAddress = userAddressRepository.findByUserId(userAddress.getUserId());
            if(defaultAddress != null){
                defaultAddress.setDefaultFlag((byte) 0);
                defaultAddress.setUpdateTime(now);
                int updateDefault = 0;


                //update 和save 一样的
                UserAddress updatedUserAddress = userAddressRepository.save(defaultAddress);
                //update < 1更新没有成功 db 返回0
                if(updatedUserAddress == null){
                    // todo create exception
                    // fixme the error message should be updated
                    ApiException.fail("DB error");
                }
            }
        }
        //todo crete repo logic
        return userAddressRepository.save(userAddress).getAddressId() > 0;

    }

    @Override
    public List<UserAddressVO> getUserAddressListByUserId(Long userId) {
        List<UserAddress> userAddressList = userAddressRepository.findUserAddressListByUserId(userId);
        //fixme beanutil
        List<UserAddressVO> userAddressVOList = BeanUtil.copyList(userAddressList, UserAddressVO.class);
        return userAddressVOList;

    }

    @Override
    public UserAddress getUserAddressByAddressId(Long addressId) {
        UserAddress userAddress = userAddressRepository.findByAddressId(addressId);
        if(userAddress == null){
            //fixme the errror message should be update
            ApiException.fail("DB error");
        }
        return userAddress;
    }

    @Override
    public UserAddress getDefaultAddressByUserId(Long userId) {
        return userAddressRepository.findByUserId(userId);
    }

    @Override
    public Boolean updateUserAddress(UserAddress userAddress) {
        Date now = new Date();
        UserAddress tempUserAddress =getUserAddressByAddressId(userAddress.getAddressId());
        if(userAddress.getDefaultFlag().intValue() == 1){
            UserAddress defaultAddress = userAddressRepository.findByUserId(userAddress.getUserId());
            if(defaultAddress != null && defaultAddress.getAddressId().equals(tempUserAddress)){
                defaultAddress.setDefaultFlag((byte) 0);
                defaultAddress.setUpdateTime(now);
                int updateStatus = userAddressRepository.updateByUserId(userAddress.getUserId());
                if(updateStatus < 1){
                    ApiException.fail("DB error");
                }
            }
        }
        return null;
    }

    @Override
    public Boolean deleteByAddressId(Long addressId) {

        return userAddressRepository.deleteByAddressId(addressId) > 0;
    }
}
