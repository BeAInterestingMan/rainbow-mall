package com.rainbow.mall.base.controller;

import com.rainbow.mall.base.helper.MinioHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("base/oss/")
public class UploadController {

    @Autowired
    private MinioHelper minioHelper;

    @GetMapping("upload")
    public String upload(@RequestParam("file")MultipartFile file){
        return minioHelper.commonUpload(file);
    }
}
