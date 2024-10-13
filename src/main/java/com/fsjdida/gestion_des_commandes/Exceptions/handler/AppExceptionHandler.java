package com.fsjdida.gestion_des_commandes.Exceptions.handler;


import com.fsjdida.gestion_des_commandes.Exceptions.EntityAlreadyExistsException;
import com.fsjdida.gestion_des_commandes.Exceptions.EntityNotFoundException;
import com.fsjdida.gestion_des_commandes.shared.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = {EntityNotFoundException.class}) // tu passe votre entities
    public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(ex.getMessage())
                .Timestemp(new Date())
                .code(404)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {EntityAlreadyExistsException.class}) // tu passe votre entities
    public ResponseEntity<Object> entityAlreadyExistsException(EntityNotFoundException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(ex.getMessage())
                .Timestemp(new Date())
                .code(409)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }


}
