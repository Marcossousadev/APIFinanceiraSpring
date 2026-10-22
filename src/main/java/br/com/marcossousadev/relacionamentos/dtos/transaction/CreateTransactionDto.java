package br.com.marcossousadev.relacionamentos.dtos.transaction;

import br.com.marcossousadev.relacionamentos.enums.TransactionType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTransactionDto {
        @NotNull(message = "valor da transação é obrigatório")
        @Positive(message = "O valor da transação deve ser maior que 0")
        private BigDecimal amount;
        private String description;
        @NotNull(message = "informe o tipo da transação")
        private TransactionType type;
        @NotNull(message = "id da carteira é obrigatório")
        private Long wallet_id;
        private Set<Long> tagsId = new HashSet<>();
}
