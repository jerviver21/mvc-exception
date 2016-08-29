package edu.globant.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Controller;

@Aspect
@Controller
public class ControllerMonitor {

	@AfterReturning("execution(* edu..*Controller.*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		System.out.println("(Aspect: ) Completed: " + joinPoint);
	}

}
