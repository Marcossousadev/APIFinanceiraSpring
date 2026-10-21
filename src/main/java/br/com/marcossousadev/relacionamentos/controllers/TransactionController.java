package br.com.marcossousadev.relacionamentos.controllers;

import br.com.marcossousadev.relacionamentos.business.TransactionService;
import br.com.marcossousadev.relacionamentos.dtos.transaction.CreateTransactionDto;
import br.com.marcossousadev.relacionamentos.dtos.transaction.TransactionResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@Validated
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<String> createTransaction(@Valid @RequestBody CreateTransactionDto body) {
        transactionService.createTransaction(body);
        return ResponseEntity.status(HttpStatus.CREATED).body("transação realizada com sucesso!");
    }
    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponseDto> findTransactionById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.getTransactionById(id));
    }
}
