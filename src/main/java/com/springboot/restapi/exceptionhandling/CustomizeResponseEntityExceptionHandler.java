package com.springboot.restapi.exceptionhandling;

import com.springboot.restapi.socialmediaUsers.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionDetail> handleAllExceptions (Exception ex, WebRequest request) {
        ExceptionDetail exceptionDetail =
                new ExceptionDetail(LocalDate.now(), request.getDescription(false), ex.getMessage());
        return new ResponseEntity<>(exceptionDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ExceptionDetail> handleNoUserFoundException(Exception ex, WebRequest request) {
        ExceptionDetail exceptionDetail =
                new ExceptionDetail(LocalDate.now(), request.getDescription(false), ex.getMessage());
        return new ResponseEntity<>(exceptionDetail, HttpStatus.NOT_FOUND);
    }

}


