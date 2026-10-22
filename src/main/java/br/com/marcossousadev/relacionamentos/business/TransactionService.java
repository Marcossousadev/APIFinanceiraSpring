package br.com.marcossousadev.relacionamentos.business;

import br.com.marcossousadev.relacionamentos.dtos.tag.TagResponseDto;
import br.com.marcossousadev.relacionamentos.dtos.transaction.CreateTransactionDto;
import br.com.marcossousadev.relacionamentos.dtos.transaction.TransactionResponseDto;
import br.com.marcossousadev.relacionamentos.exceptions.NotFoundException;
import br.com.marcossousadev.relacionamentos.infrastructure.models.TagEntity;
import br.com.marcossousadev.relacionamentos.infrastructure.models.TransactionEntity;
import br.com.marcossousadev.relacionamentos.infrastructure.models.WalletEntity;
import br.com.marcossousadev.relacionamentos.infrastructure.repository.ITagRepository;
import br.com.marcossousadev.relacionamentos.infrastructure.repository.ITransactionRepository;
import br.com.marcossousadev.relacionamentos.infrastructure.repository.IWalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class TransactionService {
    private final ITransactionRepository transactionRepository;
    private final IWalletRepository walletRepository;
    private final ITagRepository tagRepository;
    @Transactional
    public void createTransaction(CreateTransactionDto createTransactionDto) {
        WalletEntity wallet = walletRepository.findById(createTransactionDto.getWallet_id()).
                orElseThrow(() -> new NotFoundException("essa carteira não existe"));

        Set<TagEntity> tags = new HashSet<>();

        for (Long tagId : createTransactionDto.getTagsId()) {
            TagEntity tag = tagRepository.findById(tagId)
                    .orElseThrow(() -> new NotFoundException("Tag não encontrada: " + tagId ));
            tags.add(tag);
        }
        TransactionEntity transaction = TransactionEntity.builder()
                .amount(createTransactionDto.getAmount())
                .description( createTransactionDto.getDescription() != null ? createTransactionDto.getDescription() : null)
                .transactionType(createTransactionDto.getType())
                .wallet(wallet)
                .tags(tags)
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
                .tags(transaction.getTags())
                .build();
        return transactionResponse;
    }
}
