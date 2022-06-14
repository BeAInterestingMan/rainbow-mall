package com.rainbow.mall.base.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UploadDTO {

    /**文件字节*/
    private byte[] bytes;

    /**压缩后图片上传的桶*/
    private String bucketName;

}
