package com.core.be.appbe.controller;

import com.core.be.appbe.common.exception.GlobalErrorException;
import com.core.be.appbe.common.model.RestErrorResponse;
import com.core.be.appbe.common.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@Slf4j
@RestControllerAdvice
public class RestGlobalControllerAdvice {

    @ExceptionHandler(GlobalErrorException.class)
    public ResponseEntity<RestErrorResponse> badRequest(GlobalErrorException e){
        return ResponseEntity.badRequest()
                .body(RestErrorResponse.builder()
                        .message(e.getMessage())
                        .status(Constants.CODE_FAILED)
                        .timestamp(new Date())
                        .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestErrorResponse> internalServer(Exception e){
        log.error("error because : {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(RestErrorResponse.builder()
                        .timestamp(new Date())
                        .message(Constants.MSG_ERROR)
                        .status(Constants.CODE_ERROR)
                        .build());
    }
}
