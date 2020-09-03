package com.ucx.training.dbdemo.controller;

import com.ucx.training.dbdemo.dto.ErrorDTO;
import com.ucx.training.dbdemo.exception.ResponseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResponseException.class)
    public ResponseEntity<ErrorDTO> handleRestApiException(ResponseException responseException, WebRequest webRequest) {

        ErrorDTO errorDTO = ErrorDTO.builder()
                .timeStamp(LocalDateTime.now())
                .message(responseException.getMessage())
                .path(webRequest.getDescription(false))
                .build();

        return ResponseEntity
                .status(responseException.getHttpStatus())
                .body(errorDTO);
    }
}
