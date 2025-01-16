package com.techchallenge.fastfood.gateways.repository.impl;

import com.techchallenge.fastfood.domain.entities.ClienteEntity;
import com.techchallenge.fastfood.gateways.repository.ClienteGateway;
import com.techchallenge.fastfood.infrastructure.repository.JpaClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ClienteRepositoryGateway implements ClienteGateway {

    private final JpaClienteRepository clienteRepository;

    @Override
    public Optional<ClienteEntity> findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    @Override
    public ClienteEntity save(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }
}
