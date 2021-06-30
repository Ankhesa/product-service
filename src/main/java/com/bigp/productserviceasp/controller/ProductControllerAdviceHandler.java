package com.bigp.productserviceasp.controller;

import com.bigp.productserviceasp.exception.ProductNotFoundException;
import com.google.common.collect.Maps;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ProductControllerAdviceHandler {

    @ExceptionHandler(value = {ProductNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        Map<String, String> statusMap = Maps.newHashMap();
        statusMap.put("message", productNotFoundException.getMessage());

        return new ResponseEntity<>(statusMap, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, String>> handleException(Exception exception) {
        Map<String, String> statusMap = Maps.newHashMap();
        statusMap.put("message", exception.getMessage());

        return new ResponseEntity<>(statusMap, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
