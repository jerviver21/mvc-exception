package edu.globant.controllers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.globant.exceptions.DemoException;

@Controller
public class ReturnOrRedirectController {
	protected Logger logger;

	public ReturnOrRedirectController() {
		logger = LoggerFactory.getLogger(getClass());
	}
	
	@RequestMapping(value="/demo", method = RequestMethod.GET)
	public ModelAndView test(){
		// Dado que usa thymeleaf, mapiara a templates/index.html, considere que es igual si  retornara un String, 
		// solo que ModelAndView permite comunicar información entre la vista y el controlador
		// Para que esto suceda debemos estar trabajando con @Controller, @RestControler devolvería un JSON o XML
		ModelAndView model =  new ModelAndView("index");
		model.addObject( "usr", "Jerson Viveros!!!");
		return model;
	}
	
	@RequestMapping(value="/demo/return", method = RequestMethod.GET)
	public String throwDemoException(){
		logger.info("First Example, crearemos un handler para que retorne una vista de error");
		throw new DemoException(DemoException.Action.RETURN_ACTION);//En este caso la excepción se está interceptando por una @ControllerAdvice (aspecto) que se encarga de procesarla
	}
	
	@ModelAttribute("timestamp")
	public Date getProfiles() {
		return new Date();
	}


}
