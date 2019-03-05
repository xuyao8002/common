package com.xuyao.aspect;

import com.xuyao.annotation.DataSource;
import com.xuyao.utils.DataSourceUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Aspect
@Component
@Order(0)  //顺序要早于Transactional
public class DataSourceAspect {

    @Around("@annotation(dataSource)")
    public Object around(ProceedingJoinPoint jp, DataSource dataSource) throws Throwable {
        String name = dataSource.name();
        String sourceName = StringUtils.isEmpty(name) ? DataSource.master : name;
        DataSourceUtils.setDataSource(sourceName);
        return jp.proceed();
    }

}