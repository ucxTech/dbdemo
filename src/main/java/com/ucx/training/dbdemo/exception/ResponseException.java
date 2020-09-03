package com.ucx.training.dbdemo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseException extends Exception {
    private HttpStatus httpStatus;

    public ResponseException(String errorMessage, HttpStatus httpStatus){
        super(errorMessage);
        this.httpStatus = httpStatus;
    }
}
