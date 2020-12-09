package com.esmee.mallapi.service.impl;

import com.esmee.mallapi.common.ApiException;
import com.esmee.mallapi.common.ServiceResultEnum;
import com.esmee.mallapi.controller.vo.UserAddressVO;
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

                //update 和save 一样的
                UserAddress updatedUserAddress = userAddressRepository.save(defaultAddress);
                //update < 1更新没有成功 db 返回0
                if(updatedUserAddress == null){

                    ApiException.fail(ServiceResultEnum.DB_ERROR.getResult());
                }
            }
        }

        return userAddressRepository.save(userAddress).getAddressId() > 0;

    }

    @Override
    public List<UserAddressVO> getUserAddressListByUserId(Long userId) {
        List<UserAddress> addressList = userAddressRepository.findAllByUserId(userId);
        List<UserAddressVO> userAddressVOList = BeanUtil.copyList(addressList, UserAddressVO.class);
        return userAddressVOList;

    }

    @Override
    public UserAddress getUserAddressByAddressId(Long addressId) {
        UserAddress userAddress = userAddressRepository.findByAddressId(addressId);
        if(userAddress == null){

            ApiException.fail(ServiceResultEnum.DATA_NOT_EXIST.getResult());
        }
        return userAddress;
    }

    @Override
    public UserAddress getDefaultAddressByUserId(Long userId) {
        return userAddressRepository.findDefaultByUserId(userId);
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
                    ApiException.fail(ServiceResultEnum.DB_ERROR.getResult());
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
