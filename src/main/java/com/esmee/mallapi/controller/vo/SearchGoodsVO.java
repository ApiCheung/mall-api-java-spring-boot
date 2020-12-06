package com.esmee.mallapi.controller.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Esmee Zhang
 * @date 12/4/20 9:28 下午
 * @projectName mall-api
 */

@Data
public class SearchGoodsVO implements Serializable {

    private Long goodsId;
    private String goodsName;
    private String goddsIntro;
    private String goodsCoverImg;
    private Integer sellingPrice;
}
