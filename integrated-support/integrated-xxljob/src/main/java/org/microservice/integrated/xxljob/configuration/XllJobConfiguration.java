package org.microservice.integrated.xxljob.configuration;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * desc: xxljob 配置
 *
 * @author Rao
 * @Date 2022/01/26
 **/
@Data
@Import({XxlJobProperties.class})
public class XllJobConfiguration {

    /**
     * 配置执行器
     * @param xxlJobProperties
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean(value = XxlJobProperties.class)
    public XxlJobSpringExecutor xxlJobExecutor( XxlJobProperties xxlJobProperties) {
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses( xxlJobProperties.getAdminAddresses() );
        xxlJobSpringExecutor.setAccessToken( xxlJobProperties.getAccessToken());

        // 执行器
        XxlJobProperties.Executor executor = xxlJobProperties.getExecutor();
        xxlJobSpringExecutor.setAppname( executor.getAppName() );
        xxlJobSpringExecutor.setAddress( executor.getAddress() );
        xxlJobSpringExecutor.setIp( executor.getIp() );
        xxlJobSpringExecutor.setPort( executor.getPort() );
        xxlJobSpringExecutor.setLogPath( executor.getLogPath());
        xxlJobSpringExecutor.setLogRetentionDays( executor.getLogRetentionDays() );

        return xxlJobSpringExecutor;
    }

}
