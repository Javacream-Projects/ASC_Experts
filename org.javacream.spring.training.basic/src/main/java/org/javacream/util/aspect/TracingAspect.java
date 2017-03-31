package org.javacream.util.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class TracingAspect {

	@Around("execution(public boolean org.javacream..impl.*.*(..))")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("before tracing..." + ((MethodSignature)pjp.getSignature()).getName());
		Object result = pjp.proceed();
		System.out.println("after tracing...");
		return result;
	}
}
