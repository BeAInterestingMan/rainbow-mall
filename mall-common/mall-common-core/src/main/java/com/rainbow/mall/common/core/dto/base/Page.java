package com.rainbow.mall.common.core.dto.base;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Page<T> {

    private Integer currentPage =1;

    private Integer pageSize = 10;

    private Long total;

    private T data;

    public static Page emptyPage(Integer currentPage,Integer pageSize){
        Page page = new Page();
        page.setPageSize(pageSize);
        page.setCurrentPage(currentPage);
        page.setTotal(0L);
        page.setData(new ArrayList<>());
        return page;
    }
}
