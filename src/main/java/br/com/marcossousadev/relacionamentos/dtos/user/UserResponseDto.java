package br.com.marcossousadev.relacionamentos.dtos.user;

import lombok.Builder;

@Builder
public record UserResponseDto (String nome, String email, Integer idade) {
}
