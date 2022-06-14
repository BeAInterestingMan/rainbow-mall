package com.rainbow.mall.base.convert;

import com.rainbow.mall.base.pojo.dto.UploadDTO;
import com.rainbow.mall.base.pojo.request.UploadRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UploadConvert {

    UploadDTO convertToUploadDTO(UploadRequest request);
}
