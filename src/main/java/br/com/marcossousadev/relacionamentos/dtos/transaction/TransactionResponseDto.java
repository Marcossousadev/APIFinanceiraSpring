package br.com.marcossousadev.relacionamentos.dtos.transaction;

import br.com.marcossousadev.relacionamentos.enums.TransactionType;
import br.com.marcossousadev.relacionamentos.infrastructure.models.TagEntity;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponseDto{
        private BigDecimal amount;
        private String description;
        private TransactionType type;
        private LocalDateTime data;
        private Set<TagEntity> tags;
}
