package br.com.marcossousadev.relacionamentos.dtos.tag;

import lombok.Builder;

@Builder
public record TagResponseDto(Long id, String name) {
}
