package com.rainbow.mall.base.service.impl;

import com.rainbow.mall.base.helper.UploadHelper;
import com.rainbow.mall.base.pojo.dto.UploadDTO;
import com.rainbow.mall.base.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.Objects;

@Service
@Slf4j
public class UploadServiceImpl implements UploadService {

    @Autowired
    private UploadHelper uploadHelper;

    @Override
    public String upload(UploadDTO uploadDTO) {
        if(Objects.isNull(uploadDTO)){
            return StringUtils.EMPTY;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(uploadDTO.getBytes());
        return  uploadHelper.commonUpload(uploadDTO.getBucketName(),byteArrayInputStream);
    }

    @Override
    public String upload(MultipartFile file) {
        if(Objects.isNull(file)){
            return StringUtils.EMPTY;
        }
        return  uploadHelper.commonUpload(file);
    }

}
