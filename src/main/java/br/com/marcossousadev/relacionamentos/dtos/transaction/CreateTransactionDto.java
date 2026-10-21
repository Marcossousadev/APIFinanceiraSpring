package br.com.marcossousadev.relacionamentos.dtos.transaction;

import br.com.marcossousadev.relacionamentos.enums.TransactionType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateTransactionDto(
        @NotNull(message = "valor da transação é obrigatório")
        @Positive(message = "O valor da transação deve ser maior que 0")
        BigDecimal amount,
        String description,
        @NotNull(message = "informe o tipo da transação")
        TransactionType type,
        @NotNull(message = "id da carteira é obrigatório")
        Long wallet_id
) {
}
