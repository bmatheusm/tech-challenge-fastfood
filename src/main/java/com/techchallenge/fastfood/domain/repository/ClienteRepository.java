package com.techchallenge.fastfood.domain.repository;

import com.techchallenge.fastfood.adapters.driven.infra.entity.ClienteEntity;

import java.util.Optional;

public interface ClienteRepository {
    Optional<ClienteEntity> findByCpf(String cpf);
    ClienteEntity save(ClienteEntity cliente);
}
