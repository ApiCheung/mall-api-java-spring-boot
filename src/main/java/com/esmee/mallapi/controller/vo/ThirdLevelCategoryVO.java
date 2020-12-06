package com.esmee.mallapi.controller.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Esmee Zhang
 * @date 12/4/20 9:52 下午
 * @projectName mall-api
 */
@Data
public class ThirdLevelCategoryVO implements Serializable {

    private Long categoryId;

    private Byte categoryLevel;

    private String categoryName;
}
