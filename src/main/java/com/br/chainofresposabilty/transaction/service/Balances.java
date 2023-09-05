package com.br.chainofresposabilty.transaction.service;

import java.math.BigDecimal;

public interface Balances {

    BigDecimal getDisponibleValue(String document);

}
