package com.rainbow.mall.base.controller;

import com.rainbow.mall.base.convert.ImageConvert;
import com.rainbow.mall.base.pojo.dto.CompressionDTO;
import com.rainbow.mall.base.pojo.request.CompressionRequest;
import com.rainbow.mall.base.service.ImageService;
import com.rainbow.mall.common.core.utils.CommonIoUtil;
import com.rainbow.mall.common.entity.entity.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/base/image/")
@Api(tags = "图片压缩api")
public class ImageController {

    @Autowired
    private ImageConvert imageConvert;

    @Autowired
    private ImageService imageService;

    @GetMapping("compressionTest")
    @ApiOperation("通用图片压缩测试")
    public Result<String> compression(@RequestParam("file") MultipartFile file) throws IOException {
        byte[] bytes = CommonIoUtil.inputStreamToByteArray(file.getInputStream());
        CompressionDTO build = CompressionDTO.builder().bytes(bytes).height(200).width(200).bucketName("rainbowmall").build();
        return Result.success(imageService.compression(build));
    }


    @PostMapping("compression")
    @ApiOperation("通用图片压缩")
    @ApiImplicitParam(name = "request",value = "图片压缩入参")
    public Result<String> compression(@RequestBody CompressionRequest request){
        CompressionDTO compressionDTO = imageConvert.convertToCompressionDTO(request);
        return Result.success(imageService.compression(compressionDTO));
    }
}
