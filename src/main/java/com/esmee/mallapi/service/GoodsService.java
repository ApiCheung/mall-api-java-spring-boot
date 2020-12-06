package com.esmee.mallapi.service;

import com.esmee.mallapi.controller.vo.PageResult;
import com.esmee.mallapi.model.Goods;
import com.esmee.mallapi.controller.param.PageQuery;

/**
 * @author Esmee Zhang
 * @date 12/4/20 9:57 下午
 * @projectName mall-api
 */
public interface GoodsService {
    Goods getGoodsId(Long id);

    PageResult searchGoods(PageQuery pageQuery);
}
