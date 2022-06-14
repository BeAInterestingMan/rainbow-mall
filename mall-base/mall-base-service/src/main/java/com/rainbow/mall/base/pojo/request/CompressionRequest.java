package com.rainbow.mall.base.pojo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("图片压缩入参")
public class CompressionRequest {

    /**文件字节*/
    @ApiModelProperty(name = "bytes",value = "流")
    private byte[] bytes;

    /**压缩成指定长度*/
    @ApiModelProperty(name = "width",value = "压缩成指定长度")
    private Integer width;

    /**压缩成指定高度*/
    @ApiModelProperty(name = "height",value = "压缩成指定高度")
    private Integer height;

    /**按比例压缩*/
    @ApiModelProperty(name = "scale",value = "按比例压缩")
    private Double scale;

}
