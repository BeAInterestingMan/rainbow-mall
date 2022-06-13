package com.rainbow.mall.goods.service.exception;

import com.rainbow.mall.goods.service.enums.ResultCode;

/**
 *  @Description 业务异常
 *  @author liuhu
 *  @Date 2022/6/11 18:02
 */
public class GoodsServiceException extends RuntimeException{

    private ResultCode resultCode;

    private String msg = "网络错误，请稍后重试！";

    public GoodsServiceException(String msg) {
        this.resultCode = ResultCode.ERROR;
        this.msg = msg;
    }

    public GoodsServiceException() {
        super();
    }

    public GoodsServiceException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public GoodsServiceException(ResultCode resultCode, String message) {
        this.resultCode = resultCode;
        this.msg = message;
    }

}
