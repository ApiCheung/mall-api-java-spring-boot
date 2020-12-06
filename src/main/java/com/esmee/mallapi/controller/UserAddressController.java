package com.esmee.mallapi.controller;

import com.esmee.mallapi.controller.param.UserAddressSaveParam;
import com.esmee.mallapi.controller.param.UserAddressUpdateParam;
import com.esmee.mallapi.controller.vo.Result;
import com.esmee.mallapi.controller.vo.UserAddressVO;
import com.esmee.mallapi.model.User;
import com.esmee.mallapi.model.UserAddress;
import com.esmee.mallapi.service.UserAddressService;
import com.esmee.mallapi.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Esmee Zhang
 * @date 11/29/20 9:01 下午
 * @projectName mall-api
 */

@RestController
//统一的路径；api
@RequestMapping("/api/v1")
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @GetMapping("/address")
    //wrapper result 包括object本身和object的状态和别的信息
    public Result<List<UserAddressVO>> getAddressList(User logininUser){
        //todo result generator?
        return null;
    }

    @GetMapping("/address/default")
    public Result<UserAddressVO> getDefaultUserAddress(User loginUser){
        UserAddress userAddress = userAddressService.getDefaultAddressByUserId((loginUser.getUserId()));
        //return generator
        return null;
    }

    @GetMapping("/address/{addressId}")
    public Result<UserAddressVO> getUserAddress(@PathVariable("addressId") Long addressId, User loginUser){
        UserAddress userAddress = userAddressService.getUserAddressByAddressId(addressId);
        UserAddressVO newUserAddressVO = new UserAddressVO();
        BeanUtil.CopyProperties(userAddress, newUserAddressVO);
        if(!loginUser.getUserId().equals(userAddress.getUserId())){
            //
        }

        return null;
    }

    //生成新的user address
    @PostMapping("/address")
    public Result<Boolean> saveUserAddress(@RequestBody UserAddressSaveParam userAddressSaveParam, User loginUser){
       UserAddress userAddress = new UserAddress();
       BeanUtil.CopyProperties(userAddressSaveParam, userAddress);
       userAddress.setUserId(loginUser.getUserId());
       Boolean saveResult = userAddressService.saveUserAddress(userAddress);
       if(saveResult){
           //fixme return???
           return null;
       }
       return null;

    }

    @PutMapping("/address")
    public Result<Boolean> updateUserAddress(@RequestBody UserAddressUpdateParam userAddressUpdateParam,
            User loginUser){
        UserAddress userAddress = userAddressService.getUserAddressByAddressId(userAddressUpdateParam.getAddressId());
        if(!loginUser.getUserId().equals(userAddress.getUserId())){
            // return generator
        }
        UserAddress updateUserAddress = new UserAddress();
        BeanUtil.CopyProperties(userAddressUpdateParam, updateUserAddress);
        updateUserAddress.setUserId(loginUser.getUserId());
        Boolean updateResault = userAddressService.updateUserAddress(updateUserAddress);

        if(updateResault){
            // return generator
        }
        return null;
    }

    @DeleteMapping("/address/{addressId}")
    public Result<Boolean> deleteAddress(@PathVariable("addressId") Long addressId, User loginUser){
        UserAddress userAddress = userAddressService.getUserAddressByAddressId(addressId);
        if(loginUser.getUserId().equals(userAddress.getUserId())){
            //todo result generator
        }
        return null;
    }




}
