package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintableAspect {

    @Pointcut("@annotation(Printable)")
    public void executePrintable() {
    }

    @After("executePrintable()")
    public void printMessage(JoinPoint joinPoint){
        System.out.println("Printing message to console");
    }
}
