package org.microservice.mysql.mybatisplus.ex;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

import java.util.Objects;

public class LambdaQueryExWrapper<T> extends LambdaQueryWrapper<T> {

    /**
     * 扩展了eq方法
     * @param column
     * @param val
     * @return
     */
    public LambdaQueryWrapper<T> eqX(SFunction<T, ?> column, Object val) {
        return super.eq(Objects.nonNull(val),column, val);
    }

}
