package org.microservice.service;

import com.yomahub.liteflow.core.FlowExecutor;
import org.microservice.model.param.OrderInfoParam;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Rao
 * @Date 2023/01/16
 **/
@Service
public class OrderService {

    @Resource
    private FlowExecutor flowExecutor;

    /**
     * 查询订单信息
     * @param orderInfoParam
     */
    public void getOrderInfo(OrderInfoParam orderInfoParam) {



    }
}
