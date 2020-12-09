package com.esmee.mallapi.service.impl;

import com.esmee.mallapi.common.ApiException;
import com.esmee.mallapi.common.Constants;
import com.esmee.mallapi.common.ServiceResultEnum;
import com.esmee.mallapi.controller.param.UserUpdateParam;
import com.esmee.mallapi.model.User;
import com.esmee.mallapi.model.UserToken;
import com.esmee.mallapi.model.dao.UserRepository;
import com.esmee.mallapi.model.dao.UserTokenRepository;
import com.esmee.mallapi.service.UserService;
import com.esmee.mallapi.util.Md5Util;
import com.esmee.mallapi.util.TokenUtil;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author Esmee Zhang
 * @date 12/4/20 5:12 下午
 * @projectName mall-api
 */
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserTokenRepository userTokenRepository;

    @Override
    public String register(String loginName, String passWord) {
        //todo add use repository if user is in do return existing user
        if(userRepository.findByLoginName(loginName) != null){
            return ServiceResultEnum.SAME_LOGIN_NAME_EXIST.getResult();

        }
        //change to lombok builder mode
        User registerUser = new User();
        registerUser.setLoginName(loginName);
        registerUser.setNickName(loginName);
        registerUser.setNickName(loginName);

        registerUser.setIntroduceSign(Constants.USER_INTRO);
        String passwordMd5 = Md5Util.MD5Encode(passWord, "UTF-8");

        registerUser.setPasswordMd5(passwordMd5);

        if(userRepository.save(registerUser) != null){
            return ServiceResultEnum.SUCCESS.getResult();

        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String login(String loginName, String passWordMd5) {
        User user = userRepository.findByLoginNameAndPasswordMd5(loginName, passWordMd5);
        if(user != null){
            //强行试密码的lock
            if(user.getLockedFlag() == 1) {
                return ServiceResultEnum.LOGIN_USER_LOCKED_ERROR.getResult();
            }
            //todo create token util
            String token = TokenUtil.generateTimeToken(System.currentTimeMillis() + "", user.getUserId());

            UserToken dbuserToken = userTokenRepository.findByUserId(user.getUserId());

            Date now = new Date();
            Date expireTime = new Date(now.getTime() + 2 * 24 * 3600 * 1000);
            if(dbuserToken == null){

                    dbuserToken = new UserToken();
                    dbuserToken.setUserId(user.getUserId());
                    dbuserToken.setToken(token);
                    dbuserToken.setUpdateTime(now);
                    dbuserToken.setExpireTime(expireTime);
                    //新增一条token数据
                    if (userTokenRepository.save(dbuserToken) != null) {
                        //新增成功后返回
                        return token;

            }else{
                        dbuserToken.setToken(token);
                        dbuserToken.setUpdateTime(now);
                        dbuserToken.setExpireTime(expireTime);
                    }

            }
        }
        return ServiceResultEnum.LOGIN_ERROR.getResult();

    }

    @Override
    public Boolean update(UserUpdateParam userUpdateParam, Long userId) {
        User user = userRepository.findByUserId(userId);
        if(user == null){
            ApiException.fail(ServiceResultEnum.DATA_NOT_EXIST.getResult());
        }

        user.setNickName(userUpdateParam.getNickName());
        if(!Md5Util.MD5Encode("", "UTF-8").equals(userUpdateParam.getPasswordMd5())){
            user.setPasswordMd5(userUpdateParam.getPasswordMd5());
        }
        user.setIntroduceSign(userUpdateParam.getIntroduceSign());

        if(userRepository.save(user) != null){
            return true;
        }
        return false;
    }

    @Override
    public Boolean logout(Long userId) {
        try{
            userTokenRepository.deleteById(userId);
            return true;
        }catch(Exception e){
            log.error(e.getMessage());
            return false;
        }
    }
}
