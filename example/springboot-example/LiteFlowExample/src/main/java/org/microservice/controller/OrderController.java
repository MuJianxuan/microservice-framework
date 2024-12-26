package org.microservice.controller;

import org.microservice.model.param.OrderInfoParam;
import org.microservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rao
 * @Date 2023/01/16
 **/
@RestController
@RequestMapping
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getOrderInfo")
    public void getOrderInfo(@RequestBody OrderInfoParam orderInfoParam){
        orderService.getOrderInfo(orderInfoParam);
    }

}
