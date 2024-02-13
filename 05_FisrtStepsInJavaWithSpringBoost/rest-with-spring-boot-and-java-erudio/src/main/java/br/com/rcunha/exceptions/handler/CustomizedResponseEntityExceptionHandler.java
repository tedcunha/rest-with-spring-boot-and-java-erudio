package br.com.rcunha.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.rcunha.exceptions.ExceptionRespone;
import br.com.rcunha.exceptions.UnsupportedMathOperationException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)	
  private final ResponseEntity<ExceptionRespone> handleAllExceptions(
		  Exception ex,WebRequest request) {
	  
	  ExceptionRespone exceptionRespone = new ExceptionRespone(
			  new Date(), 
			  ex.getMessage(), 
			  request.getDescription(false));
	  
	  return new ResponseEntity<>(exceptionRespone, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(UnsupportedMathOperationException.class)	
  private final ResponseEntity<ExceptionRespone> handleBadRequestExceptions(
		  Exception ex,WebRequest request) {
	  
	  ExceptionRespone exceptionRespone = new ExceptionRespone(
			  new Date(), 
			  ex.getMessage(), 
			  request.getDescription(false));
	  
	  return new ResponseEntity<>(exceptionRespone, HttpStatus.BAD_REQUEST);
  }

}
