package com.esmee.mallapi.controller;

import com.esmee.mallapi.controller.vo.IndexCategoryVO;
import com.esmee.mallapi.controller.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Esmee Zhang
 * @date 12/4/20 8:49 下午
 * @projectName mall-api
 */
@RestController
@RequestMapping("/api/v1")
public class GoodsCategoryController {

    @GetMapping(path = "/categories")
    public Result<List<IndexCategoryVO>> getCategories(){
        return null;
    }
}
