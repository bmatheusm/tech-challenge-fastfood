package com.techchallenge.fastfood.application.usecase;

import com.techchallenge.fastfood.adapters.driven.infra.entity.ClienteEntity;
import com.techchallenge.fastfood.application.port.in.CadastraCliente;
import com.techchallenge.fastfood.application.dto.CadastroClienteDTO;
import com.techchallenge.fastfood.domain.repository.ClienteRepository;
import com.techchallenge.fastfood.domain.utils.CpfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastraClienteImpl implements CadastraCliente {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Optional<ClienteEntity> cadastrarCliente(CadastroClienteDTO clienteDTO) {
        return Optional.of(clienteRepository.save(this.montaCliente(clienteDTO)));
    }

    private ClienteEntity montaCliente(CadastroClienteDTO clienteDTO) {
        ClienteEntity cliente = new ClienteEntity();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setCpf(CpfUtils.removerPontuacoes(clienteDTO.getCpf()));

        return cliente;
    }
}
