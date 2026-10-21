package br.com.marcossousadev.relacionamentos.dtos.user;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserDto(
        @NotBlank(message = "email é obrigatório")
        String email,
        @NotBlank(message = "nome é obrigatório")
        String nome,
        @NotNull(message = "idade é obrigatório")
        Integer idade,
        String cpf,
        String cnpj
) {
}
