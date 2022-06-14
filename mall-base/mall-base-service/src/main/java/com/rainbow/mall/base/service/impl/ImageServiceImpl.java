package com.rainbow.mall.base.service.impl;

import com.rainbow.mall.base.helper.ImageHelper;
import com.rainbow.mall.base.helper.UploadHelper;
import com.rainbow.mall.base.pojo.dto.CompressionDTO;
import com.rainbow.mall.base.service.ImageService;
import com.rainbow.mall.common.core.utils.CommonIoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageHelper imageHelper;

    @Autowired
    private UploadHelper uploadHelper;

    @Override
    public String compression(CompressionDTO compressionDTO) {
        ByteArrayInputStream inputStream = CommonIoUtil.inputStreamToByteArray(compressionDTO.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        imageHelper.changeSize(inputStream,compressionDTO.getWidth(),compressionDTO.getHeight(),outputStream);
        ByteArrayInputStream stream = CommonIoUtil.byteArrayInputStreamToByteArrayOutputStream(outputStream);
        return uploadHelper.commonUpload(compressionDTO.getBucketName(), stream);
    }
}
