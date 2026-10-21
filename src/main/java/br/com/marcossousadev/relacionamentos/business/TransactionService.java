package br.com.marcossousadev.relacionamentos.business;

import br.com.marcossousadev.relacionamentos.dtos.transaction.CreateTransactionDto;
import br.com.marcossousadev.relacionamentos.dtos.transaction.TransactionResponseDto;
import br.com.marcossousadev.relacionamentos.exceptions.NotFoundException;
import br.com.marcossousadev.relacionamentos.infrastructure.models.TransactionEntity;
import br.com.marcossousadev.relacionamentos.infrastructure.models.WalletEntity;
import br.com.marcossousadev.relacionamentos.infrastructure.repository.ITransactionRepository;
import br.com.marcossousadev.relacionamentos.infrastructure.repository.IWalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class TransactionService {
    private final ITransactionRepository transactionRepository;
    private final IWalletRepository walletRepository;

    @Transactional
    public void createTransaction(CreateTransactionDto createTransactionDto) {
        WalletEntity wallet = walletRepository.findById(createTransactionDto.wallet_id()).
                orElseThrow(() -> new NotFoundException("essa carteira não existe"));

        TransactionEntity transaction = TransactionEntity.builder()
                .amount(createTransactionDto.amount())
                .description( createTransactionDto.description() != null ? createTransactionDto.description() : null)
                .transactionType(createTransactionDto.type())
                .wallet(wallet)
                .build();
        transactionRepository.save(transaction);
    }

    public TransactionResponseDto getTransactionById(Long id) {
        TransactionEntity transaction = transactionRepository.findById(id).orElseThrow(
                () -> new NotFoundException("transação não encontrada!")
        );
        TransactionResponseDto transactionResponse = TransactionResponseDto.builder()
                .amount(transaction.getAmount())
                .description(transaction.getDescription())
                .type(transaction.getTransactionType())
                .data(transaction.getDataCriacao())
                .build();
        return transactionResponse;
    }
}
