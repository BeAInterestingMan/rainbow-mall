package com.rainbow.mall.goods.service.pojo.dto.service;

import lombok.Data;

import java.util.List;

/**
 * 参数属性选择器
 *
 * @author paulG
 * @since 2020/10/20
 **/
@Data
public class ParamOptionsDTO {

    private String key;

    private List<String> values;

}
