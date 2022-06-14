package com.rainbow.mall.base.convert;

import com.rainbow.mall.base.pojo.dto.CompressionDTO;
import com.rainbow.mall.base.pojo.request.CompressionRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageConvert {

    CompressionDTO convertToCompressionDTO(CompressionRequest request);
}
