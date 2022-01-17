package org.microservice.core.anno;

import java.lang.annotation.*;

/**
 * 简易得执行打印
 *  1、执行耗时
 *  2、执行入参
 *  3、执行返回
 * @author Rao
 * @Date 2021/11/10
 **/
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExecutePrintf {

    /**
     * 记录名称
     * @return
     */
    String name();

}
