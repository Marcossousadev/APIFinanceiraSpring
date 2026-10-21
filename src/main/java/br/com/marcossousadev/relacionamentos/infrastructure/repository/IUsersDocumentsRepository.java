package br.com.marcossousadev.relacionamentos.infrastructure.repository;

import br.com.marcossousadev.relacionamentos.infrastructure.models.UsersDocumentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsersDocumentsRepository extends JpaRepository<UsersDocumentsEntity, Long> {
    Optional<UsersDocumentsEntity> findByCpf(String cpf);
    Optional<UsersDocumentsEntity> findByCnpj(String cnpj);
}
