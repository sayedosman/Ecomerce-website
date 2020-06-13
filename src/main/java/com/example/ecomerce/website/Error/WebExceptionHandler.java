package com.example.ecomerce.website.Error;

import java.nio.file.AccessDeniedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecomerce.website.services.BrandService;
import com.example.ecomerce.website.services.CategoryService;
import com.example.ecomerce.website.services.ProductService;

import javassist.NotFoundException;

@ControllerAdvice
public class WebExceptionHandler {
    
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BrandService brandService;
	@Autowired 
	private ProductService productService; 
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
