package com.esmee.mallapi.model.dao;

import com.esmee.mallapi.model.User;
import com.esmee.mallapi.model.UserAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Esmee Zhang
 * @date 11/29/20 10:11 下午
 * @projectName mall-api
 */
public interface UserAddressRepository extends CrudRepository<UserAddress, Long> {

    UserAddress findByUserId(Long userId);
    UserAddress findByAddressId(Long addressId);
    List<UserAddress> findUserAddressListByUserId(Long userId);
    int updateByUserId(Long userId);
    int deleteByAddressId(Long addressId);


    //可以不用写因为返回的是子类
    UserAddress save(UserAddress userAddress);

}
