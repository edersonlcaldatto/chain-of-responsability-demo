package com.br.chainofresposabilty.transaction.service;

import java.util.List;
import java.util.stream.Stream;

public enum TypeTransationEnum {

    P("PIX"),
    T("TED"),
    D("DOC"),
    A("AGENCY"),
    O("OTHER");

    private final String description;

    TypeTransationEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static List<String> descriptions() {
        return Stream.of(values())
                .map(TypeTransationEnum::getDescription)
                .toList();
    }
}
