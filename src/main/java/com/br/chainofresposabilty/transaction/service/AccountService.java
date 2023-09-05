package com.br.chainofresposabilty.transaction.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService implements Balances {
    @Override
    public BigDecimal getDisponibleValue(String document) {
        return new BigDecimal("100");
    }
}
