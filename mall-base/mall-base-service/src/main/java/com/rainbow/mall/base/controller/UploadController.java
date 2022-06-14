package com.rainbow.mall.base.controller;

import com.rainbow.mall.base.convert.UploadConvert;
import com.rainbow.mall.base.pojo.dto.UploadDTO;
import com.rainbow.mall.base.pojo.request.UploadRequest;
import com.rainbow.mall.base.service.UploadService;
import com.rainbow.mall.common.entity.entity.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api(tags = "文件上传api")
@RequestMapping("base/oss/")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @Autowired
    private UploadConvert uploadConvert;

    @GetMapping("uploadTest")
    @ApiOperation("通用上传测试")
    @ApiImplicitParam(name = "file",value = "测试通用上传")
    public Result<String> upload(@RequestParam("file")MultipartFile file){
        return Result.success(uploadService.upload(file));
    }

    @PostMapping("upload")
    @ApiOperation("通用上传")
    @ApiImplicitParam(name = "request",value = "通用上传")
    public Result<String> upload(@RequestBody UploadRequest request){
        UploadDTO uploadDTO= uploadConvert.convertToUploadDTO(request);
        return Result.success(uploadService.upload(uploadDTO));
    }
}
