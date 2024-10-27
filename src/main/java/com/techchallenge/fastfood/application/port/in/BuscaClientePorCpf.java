package com.techchallenge.fastfood.application.port.in;

import com.techchallenge.fastfood.adapters.driven.infra.entity.ClienteEntity;

import java.util.Optional;

public interface BuscaClientePorCpf {
    Optional<ClienteEntity> buscaPorCpf(String cpf);
}
