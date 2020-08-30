package cn.edu.ctbu.firstdata.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {
    @Before("execution(public * cn.edu.ctbu.firstdata.restcontroller.StudentRestController.GetAll(..))")
    public void log(){
        System.out.println("1111");
    }
}
