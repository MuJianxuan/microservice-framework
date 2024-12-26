package org.microservice.model.context;

import lombok.Data;
import org.microservice.model.param.OrderInfoParam;
import org.microservice.model.vo.OrderVo;

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
