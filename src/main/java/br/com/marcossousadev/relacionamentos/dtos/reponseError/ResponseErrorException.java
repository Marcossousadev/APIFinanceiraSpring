package br.com.marcossousadev.relacionamentos.dtos.reponseError;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseErrorException {
    String message;
    Integer code;
}
