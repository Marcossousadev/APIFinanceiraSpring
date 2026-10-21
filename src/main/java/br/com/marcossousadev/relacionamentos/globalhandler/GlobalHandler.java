package br.com.marcossousadev.relacionamentos.globalhandler;

import br.com.marcossousadev.relacionamentos.dtos.reponseError.ResponseErrorException;
import br.com.marcossousadev.relacionamentos.exceptions.BadRequestException;
import br.com.marcossousadev.relacionamentos.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseErrorException> handleNotFoundException(NotFoundException ex) {
        ResponseErrorException errorResponse = ResponseErrorException.builder()
                .message(ex.getMessage())
                .code(HttpStatus.NOT_FOUND.value())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ResponseErrorException> handleBadRequestException(BadRequestException ex) {
        ResponseErrorException errorResponse = ResponseErrorException.builder()
                .message(ex.getMessage())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
