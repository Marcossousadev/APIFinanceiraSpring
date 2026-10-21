package br.com.marcossousadev.relacionamentos.infrastructure.repository;

import br.com.marcossousadev.relacionamentos.infrastructure.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
