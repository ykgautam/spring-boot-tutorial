package com.yash.springboot.tutorial.error;

import com.yash.springboot.tutorial.enitity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException exception, WebRequest webRequest){
ErrorMessage errorMessage=new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
