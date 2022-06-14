package com.rainbow.mall.base.pojo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("通用上传入参")
public class UploadRequest {

    /**文件字节*/
    @ApiModelProperty(name = "bytes",value = "流")
    private byte[] bytes;

    /**存储桶名称*/
    @ApiModelProperty(name = "bucketName",value = "存储桶名称")
    private String bucketName;

}
