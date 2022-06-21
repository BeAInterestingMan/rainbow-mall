package com.rainbow.mall.goods.service.pojo.dto.service;

import lombok.Data;

import java.util.List;

/**
 * @author paulG
 * @since 2020/10/20
 **/
@Data
public class SelectorOptionsDTO {

    private String name;

    private String value;

    private String url;

    private List<SelectorOptionsDTO> otherOptions;


}
