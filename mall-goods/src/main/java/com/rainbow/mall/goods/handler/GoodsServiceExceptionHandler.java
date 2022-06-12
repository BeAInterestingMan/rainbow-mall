package com.rainbow.mall.goods.handler;

import com.rainbow.mall.common.core.dto.base.Result;
import com.rainbow.mall.goods.exception.GoodsServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GoodsServiceExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result handlerGlobalException(Exception e){
          log.error("系统异常:",e);
          return Result.error("500","系统异常,请联系管理员！");
    }


    @ExceptionHandler(value = GoodsServiceException.class)
    public Result handlerServiceException(GoodsServiceException e){
        log.error("商品系统业务异常:",e);
        return Result.error("500",e.getMessage());
    }
}
