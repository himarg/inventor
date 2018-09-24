package com.himarg.stockapp.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AppAspects {

	@Around("execution(* com.himarg.stockapp..*.*(..))")
	public Object entryAndExitLogger(ProceedingJoinPoint joinPoint) throws Throwable{
		final Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		Object retVal = null;
		try {
            StringBuffer startMessageStringBuffer = new StringBuffer();

            startMessageStringBuffer.append("Start method ");
            startMessageStringBuffer.append(joinPoint.getSignature().getName());
            startMessageStringBuffer.append("(");

            Object[] args = joinPoint.getArgs();
            for (int i = 0; i < args.length; i++) {
                startMessageStringBuffer.append(args[i]).append(",");
            }
            if (args.length > 0) {
                startMessageStringBuffer.deleteCharAt(startMessageStringBuffer.length() - 1);
            }

            startMessageStringBuffer.append(")");

            logger.trace(startMessageStringBuffer.toString());

            retVal = joinPoint.proceed();

            StringBuffer endMessageStringBuffer = new StringBuffer();
            endMessageStringBuffer.append("Finish method ");
            endMessageStringBuffer.append(joinPoint.getSignature().getName());
            endMessageStringBuffer.append("(..); ");

            logger.trace(endMessageStringBuffer.toString());
        } catch (Throwable ex) {
            logger.error(ex.getMessage());

            throw ex;
        }

        return retVal;
	}
}
