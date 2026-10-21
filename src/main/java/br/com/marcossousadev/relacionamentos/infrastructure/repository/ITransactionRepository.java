package br.com.marcossousadev.relacionamentos.infrastructure.repository;

import br.com.marcossousadev.relacionamentos.infrastructure.models.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<TransactionEntity, Long> {
}
