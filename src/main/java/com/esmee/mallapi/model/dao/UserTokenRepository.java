package com.esmee.mallapi.model.dao;


import com.esmee.mallapi.model.UserToken;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Esmee Zhang
 * @date 12/6/20 6:52 下午
 * @projectName mall-api
 */
public interface UserTokenRepository extends CrudRepository<UserToken, Long> {
    UserToken findByUserId(Long userId);
    void deleteById(Long userId);
}
