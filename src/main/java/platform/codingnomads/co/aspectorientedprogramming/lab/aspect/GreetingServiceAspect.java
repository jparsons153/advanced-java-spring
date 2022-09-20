package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import platform.codingnomads.co.aspectorientedprogramming.aop.aspect.ServiceAspect;

@Aspect
@Component
public class GreetingServiceAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingServiceAspect.class);


    @Pointcut(value = "execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.greeting(..))")
    private void logGreetingServiceMethods() {
    }

    @Before("logGreetingServiceMethods()")
    public void logBeforeAdvise(JoinPoint joinPoint){
        LOGGER.info("Before : " + joinPoint.getSignature().getName());
    }

    @AfterReturning("logGreetingServiceMethods()")
    public void logAfterReturning(JoinPoint joinPoint){
        LOGGER.info("After Returning : " + joinPoint.getSignature().getName());
    }

    @Pointcut(value = "execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.customGreeting(..))")
    private void logCustomGreetingServiceMethods() {
    }

    @Before("logCustomGreetingServiceMethods()")
    public void logBeforeAdviseCustomGreeting(JoinPoint joinPoint){
        LOGGER.info("Before custom greeting : " + joinPoint.getSignature().getName());
    }

}
