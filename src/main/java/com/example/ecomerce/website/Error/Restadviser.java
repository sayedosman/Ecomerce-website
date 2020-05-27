package com.example.ecomerce.website.Error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.ecomerce.website.Error.ErrorDetails;

import javassist.NotFoundException;

@RestControllerAdvice
public class Restadviser extends RuntimeException {


	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity <ErrorDetails> exception(Exception exception,WebRequest request) {
		ErrorDetails details=new ErrorDetails(exception.getLocalizedMessage(),request.getDescription(false),LocalDateTime.now());
	    return new  ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	    }

}
