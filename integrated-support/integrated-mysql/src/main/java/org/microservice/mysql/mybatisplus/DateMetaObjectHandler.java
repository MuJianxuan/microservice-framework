package org.microservice.mysql.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * TODO
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

    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
