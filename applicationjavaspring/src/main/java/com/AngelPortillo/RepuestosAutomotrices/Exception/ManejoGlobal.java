package com.AngelPortillo.RepuestosAutomotrices.Exception;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ManejoGlobal {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return crearRespuesta(ex.getMessage(), request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleResourceNotFoundException(BadRequestException ex, WebRequest request) {
        return crearRespuesta(ex.getMessage(), request, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<?> crearRespuesta(String mensaje, WebRequest request, HttpStatus status) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("estado", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("mensaje", mensaje);
        body.put("ruta", request.getDescription(false));

        return new ResponseEntity<>(body, status);
    }
}
