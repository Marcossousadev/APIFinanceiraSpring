package br.com.marcossousadev.relacionamentos.dtos.transaction;

import br.com.marcossousadev.relacionamentos.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record TransactionResponseDto(
        BigDecimal amount,
        String description,
        TransactionType type,
        LocalDateTime data
) {
}
