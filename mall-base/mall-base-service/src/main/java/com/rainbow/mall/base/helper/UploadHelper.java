package com.rainbow.mall.base.helper;

import cn.hutool.core.lang.UUID;
import com.rainbow.mall.base.properties.MinioProperties;
import com.rainbow.mall.common.core.utils.LocalDateUtil;
import com.rainbow.mall.common.core.utils.SnowFlakeUtil;
import io.minio.*;
import io.minio.http.Method;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class UploadHelper {
    @Autowired
    private MinioProperties minioProperties;

    @Resource
    private MinioClient minioClient;

    /**
     * 查看存储bucket是否存在
     * @return boolean
     */
    public Boolean bucketExists(String bucketName) {
        Boolean found;
        try {
            found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return found;
    }

    /**
     * 创建存储bucket
     * @return Boolean
     */
    public Boolean makeBucket(String bucketName) {
        try {
            minioClient.makeBucket(MakeBucketArgs.builder()
                    .bucket(bucketName)
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * 删除存储bucket
     * @return Boolean
     */
    public Boolean removeBucket(String bucketName) {
        try {
            minioClient.removeBucket(RemoveBucketArgs.builder()
                    .bucket(bucketName)
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * 获取全部bucket
     */
    public List<Bucket> getAllBuckets() {
        try {
            List<Bucket> buckets = minioClient.listBuckets();
            return buckets;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @Description 通用上传
     * @author liuhu
     * @param file
     * @date 2022/6/14 15:38
     * @return java.lang.String
     */
    public String commonUpload(MultipartFile file) {
        if(Objects.isNull(file)){
            return StringUtils.EMPTY;
        }
        String objectName = getObjectName();
        try {
            PutObjectArgs.builder().bucket(minioProperties.getBucketName()).object(objectName)
                    .stream(file.getInputStream(), file.getSize(), -1).contentType(file.getContentType()).build();
            // 返回上传Url
            return getCommonUploadUrl(minioProperties.getEndpoint(),minioProperties.getBucketName(),objectName);
        } catch (Exception e) {
            log.info("execute commonUpload error",e);
            return StringUtils.EMPTY;
        }
    }

    /**
     * @Description 文件名称
     * @author liuhu
     * @date 2022/6/14 19:47
     * @return java.lang.String
     */
    public String getObjectName(){
        return LocalDateUtil.localDateFormat(LocalDate.now(), "yyyyMMdd")+"_"+ SnowFlakeUtil.snowflakeId() +".jpg";
    }

    /**
     * @Description 上传本地文件
     * @author liuhu
     * @param bucketName
     * @param objectName
     * @param filePath 本地文件路径
     * @date 2022/6/14 15:31
     * @return java.lang.String
     */
    public  String uploadLocalFile(String bucketName, String objectName, String filePath) {
        try {
            UploadObjectArgs objectArgs = UploadObjectArgs.builder()
                    .bucket(bucketName)
                    .object(objectName)
                    .filename(filePath)
                    .build();
            minioClient.uploadObject(objectArgs);
            // 返回上传Url
            return getCommonUploadUrl(minioProperties.getEndpoint(),minioProperties.getBucketName(),objectName);
        } catch (Exception e) {
            log.info("execute commonUpload error",e);
            return StringUtils.EMPTY;
        }
    }


    /**
     * @Description 通过流上传文件
     * @author liuhu
     * @param bucketName
     * @param inputStream
     * @date 2022/6/14 15:28
     * @return java.lang.String
     */
    public String  commonUpload(String bucketName, InputStream inputStream){
        String objectName = getObjectName();
        try {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .stream(inputStream, inputStream.available(), -1)
                            .build());
            // 返回上传Url
            return getCommonUploadUrl(minioProperties.getEndpoint(),minioProperties.getBucketName(),objectName);
        } catch (Exception e) {
            log.info("execute commonUpload error",e);
            return StringUtils.EMPTY;
        }
    }

    /**
     * @Description 获取文件上传的url
     * @author liuhu
     * @param endpoint
     * @param bucketName
     * @param objectName
     * @date 2022/6/14 15:37
     * @return java.lang.String
     */
    public String getCommonUploadUrl(String endpoint,String bucketName,String objectName){
        return String.join("/",new String[]{endpoint, bucketName, objectName});
    }

    /**
     * 获得文件外链
     * @param bucketName
     * @param objectName
     * @return url
     * @throws Exception
     */
    public  String getPreSignedObjectUrl(String bucketName, String objectName) throws Exception {
        GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .method(Method.GET).build();
        return minioClient.getPresignedObjectUrl(args);
    }


    /**
     * 预览图片
     * @param fileName
     * @return
     */
    public String preview(String fileName){
        // 查看文件地址
        GetPresignedObjectUrlArgs build = new GetPresignedObjectUrlArgs().builder().bucket(minioProperties.getBucketName()).object(fileName).method(Method.GET).build();
        try {
            return minioClient.getPresignedObjectUrl(build);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 文件下载
     * @param fileName 文件名称
     * @param res response
     * @return Boolean
     */
    public void download(String fileName, HttpServletResponse res) {
        GetObjectArgs objectArgs = GetObjectArgs.builder().bucket(minioProperties.getBucketName())
                .object(fileName).build();
        try (GetObjectResponse response = minioClient.getObject(objectArgs)){
            byte[] buf = new byte[1024];
            int len;
            try (FastByteArrayOutputStream os = new FastByteArrayOutputStream()){
                while ((len=response.read(buf))!=-1){
                    os.write(buf,0,len);
                }
                os.flush();
                byte[] bytes = os.toByteArray();
                res.setCharacterEncoding("utf-8");
                // 设置强制下载不打开
                // res.setContentType("application/force-download");
                res.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
                try (ServletOutputStream stream = res.getOutputStream()){
                    stream.write(bytes);
                    stream.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查看文件对象
     * @return 存储bucket内文件对象信息
     */
    public List<Item> listObjects() {
        Iterable<Result<Item>> results = minioClient.listObjects(
                ListObjectsArgs.builder().bucket(minioProperties.getBucketName()).build());
        List<Item> items = new ArrayList<>();
        try {
            for (Result<Item> result : results) {
                items.add(result.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return items;
    }

    /**
     * 删除
     * @param fileName
     * @return
     * @throws Exception
     */
    public boolean remove(String fileName){
        try {
            minioClient.removeObject( RemoveObjectArgs.builder().bucket(minioProperties.getBucketName()).object(fileName).build());
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
