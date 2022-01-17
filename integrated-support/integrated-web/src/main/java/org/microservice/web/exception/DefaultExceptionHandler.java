package org.microservice.web.exception;

import org.microservice.core.common.exception.ServiceException;
import org.microservice.core.common.response.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 配置了 即启用
 *
 * @author Rao
 * @Date 2021/11/09
 **/
@Slf4j
@Component
@RestControllerAdvice(annotations = {RestController.class})
public class DefaultExceptionHandler {

    /**
     * 未控制的 Exception 异常处理
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ApiResult<Object> uncontrolledExceptionHandle(Exception ex){
        // TODO 国际化动态异常信息
        return ApiResult.fail( ex.getMessage() );

    }

    /**
     * 业务异常信息处理
     * @param serviceException
     */
    @ExceptionHandler(value = ServiceException.class)
    public void serviceExceptionHandle(ServiceException serviceException){

        //  国际化处理



    }



}
