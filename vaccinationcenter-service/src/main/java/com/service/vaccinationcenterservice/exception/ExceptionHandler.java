package com.service.vaccinationcenterservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(value= {VaccinationCenterNotExistsException.class})
	public ResponseEntity<Object> handleVaccinationCenterNotExistsException(VaccinationCenterNotExistsException vc) {
		ExceptionInfo ei=new ExceptionInfo(vc.getMessage(),vc.getCause(),HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(ei,HttpStatus.NOT_FOUND);
		
	}

}
