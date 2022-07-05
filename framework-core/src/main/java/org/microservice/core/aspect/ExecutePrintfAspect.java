package org.microservice.core.aspect;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import org.microservice.core.anno.ExecutePrintf;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 开发环境和测试环境启用
 * 关于 order值的看法，我一开始我是觉得应该放后些，但转念一想，说不定就有人不看 order 值呢，哎
 * @author Rao
 * @Date 2021/11/11
 **/
@Slf4j
@Order(0)
@Aspect
@Profile(value = {"dev","test"})
@Component
public class ExecutePrintfAspect {

    /**
     * 环绕处理!
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("@annotation(org.microservice.core.anno.ExecutePrintf)")
    public Object aroundHandle(ProceedingJoinPoint pjp) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Object[] pjpArgs = pjp.getArgs();
        ExecutePrintf executePrintf = methodSignature.getMethod().getAnnotation(ExecutePrintf.class);
        String executeName ;
        if(executePrintf != null && StrUtil.isNotEmpty( executePrintf.name()) ){
            executeName = executePrintf.name();
        }
        else{
            executeName = methodSignature.getMethod().getName();
        }

        String argsStr = JSON.toJSONString(pjpArgs);
        long start = System.currentTimeMillis();
        log.info("execute info name:{};\n executeParams:{};\n executeStartMillis:{}",executeName, argsStr,start );
        Object proceed = pjp.proceed();
        log.info("execute info name:{};\n executeParams:{};\n executeMillis:{};\n result:{};\n",executeName, argsStr ,System.currentTimeMillis() - start, JSON.toJSONString( proceed));
        return proceed;
    }



}
