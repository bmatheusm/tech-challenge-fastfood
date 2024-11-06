package com.techchallenge.fastfood.application.usecase.cliente;

import com.techchallenge.fastfood.adapters.driven.infra.entity.ClienteEntity;
import com.techchallenge.fastfood.application.port.in.cliente.BuscaClientePorCpf;
import com.techchallenge.fastfood.domain.repository.ClienteRepository;
import com.techchallenge.fastfood.domain.utils.CpfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscaClientePorCpfImpl implements BuscaClientePorCpf {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Optional<ClienteEntity> buscaPorCpf(String cpf) {
        return clienteRepository.findByCpf(CpfUtils.removerPontuacoes(cpf));
    }
}
