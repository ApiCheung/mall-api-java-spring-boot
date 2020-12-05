package com.esmee.mallapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author Esmee Zhang
 * @date 11/29/20 9:07 下午
 * @projectName mall-api
 */
@Data
public class User {

    private Long userId;
    private String nickName;
    private String loginName;
    private String passwordMd5;
    private String introduceSign;   //
    private Byte isDeleted;
    private Byte lockedFlag;
    //createTime   //到数据库的创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
