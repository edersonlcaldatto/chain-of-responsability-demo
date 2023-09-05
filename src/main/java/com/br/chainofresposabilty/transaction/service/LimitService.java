package com.br.chainofresposabilty.transaction.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LimitService implements Balances {
    @Override
    public BigDecimal getDisponibleValue(String document) {
        return new BigDecimal("300");
    }
}
