package web.app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class GDPRInterceptor {

    private Logger logger = LoggerFactory.getLogger( GDPRInterceptor.class );

    @Around("@annotation(GDPR)")
    public Object encrypt(ProceedingJoinPoint joinPoint ) throws Throwable {
        logger.info("Method intercepted");
        return null;
    }
}
