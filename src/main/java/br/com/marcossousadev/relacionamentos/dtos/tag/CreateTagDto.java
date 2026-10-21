package br.com.marcossousadev.relacionamentos.dtos.tag;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
public record CreateTagDto(
        @NotBlank
        String name
) {
}
