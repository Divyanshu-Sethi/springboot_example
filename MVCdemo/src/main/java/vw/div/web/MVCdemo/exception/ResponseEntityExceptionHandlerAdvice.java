package vw.div.web.MVCdemo.exception;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice // interceptor
public class ResponseEntityExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	ResponseEntity<Object> handleEmpNotFoundException(EmployeeNotFoundException e) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", e.getMessage());

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	// for all runtime exception
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> handleCityNotFoundException(RuntimeException ex) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	
	
	}
	
	
}
