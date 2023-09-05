package com.br.chainofresposabilty.transaction.api;

import com.br.chainofresposabilty.transaction.TransactionRequest;
import com.br.chainofresposabilty.transaction.service.TransactionManager;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionManager transactionManager;

    public TransactionController(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @PostMapping
    public ResponseEntity<Boolean> transaction(@RequestBody @Valid TransactionRequest request) {
        return ResponseEntity.ok(transactionManager.processTransaction(request));
    }

}
