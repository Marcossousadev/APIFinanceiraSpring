package br.com.marcossousadev.relacionamentos.infrastructure.repository;

import br.com.marcossousadev.relacionamentos.infrastructure.models.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWalletRepository extends JpaRepository<WalletEntity, Long> {
}
