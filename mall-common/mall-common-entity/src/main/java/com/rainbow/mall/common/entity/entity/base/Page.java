package com.rainbow.mall.common.entity.entity.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
