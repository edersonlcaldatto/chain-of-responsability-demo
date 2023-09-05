package com.br.chainofresposabilty.advice;

import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public record ErrorAdvice(@NotNull String code,
                          List<String> errors) {
}
