package com.rainbow.mall.common.entity.entity.base;

import lombok.Data;

import java.io.Serializable;

/**
 *  @Description 统一返回值
 *  @author liuhu
 *  @Date 2022/5/14 18:38
 */
@Data
public class Result<T> implements Serializable {

    private static final String SUCCESS_CODE = "200";

    private static final String SUCCESS_MSG = "ok";

    private static final String ERROR_CODE = "500";

    private boolean success;

    private String code;

    private String message;

    private T result;


    public static  <T>Result<T> success(T result){
        Result<T> data = new Result<>();
        data.setResult(result);
        data.setCode(SUCCESS_CODE);
        data.setMessage("success");
        data.setSuccess(Boolean.TRUE);
        return data;
    }

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(SUCCESS_CODE);
        result.setMessage("success");
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    public static <T> Result<T> error(String code,String msg) {
        Result<T> result = new Result<>();
        result.setMessage(msg);
        result.setCode(code);
        result.setSuccess(Boolean.FALSE);
        return result;
    }

    public static <T> Result<T> error(String code,String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setCode(msg);
        result.setResult(data);
        result.setSuccess(Boolean.FALSE);
        return result;
    }
}
