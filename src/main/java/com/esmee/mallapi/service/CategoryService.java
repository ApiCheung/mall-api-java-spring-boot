package com.esmee.mallapi.service;

import com.esmee.mallapi.controller.vo.IndexCategoryVO;
import com.esmee.mallapi.model.GoodsCategory;

import java.util.List;

/**
 * @author Esmee Zhang
 * @date 12/4/20 9:57 下午
 * @projectName mall-api
 */
public interface CategoryService {

    String save(GoodsCategory goodsCategory);

    GoodsCategory getGoodsCategoryById(Long id);

    String update(GoodsCategory goodsCategory);



    Boolean deleteBatch(Long[] ids);

    List<IndexCategoryVO> getIndexCategory();
}
