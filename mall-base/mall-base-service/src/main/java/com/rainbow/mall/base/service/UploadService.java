package com.rainbow.mall.base.service;

import com.rainbow.mall.base.pojo.dto.UploadDTO;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    /**
     * @Description 上传
     * @author liuhu
     * @param uploadDTO
     * @date 2022/6/14 17:23
     * @return java.lang.String
     */
    String upload(UploadDTO uploadDTO);

    /**
     * @Description 上传
     * @author liuhu
     * @param file
     * @date 2022/6/14 18:36
     * @return java.lang.String
     */
    String upload(MultipartFile file);
}
