package com.techchallenge.fastfood.gateways.repository;

import com.techchallenge.fastfood.domain.entities.ClienteEntity;

import java.util.Optional;

public interface ClienteGateway {
    Optional<ClienteEntity> findByCpf(String cpf);
    ClienteEntity save(ClienteEntity cliente);
}
