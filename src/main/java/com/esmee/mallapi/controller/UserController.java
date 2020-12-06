package com.esmee.mallapi.controller;

import com.esmee.mallapi.controller.param.UserLoginParam;
import com.esmee.mallapi.controller.param.UserRegisterParam;
import com.esmee.mallapi.controller.param.UserUpdateParam;
import com.esmee.mallapi.controller.vo.Result;
import com.esmee.mallapi.controller.vo.UserVO;
import com.esmee.mallapi.model.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Esmee Zhang
 * @date 12/4/20 8:46 下午
 * @projectName mall-api
 */
@RestController
@RequestMapping("api/v1")
public class UserController {
    @PostMapping(path = "/user/login")
    public Result<String> login(@RequestBody @Valid UserLoginParam userLoginParam){
        return null;
    }

    @PostMapping(path = "/user/logout")
    public Result<String> logout(User loginUser){
        return null;
    }

    @PostMapping(path = "/user/register")
    public Result<String> register(@RequestBody @Valid UserRegisterParam userRegisterParam){
        return null;
    }

    @GetMapping(path = "/user/info")
    public Result<UserVO> getUser(User loginUser){
        return null;
    }

    @PutMapping(path = "/user/info")
    public Result<String> updateInfo(@RequestBody UserUpdateParam userUpdateParam, User loginUser){
        return null;
    }
}
