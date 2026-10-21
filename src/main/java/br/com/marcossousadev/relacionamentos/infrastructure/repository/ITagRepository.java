package br.com.marcossousadev.relacionamentos.infrastructure.repository;

import br.com.marcossousadev.relacionamentos.infrastructure.models.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITagRepository extends JpaRepository<TagEntity, Long> {
    Optional<TagEntity> findByName(String name);
}
