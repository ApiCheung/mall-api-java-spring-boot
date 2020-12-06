package com.esmee.mallapi.controller.param;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Esmee Zhang
 * @date 12/4/20 10:05 下午
 * @projectName mall-api
 */
public class PageQuery extends LinkedHashMap {

    private int page;

    private int limit;

    public PageQuery (Map<? extends String, ?> params) {

        this.putAll(params);

        this.page = Integer.parseInt(params.get("page").toString());
        this.limit = Integer.parseInt(params.get("limit").toString());
        this.put("page", page);
        this.put("start", (page - 1) * limit);
        this.put("limit", limit);
    }
}
