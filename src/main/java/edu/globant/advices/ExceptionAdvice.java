package edu.globant.advices;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.globant.exceptions.DemoException;

@ControllerAdvice
public class ExceptionAdvice {
	
	@ResponseStatus(value=HttpStatus.CONFLICT,   reason="Exception of demostration with an aspect") 
	@ExceptionHandler(DemoException.class)
	//@ResponseBody ErrorInfo //En caso de que quiera retornar en el response un objeto
	public String handleDemoException(Exception exception, HttpServletRequest req) {
		req.setAttribute("javax.servlet.error.status_code", HttpStatus.BAD_REQUEST.value());
		return "Exception present...";
	}

}
