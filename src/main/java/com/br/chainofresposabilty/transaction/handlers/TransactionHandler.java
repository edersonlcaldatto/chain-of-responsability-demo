package com.br.chainofresposabilty.transaction.handlers;

import com.br.chainofresposabilty.transaction.TransactionRequest;

public interface TransactionHandler {

    boolean handler(TransactionRequest transaction);

    void setNextHandler(TransactionHandler nextHandler);
}
