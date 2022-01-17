package org.microservice.mysql.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rao
 * @Date 2021/11/08
 **/
//@ConditionalOnBean
@Configuration
public class MybatisPlusConfiguration {

    /**
     * mybatis-plus 插件
     * @return
     */
    @ConditionalOnMissingBean(MybatisPlusInterceptor.class)
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){

        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();

        // 添加分页插件
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        mybatisPlusInterceptor.addInnerInterceptor( paginationInnerInterceptor);

        // 乐观锁
        mybatisPlusInterceptor.addInnerInterceptor( new OptimisticLockerInnerInterceptor());

        // 防止全表更新与删除
        mybatisPlusInterceptor.addInnerInterceptor( new BlockAttackInnerInterceptor());

        // 动态表名

        // 多租户



        return mybatisPlusInterceptor;
    }


    /**
     * 注入Mysql 的Sql注入器
     * @return
     */
    @Bean
    public MysqlInjector mysqlInjector(){
        return new MysqlInjector();
    }




}
