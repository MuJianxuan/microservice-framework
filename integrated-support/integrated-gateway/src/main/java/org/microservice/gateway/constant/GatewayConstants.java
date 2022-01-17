package org.microservice.gateway.constant;

/**
 * @author Rao
 * @Date 2021/11/06
 **/
public class GatewayConstants {

    /**
     * 网关认证过滤器 order值
     *    其他可以根据此值进行定义是在认证之前记录还是在之后，比如黑客攻击，那可以在认证之前做一次，失败的存储后，然后在登录校验前就先打死，不让其进行校验token。
     */
    public static final Integer GATEWAY_AUTH_FILTER_ORDER = 0;

}
