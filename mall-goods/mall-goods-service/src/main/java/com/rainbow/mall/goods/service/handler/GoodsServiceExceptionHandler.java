package com.rainbow.mall.goods.service.handler;

import com.rainbow.mall.common.entity.entity.base.Result;
import com.rainbow.mall.goods.service.exception.GoodsServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GoodsServiceExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<Void> handlerGlobalException(Exception e){
          log.error("系统异常:",e);
          return Result.error("500","系统异常,请联系管理员！");
    }


    @ExceptionHandler(GoodsServiceException.class)
    public Result<Void> handlerServiceException(GoodsServiceException e){
        log.info("商品系统业务校验:",e);
        return Result.error("500",e.getMessage());
    }
}
