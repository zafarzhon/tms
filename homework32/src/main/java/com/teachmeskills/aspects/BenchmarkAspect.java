package com.teachmeskills.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Component
@Aspect
public class BenchmarkAspect {
    @Pointcut("@annotation(com.teachmeskills.aspects.Benchmark)")
    public void beforeAll() {
    }

    @Around("beforeAll()")
    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object result = joinPoint.proceed();
        long end = System.nanoTime();
        System.out.println(joinPoint.getSignature().getName() + " Time taken: " + (end - start));
        return result;
    }
}
