package com.br.chainofresposabilty.transaction.handlers;

import com.br.chainofresposabilty.transaction.TransactionRequest;
import com.br.chainofresposabilty.transaction.service.LimitService;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LimitHandler implements TransactionHandler {

    private final LimitService limitService;

    private TransactionHandler nextHandler;

    public LimitHandler(LimitService limitService) {
        this.limitService = limitService;
    }

    @Override
    public boolean handler(TransactionRequest transaction) {
        if (limitService.getDisponibleValue(transaction.document()).compareTo(transaction.amount()) <= 0) {
            return true;
        }
        if (Objects.nonNull(nextHandler)) {
            return nextHandler.handler(transaction);
        }
        return false;
    }

    @Override
    public void setNextHandler(TransactionHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
