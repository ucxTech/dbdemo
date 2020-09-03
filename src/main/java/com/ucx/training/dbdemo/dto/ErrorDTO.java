package com.ucx.training.dbdemo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorDTO {
    private final LocalDateTime timeStamp;
    private final String message;
    private final String path;

    @Builder
    public ErrorDTO(LocalDateTime timeStamp, String message, String path){
        this.timeStamp = timeStamp;
        this.message = message;
        this.path = path;
    }
}
