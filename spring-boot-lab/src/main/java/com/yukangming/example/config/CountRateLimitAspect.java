package com.yukangming.example.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Aspect
@Component
@Order(5)
@Slf4j
public class CountRateLimitAspect {

    private final ConcurrentHashMap<String, AtomicInteger> REQUEST_COUNT = new ConcurrentHashMap<>();

    private final ConcurrentHashMap<String, Long> TIMESTAMP = new ConcurrentHashMap<>();

    /**
     * 这里本来想直接匹配所有方法的，结果匹配不上呜呜呜
     */
//    @Pointcut(value = "execution(* com.yukangming.example.*.*(..))")
    @Pointcut(value = "execution(* test*(..))")
    public void beforePointCut() {
    }


    /**
     * 这里解答了我的疑惑，原来会解析这个before注解为各种类型，比如这里就是解析成AspectJMethodBeforeAdvice
     * 这些advice的调用又有不同的MethodInterceptor，这里是MethodBeforeAdviceInterceptor，对应的invoke方法会去在真正被拦截方法之前执行
     */
    @Before("beforePointCut()")
    public void doBeforeTest() {
        System.out.println("this is my before advice check");
    }

    @Before("execution(* com.yukangming.example.controller.TestController.*(..))")
    public void deBeforeTest2() {
        System.out.println("this is another before advice");
    }

}
