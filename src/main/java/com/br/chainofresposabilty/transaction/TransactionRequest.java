package com.br.chainofresposabilty.transaction;

import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Validated
public record TransactionRequest(@NotNull(message = "Document is mandatory") String document,
                                 @NotNull(message = "Amount is mantatory") BigDecimal amount) {
}
