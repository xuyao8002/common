package com.xuyao.annotation;

import com.google.common.util.concurrent.RateLimiter;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
@Aspect
public class RateLimitAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(RateLimitAspect.class);

    private ConcurrentHashMap<String, RateLimiter> limiters = new ConcurrentHashMap<>();

//    @Pointcut("@annotation(com.xuyao.annotation.RateLimitAspect)")
//    public void serviceLimit() {
//    }


//    @Around("serviceLimit() && @annotation(rateLimitAspect)")
//    public Object around(ProceedingJoinPoint joinPoint, RateLimitAspect rateLimitAspect) {

    @Around("@annotation(rateLimit)")
    public Object around(ProceedingJoinPoint joinPoint, RateLimit rateLimit) throws Throwable {
        RateLimiter rateLimiter = getRateLimiter(rateLimit, joinPoint);
        if(rateLimiter == null){
            LOGGER.info("rateLimiter为空，类{}，方法{}", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName());
            return joinPoint.proceed();
        }
        if(rateLimiter.tryAcquire()){
            LOGGER.info("拿到许可，类{}，方法{}", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName());
            return joinPoint.proceed();
        }
        LOGGER.info("未拿到许可，类{}，方法{}", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName());
        return "no";
    }



    private RateLimiter getRateLimiter(RateLimit rateLimit, ProceedingJoinPoint joinPoint){
        return limiters.computeIfAbsent(getKey(rateLimit, joinPoint), k -> RateLimiter.create(rateLimit.permitsPerSecond()));
    }

    private String getKey(RateLimit rateLimit, ProceedingJoinPoint joinPoint){
        String key = rateLimit.key();
        if (StringUtils.isBlank(key)) {
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            key = className + "#" + methodName;
        }
        return key;
    }

}
