package com.techchallenge.fastfood.adapters.driven.http;

import com.techchallenge.fastfood.adapters.driven.infra.entity.PagamentoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Slf4j
public class PagamentoHttpClient {
    private final WebClient webClient;

    public PagamentoHttpClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public void enviaPagamento(PagamentoEntity pagamento) {
        try {
            webClient.post().uri("/fastfood/webhook/status-pagamento")
                    .bodyValue(pagamento)
                    .retrieve()
                    .bodyToMono(String.class)
                    .doOnSuccess(response -> log.info("Resposta da aplicação de pagamento: {}", response))
                    .doOnError(error -> log.error("Erro ao enviar notificação: {}", error.getMessage()))
                    .block();
        } catch (Exception e) {
            log.error("Erro na comunicação com a aplicação externa: {}", e.getMessage());
            throw e;
        }
    }
}
