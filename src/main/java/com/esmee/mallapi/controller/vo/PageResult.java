package com.esmee.mallapi.controller.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Esmee Zhang
 * @date 12/4/20 9:40 下午
 * @projectName mall-api
 */
@Data
public class PageResult<T> implements Serializable {

    private int totalCount;

    private int pageSize;

    private int totalPage;

    private int currentPage;

    private List<T> list;

    public PageResult(int totalCount, int pageSize, int currentPage, List<T> list) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;

        this.currentPage = currentPage;
        this.list = list;
        this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
    }
}
