package edu.globant.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Order") 
public class DemoException extends RuntimeException{
	
	public enum Action{
		RETURN_ACTION, FORWARD_ACTION
	}
	
	final public Action action;
	
	public DemoException(Action action) {
		this.action = action;
	}
}
