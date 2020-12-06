package com.esmee.mallapi.controller.vo;

import java.io.Serializable;

/**
 * @author Esmee Zhang
 * @date 12/4/20 9:29 下午
 * @projectName mall-api
 */
public class GoodsDetailVO implements Serializable {

    private Long goodsId;// 2^63  int 2^23

    private String goodsName;

    private String goodsIntro;

    private String goodsCoverImg;

    private Integer sellingPrice;

    private String tag;

    private String[] goodsCarouselList;

    private Integer originalPrice;

    private String goodsDetail;


}
