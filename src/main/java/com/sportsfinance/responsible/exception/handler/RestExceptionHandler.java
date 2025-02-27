package com.sportsfinance.responsible.exception.handler;

import com.sportsfinance.responsible.exception.AlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice

public class RestExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<RestErrorMessage> runTimeException(RuntimeException exception, WebRequest request) {
        String timestamp = LocalDateTime.now().toString();
        String path = request.getDescription(false).replace("uri=", "");
        String errorCode = "RUNTIME_ERROR"; // Ou algum código apropriado

        RestErrorMessage errorMessage = new RestErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                timestamp,
                path,
                errorCode
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    protected ResponseEntity<RestErrorMessage> alreadyExists(AlreadyExistsException exception, WebRequest request) {
        String timestamp = LocalDateTime.now().toString();
        String path = request.getDescription(false).replace("uri=", "");
        String errorCode = "ALREADY_EXISTS";
        RestErrorMessage errorMessage = new RestErrorMessage(
                HttpStatus.CONFLICT,
                exception.getMessage(),
                timestamp,
                path,
                errorCode
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }

}
