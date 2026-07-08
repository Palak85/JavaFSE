package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    @Around("execution(* com.library.service.BookService.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        
        System.out.println("[AOP-LOG] Before executing: " + joinPoint.getSignature().toShortString());
        
        Object proceed = joinPoint.proceed();
        
        long duration = System.currentTimeMillis() - startTime;
        
        System.out.println("[AOP-LOG] After executing: " + joinPoint.getSignature().toShortString() 
                + " | Execution Time: " + duration + " ms");
        
        return proceed;
    }
}
