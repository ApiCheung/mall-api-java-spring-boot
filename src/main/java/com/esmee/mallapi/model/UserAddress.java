package com.esmee.mallapi.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Esmee Zhang
 * @date 11/29/20 9:55 下午
 * @projectName mall-api
 */
@Data
@Entity
public class UserAddress {

    @Id
    @GeneratedValue
    private Long addressId;
    private Long userId;
    private String userName;
    private String userPhone;
    private Byte defaultFlag;
    private String provinceName;
    private String cityName;
    private String regionName;
    private String detailAddress;
    private Byte isDeleted;
    private Date createTime;
    private Date updateTime;
}
