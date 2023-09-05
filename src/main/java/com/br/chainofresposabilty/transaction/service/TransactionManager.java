package com.br.chainofresposabilty.transaction.service;

import com.br.chainofresposabilty.transaction.TransactionRequest;
import com.br.chainofresposabilty.transaction.handlers.AccountHandler;
import com.br.chainofresposabilty.transaction.handlers.LimitHandler;
import com.br.chainofresposabilty.transaction.handlers.LoanHandler;
import org.springframework.stereotype.Service;

@Service
public class TransactionManager {

    private final AccountHandler accountHandler;
    private final LimitHandler limitHandler;
    private final LoanHandler loanHandler;

    public TransactionManager(AccountHandler accountHandler,
                              LimitHandler limitHandler,
                              LoanHandler loanHandler) {
        this.accountHandler = accountHandler;
        this.limitHandler = limitHandler;
        this.loanHandler = loanHandler;
    }

    public Boolean processTransaction(TransactionRequest transaction) {

        accountHandler.setNextHandler(limitHandler);
        limitHandler.setNextHandler(loanHandler);

        return accountHandler.handler(transaction);

    }

}
