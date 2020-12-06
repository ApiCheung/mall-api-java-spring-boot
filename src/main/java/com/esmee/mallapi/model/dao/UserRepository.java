package com.esmee.mallapi.model.dao;

import com.esmee.mallapi.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Esmee Zhang
 * @date 12/4/20 10:25 下午
 * @projectName mall-api
 */
public interface UserRepository extends CrudRepository {

    User findByLoginName(String loginName);

}
