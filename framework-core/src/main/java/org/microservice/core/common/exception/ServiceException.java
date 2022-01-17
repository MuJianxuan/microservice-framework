package org.microservice.core.common.exception;

import lombok.Getter;
import lombok.Setter;
import org.microservice.core.common.response.ApiResult;

/**
 * 业务异常
 * @author Rao
 * @Date 2021/11/10
 **/
@Setter
@Getter
public class ServiceException extends UnimportantException {
    private static final long serialVersionUID = 6924713140817601466L;

    /**
     * bind ,but Null does not handle
     * {@link ApiResult#status}
     */
    private Integer status;

    /**
     * 国际化 key 值
     *   支持动态国际化key
     */
    private String globalizationKey;

    /**
     * 信息
     */
    private String message;

    public ServiceException(String message) {
        super(message);
        this.message = message;
    }

    public ServiceException(Integer status,String message){
        super(message);
        this.status = status;
        this.message = message;
    }

    public ServiceException(Integer status,String message,Throwable cause){
        super(message);
        this.status = status;
        this.message = message;
    }

    // 其他的话 用到再说吧

}
