package com.techchallenge.fastfood.usecases.cliente.impl;

import com.techchallenge.fastfood.domain.entities.ClienteEntity;
import com.techchallenge.fastfood.gateways.repository.ClienteGateway;
import com.techchallenge.fastfood.usecases.cliente.BuscaClientePorCpf;
import com.techchallenge.fastfood.utils.CpfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscaClientePorCpfImpl implements BuscaClientePorCpf {

    @Autowired
    private ClienteGateway clienteGateway;

    public Optional<ClienteEntity> buscaPorCpf(String cpf) {
        return clienteGateway.findByCpf(CpfUtils.removerPontuacoes(cpf));
    }
}
