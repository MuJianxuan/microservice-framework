package org.microservice.mysql.mybatisplus;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.AlwaysUpdateSomeColumnById;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;

import java.util.List;

/**
 * @author Rao
 * @Date 2021/11/08
 **/
public class MysqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);

        // 批量新增
        methodList.add( new InsertBatchSomeColumn());
        // 总是更新一些字段 按 ID(但是不包含逻辑删除)
        methodList.add( new AlwaysUpdateSomeColumnById());

        return methodList;
    }
}
