package com.esmee.mallapi.controller;

import com.esmee.mallapi.controller.vo.GoodsDetailVO;
import com.esmee.mallapi.controller.vo.PageResult;
import com.esmee.mallapi.controller.vo.Result;
import com.esmee.mallapi.controller.vo.SearchGoodsVO;
import com.esmee.mallapi.model.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
//传递的东西的validation

/**
 * @author Esmee Zhang
 * @date 12/4/20 8:47 下午
 * @projectName mall-api
 */
@RestController
@RequestMapping("api/v1")
public class GoodsController {
    @GetMapping(path = "/search")
    public Result<PageResult<List<SearchGoodsVO>>> search(@RequestParam(required = false) String keyword,
                                                          @RequestParam(required = false) Long goodsCategoryId,
                                                          @RequestParam(required = false) String orderBy,
                                                          @RequestParam(required = false) String pageNumber,
                                                          User loginUser){
        return null;
    }

    @GetMapping(path = "/goods/detail/{goodsId}")
    public Result<GoodsDetailVO> getGoodsDetail(@PathVariable("goodsId") Long goodsId){
        return null;
    }


}
