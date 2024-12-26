package org.microservice.web;

import org.microservice.core.common.response.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rao
 * @Date 2024/12/26
 **/
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping
    public ApiResult<String> sayHello() {
        return ApiResult.success("Hello, World!") ;
    }
}
