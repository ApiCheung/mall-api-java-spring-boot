package com.esmee.mallapi.controller.vo;

import lombok.Data;

import java.util.List;

/**
 * @author Esmee Zhang
 * @date 12/4/20 9:50 下午
 * @projectName mall-api
 */
@Data
public class SecondLevelCategoryVO {

    private Long categoryId;

    private Long parentId;

    private Byte categoryLevel;

    private String categoryName;

    private List<ThirdLevelCategoryVO> thirdLevelCategoryVOList;
}
