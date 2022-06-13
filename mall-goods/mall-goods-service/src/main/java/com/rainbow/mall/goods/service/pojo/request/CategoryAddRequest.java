package com.rainbow.mall.goods.service.pojo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@ApiModel("pc后台管理端新增分类入参")
public class CategoryAddRequest {

    @ApiModelProperty(name = "name", value = "分类名称",required = true)
    @NotEmpty(message = "分类名称不能为空")
    @Size(max = 20)
    private String name;

    @ApiModelProperty(name = "parentId", value = "父id, 根节点为0",required = true)
    @NotEmpty(message = "请选择父分类")
    private String parentId;

    @ApiModelProperty(name = "level", value = "层级",required = true)
    @Min(value = 0,message = "层级需要大于0")
    @Max(value = 3,message = "层级最大为3")
    private Integer level;

    @ApiModelProperty(name = "sortOrder", value = "排序值",required = true)
    @NotNull(message = "排序值不能为空")
    @Max(value = 999,message = "排序值最大999")
    private Integer sortOrder;

    @ApiModelProperty(name = "commissionRate", value = "佣金比例")
    private Double commissionRate;

    @ApiModelProperty(name = "image", value = "分类图标")
    private String image;
}
