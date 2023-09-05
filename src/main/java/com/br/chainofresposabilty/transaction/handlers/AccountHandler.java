package com.br.chainofresposabilty.transaction.handlers;

import com.br.chainofresposabilty.transaction.TransactionRequest;
import com.br.chainofresposabilty.transaction.service.AccountService;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AccountHandler implements TransactionHandler {

    private final AccountService accountService;

    private TransactionHandler nextHandler;

    public AccountHandler(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public boolean handler(TransactionRequest transaction) {
        if (accountService.getDisponibleValue(transaction.document()).compareTo(transaction.amount()) <= 0) {
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
