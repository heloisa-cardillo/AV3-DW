package com.autobots.automanager;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GerenciadorExcecoes {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException e) {
        if ("EASTER_EGG".equals(e.getMessage())) {
            Map<String, String> coelho = new LinkedHashMap<>();
            coelho.put("linha1", "  (\\(\\");
            coelho.put("linha2", "  ( ^.^) 🥕");
            coelho.put("linha3", "  o_(\")(\")");
            return new ResponseEntity<>(coelho, HttpStatus.OK);
        }
        Map<String, String> erro = new LinkedHashMap<>();
        erro.put("erro", e.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }
}
