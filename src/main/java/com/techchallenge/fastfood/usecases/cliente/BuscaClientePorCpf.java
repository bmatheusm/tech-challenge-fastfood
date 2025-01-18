package com.techchallenge.fastfood.usecases.cliente;

import com.techchallenge.fastfood.domain.entities.ClienteEntity;

import java.util.Optional;

public interface BuscaClientePorCpf {
    Optional<ClienteEntity> buscaPorCpf(String cpf);
}
