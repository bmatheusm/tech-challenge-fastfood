package com.techchallenge.fastfood.usecases.cliente.impl;

import com.techchallenge.fastfood.domain.entities.ClienteEntity;
import com.techchallenge.fastfood.infrastructure.dto.CadastroClienteDTO;
import com.techchallenge.fastfood.gateways.repository.ClienteGateway;
import com.techchallenge.fastfood.usecases.cliente.CadastraCliente;
import com.techchallenge.fastfood.utils.CpfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastraClienteImpl implements CadastraCliente {

    @Autowired
    private ClienteGateway clienteGateway;

    @Override
    public Optional<ClienteEntity> cadastrarCliente(CadastroClienteDTO clienteDTO) {
        return Optional.of(clienteGateway.save(this.montaCliente(clienteDTO)));
    }

    private ClienteEntity montaCliente(CadastroClienteDTO clienteDTO) {
        ClienteEntity cliente = new ClienteEntity();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setCpf(CpfUtils.removerPontuacoes(clienteDTO.getCpf()));

        return cliente;
    }
}
