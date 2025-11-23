package com.yukangming.example.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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
    @Pointcut(value = "execution(* test*(..))")
    public void beforePointCut() {
    }

    @Pointcut(value = "execution(* test*(..))")
    public void afterPointCut() {

    }


    /**
     * 代理方法执行增强逻辑时发生异常也会导致被拦截的业务方法执行失败
     * @param joinPoint
     */
    @After("afterPointCut()")
    public void afterPointCut(JoinPoint joinPoint) {
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        System.out.println("后置增强逻辑" + declaringTypeName);
//        throw new RuntimeException("这是后置增强逻辑导致的异常");
    }

    @Pointcut(value = "execution(* test*(..))")
    public void afterReturningPointCut() {

    }

    @AfterReturning("afterReturningPointCut()")
    public void afterReturningPointCut(JoinPoint joinPoint) {
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        System.out.println(declaringTypeName);
        throw new RuntimeException("这个是afterReturningPointCut增强逻辑抛出的异常");
    }


    /**
     * 这里解答了我的疑惑，原来会解析这个before注解为各种类型，比如这里就是解析成AspectJMethodBeforeAdvice
     * 这些advice的调用又有不同的MethodInterceptor，这里是MethodBeforeAdviceInterceptor，对应的invoke方法会去在真正被拦截方法之前执行
     */
    @Before("beforePointCut()")
    public void doBeforeTest() {
        System.out.println("从前置增强逻辑里面抛出异常看看会不会影响业务逻辑");
//        throw new RuntimeException("这是从前置增强逻辑里面抛出的异常");
        System.out.println("this is my before advice check");
    }

    @Before("execution(* com.yukangming.example.controller.TestController.*(..))")
    public void deBeforeTest2() {
        System.out.println("this is another before advice");
    }

}
