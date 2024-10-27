package com.techchallenge.fastfood.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class CadastroClienteDTO {
    @NonNull
    private String email;
    @NonNull
    private String nome;
    @NonNull
    private String cpf;
}
