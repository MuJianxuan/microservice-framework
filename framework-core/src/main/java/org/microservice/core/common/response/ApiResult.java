package org.microservice.core.common.response;

import cn.hutool.http.HttpStatus;
import lombok.Data;

import java.io.Serializable;

/**
 * 页信息
 * @author Rao
 * @Date 2021/11/04
 **/
@Data
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = -6434762428468357875L;
    /**
     * 状态值
     */
    private Integer status;

    /**
     * 数据
     */
    private T data;

    /**
     * 信息
     */
    private String message;

    /**
     * 分页信息
     */
    private PageInfo pageInfo;

    private ApiResult(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    private ApiResult(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

    private ApiResult(Integer status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> ApiResult<T> success(T data){
        return new ApiResult<T>(HttpStatus.HTTP_OK,data);
    }

    public static <T> ApiResult<T> fail(Integer status,String message){
        return new ApiResult<T>( status,message);
    }

    public static <T> ApiResult<T> fail(String message){
        return new ApiResult<T>(HttpStatus.HTTP_INTERNAL_ERROR,message);
    }


}
