package com.esmee.mallapi.model.dao;

import com.esmee.mallapi.model.User;
import com.esmee.mallapi.model.UserToken;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Esmee Zhang
 * @date 12/4/20 10:25 下午
 * @projectName mall-api
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUserId(Long UserId);
    User findByLoginName(String loginName);
    User findByLoginNameAndPasswordMd5(String loginName, String passwordMd5);

}
