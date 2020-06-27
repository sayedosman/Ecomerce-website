package com.example.ecomerce.website.Error;

import java.nio.file.AccessDeniedException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javassist.NotFoundException;

@ControllerAdvice
public class WebExceptionHandler {
    

	@ExceptionHandler(AccessDeniedException.class)
	public ModelAndView HandelForbiddenException(AccessDeniedException ex)
	{
		ex.printStackTrace();
		return new ModelAndView("error/403");
	}
	@ExceptionHandler(NotFoundException.class)
	public ModelAndView HandelForbiddenException(NotFoundException ex)
	{
		ex.printStackTrace();
		return new ModelAndView("error/404");
	}
	
}
