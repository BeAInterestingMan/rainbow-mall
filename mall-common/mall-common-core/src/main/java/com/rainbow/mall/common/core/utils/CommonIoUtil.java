package com.rainbow.mall.common.core.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CommonIoUtil {

    /**
     * @Description 输入流转byte[]
     * @author liuhu
     * @param input
     * @date 2022/6/14 18:33
     * @return byte[]
     */
    public static byte[] inputStreamToByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024*4];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }


    /**
     * @Description 输入流转byte[]
     * @author liuhu
     * @param bytes
     * @date 2022/6/14 18:33
     * @return byte[]
     */
    public static ByteArrayInputStream inputStreamToByteArray(byte[] bytes) {
         return   new ByteArrayInputStream(bytes);
    }


    public static ByteArrayInputStream  byteArrayInputStreamToByteArrayOutputStream(ByteArrayOutputStream outputStream){
       return new ByteArrayInputStream(outputStream.toByteArray());
    }
}
