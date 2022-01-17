package org.microservice.gateway.hystrixfallback;

import lombok.extern.slf4j.Slf4j;
import org.microservice.core.common.response.ApiResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rao
 * @Date 2021/11/06
 **/
@Slf4j
@RestController
public class HystrixFallbackController {

    @RequestMapping("/hystrixFallbackHandle")
    public ApiResult<String> hystrixFallbackHandle(){
        return ApiResult.fail("you are doubi!");
    }

}
