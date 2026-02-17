package com.AngelPortillo.RepuestosAutomotrices.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MethodArgumentNotValidException extends RuntimeException {

    public MethodArgumentNotValidException(String mensaje) {
        super(mensaje);
    }
}
