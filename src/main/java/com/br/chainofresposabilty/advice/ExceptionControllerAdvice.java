package com.br.chainofresposabilty.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.Objects;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorAdvice handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var bindingResult = ex.getBindingResult();
        var fieldErrors  = bindingResult.getFieldErrors();
        var listErros = new ArrayList<String>();

        fieldErrors.forEach(fieldError -> listErros.add(fieldError.getField().concat(": ").concat(Objects.requireNonNull(fieldError.getDefaultMessage()))));

        return new ErrorAdvice("500", listErros);
    }

}
