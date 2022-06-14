package com.rainbow.mall.base.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompressionDTO {

    /**文件字节*/
    private byte[] bytes;

    /**压缩后图片上传的桶*/
    private String bucketName;

    /**压缩成指定长度*/
    private Integer width;

    /**压缩成指定高度*/
    private Integer height;

}
