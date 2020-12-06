package com.esmee.mallapi.controller.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Esmee Zhang
 * @date 12/4/20 9:47 下午
 * @projectName mall-api
 */
@Data
public class IndexCategoryVO implements Serializable {

    private Long categoryId;

    private Byte categoryLevel;

    private String categoryName;

    private List<SecondLevelCategoryVO> secondLevelCategoryVOList;

}
