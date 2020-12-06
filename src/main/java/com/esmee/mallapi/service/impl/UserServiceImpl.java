package com.esmee.mallapi.service.impl;

import com.esmee.mallapi.common.ServiceResultEnum;
import com.esmee.mallapi.controller.param.UserUpdateParam;
import com.esmee.mallapi.model.User;
import com.esmee.mallapi.model.dao.UserRepository;
import com.esmee.mallapi.model.dao.UserTokenRepository;
import com.esmee.mallapi.service.UserService;

/**
 * @author Esmee Zhang
 * @date 12/4/20 5:12 下午
 * @projectName mall-api
 */
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserTokenRepository userTokenRepository;

    @Override
    public String register(String loginName, String passWord) {
        //todo add userepository if user is in do return existing user
        if(userRepository.findByLoginName(loginName) != null){
            return ServiceResultEnum.SAME_LOGIN_NAME_EXIST.getResult();

        }
        //change to lombok builder mode
        User registerUser = new User();
        registerUser.setLoginName(loginName);
        registerUser.setNickName(loginName);
        registerUser.setNickName(loginName);
        //constance
        //registerUser.setIntroduceSign(Constants);

        //todo create md5 util
        String passwordMd5 = passWord;

        registerUser.setPasswordMd5(passwordMd5);

        if(userRepository.save(registerUser) != null){
            return ServiceResultEnum.SUCCESS.getResult();

        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String login(String loginName, String passWordMd5) {
        return null;
    }

    @Override
    public Boolean update(UserUpdateParam userUpdatePatam, Long userId) {
        return null;
    }

    @Override
    public Boolean logout(Long userId) {
        return null;
    }
}
