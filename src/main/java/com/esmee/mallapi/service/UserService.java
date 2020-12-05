package com.esmee.mallapi.service;

/**
 * @author Esmee Zhang
 * @date 12/1/20 10:19 下午
 * @projectName mall-api
 */
public interface UserService {

    String register(String loginName, String passWord);
    String login(String loginName, String passWordMD5);


}
