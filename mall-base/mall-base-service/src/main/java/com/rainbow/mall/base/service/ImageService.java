package com.rainbow.mall.base.service;

import com.rainbow.mall.base.pojo.dto.CompressionDTO;

public interface ImageService {
    /**
     * @Description 压缩图片
     * @author liuhu
     * @param compressionDTO
     * @date 2022/6/14 19:08
     * @return java.lang.String
     */
    String compression(CompressionDTO compressionDTO);
}
