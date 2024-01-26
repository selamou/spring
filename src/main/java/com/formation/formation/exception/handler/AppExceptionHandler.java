package com.formation.formation.exception.handler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.formation.formation.exception.EntityAlreadyExistsException;
import com.formation.formation.exception.EntityNotFoundException;
import com.formation.formation.shared.ErrorMessage;

@RestControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(value = { EntityNotFoundException.class })
    public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder().message(ex.getMessage()).timestamp(new Date()).code(404)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = { EntityAlreadyExistsException.class })
    public ResponseEntity<Object> entityAlreadyExistsException(EntityAlreadyExistsException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder().message(ex.getMessage()).timestamp(new Date()).code(409)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);

    }

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return new ResponseEntity<>(errors, HttpStatus.CONFLICT);

    }

}
