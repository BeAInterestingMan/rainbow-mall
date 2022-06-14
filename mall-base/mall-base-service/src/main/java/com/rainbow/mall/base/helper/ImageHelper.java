package com.rainbow.mall.base.helper;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Component
@Slf4j
public class ImageHelper {
    /**
     * 指定大小缩放 若图片横比width小，高比height小，放大
     * 若图片横比width小，高比height大，高缩小到height，图片比例不变
     * 若图片横比width大，高比height小，横缩小到width，图片比例不变
     * 若图片横比width大，高比height大，图片按比例缩小，横为width或高为height
     *
     * @param resource  源文件路径
     * @param width     宽
     * @param height    高
     * @param tofile    生成文件路径
     */
    public  void changeSize(String resource, int width, int height, String tofile) {
        try {
            Thumbnails.of(resource).size(width, height).toFile(tofile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 指定大小缩放 若图片横比width小，高比height小，放大
     * 若图片横比width小，高比height大，高缩小到height，图片比例不变
     * 若图片横比width大，高比height小，横缩小到width，图片比例不变
     * 若图片横比width大，高比height大，图片按比例缩小，横为width或高为height
     *
     * @param inputStream  输入流
     * @param width     宽
     * @param height    高
     * @param tofile    生成文件路径
     */
    public  void changeSize(InputStream inputStream, int width, int height, OutputStream outputStream) {
        try {
            Thumbnails.of(inputStream).size(width, height).toOutputStream(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 指定比例缩放 scale(),参数小于1,缩小;大于1,放大
     *
     * @param resource   源文件路径
     * @param scale      指定比例
     * @param toFile     生成文件路径
     */
    public  void changeScale(String resource, double scale, String toFile) {
        try {
            Thumbnails.of(resource).scale(scale).toFile(toFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void changeScale(InputStream inputStream, double scale, OutputStream outputStream) {
        try {
            Thumbnails.of(inputStream).scale(scale).toOutputStream(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加水印 watermark(位置,水印,透明度)
     *
     * @param resource  源文件路径
     * @param p         水印位置
     * @param shuiyin   水印文件路径
     * @param opacity   水印透明度
     * @param tofile    生成文件路径
     */
    public  void watermark(String resource, Positions p, String shuiyin, float opacity, String tofile) {
        try {
            Thumbnails.of(resource).scale(1).watermark(p, ImageIO.read(new File(shuiyin)), opacity).toFile(tofile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        /**
         * 图片旋转 rotate(度数),顺时针旋转
         *
         * @param resource  源文件路径
         * @param rotate    旋转度数
         * @param tofile    生成文件路径
         */
        public  void rotate(String resource, double rotate, String tofile) {
            try {
                Thumbnails.of(resource).scale(1).rotate(rotate).toFile(tofile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        /**
         * 图片裁剪 sourceRegion()有多种构造方法，示例使用的是sourceRegion(裁剪位置,宽,高)
         *
         * @param resource  源文件路径
         * @param p         裁剪位置
         * @param width     裁剪区域宽
         * @param height    裁剪区域高
         * @param tofile    生成文件路径
         */
        public  void region(String resource, Positions p, int width, int height, String tofile) {
            try {
                Thumbnails.of(resource).scale(1).sourceRegion(p, width, height).toFile(tofile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }
