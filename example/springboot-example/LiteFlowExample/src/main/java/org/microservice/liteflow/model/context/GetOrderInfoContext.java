package org.microservice.liteflow.model.context;

import lombok.Data;
import org.microservice.liteflow.model.param.OrderInfoParam;
import org.microservice.liteflow.model.vo.OrderVo;

/**
 * @author Rao
 * @Date 2023/01/16
 **/
@Data
public class GetOrderInfoContext {

    private final OrderInfoParam orderInfoParam;

    /**
     * 订单信息
     */
    private OrderVo orderVo;

}
