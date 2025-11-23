package com.yukangming.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {

    @Pointcut("execution(* login(..))")
    public void myPoint(){};

    @Around("myPoint()")
    public  Object arround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("this is extra function added ");
        Object ret = proceedingJoinPoint.proceed();
        return  ret;
    }

    @Around(value = "myPoint()")
    public  Object arround2(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("this is another extra function added ");
        Object ret = proceedingJoinPoint.proceed();
        return  ret;
    }
}
