package com.br.chainofresposabilty.transaction.handlers;

import com.br.chainofresposabilty.transaction.TransactionRequest;
import com.br.chainofresposabilty.transaction.service.LoanService;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LoanHandler implements TransactionHandler {

    private final LoanService loanService;

    private TransactionHandler nextHandler;

    public LoanHandler(LoanService loanService) {
        this.loanService = loanService;
    }

    @Override
    public boolean handler(TransactionRequest transaction) {
        if (loanService.getDisponibleValue(transaction.document()).compareTo(transaction.amount()) <= 0) {
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
