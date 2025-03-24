package org.microservice.mysql.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 日期拦截填充
 *
 * @author Rao
 * @Date 2021/11/08
 **/
public class DateMetaObjectHandler implements MetaObjectHandler {

    private MybatisPlusAutoFillProperties mybatisPlusAutoFillProperties;

    public DateMetaObjectHandler(MybatisPlusAutoFillProperties mybatisPlusAutoFillProperties) {
        this.mybatisPlusAutoFillProperties = mybatisPlusAutoFillProperties;
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("createTime", new Date(), metaObject);
        setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasSetter("updateTime") && getFieldValByName("updateTime", metaObject) == null) {
            setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }
    }
}
