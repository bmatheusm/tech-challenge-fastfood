# tech-challenge-fastfood

## Visão Geral
Este repositório é dedicado ao **Tech Challenge**, um projeto interdisciplinar que integra conhecimentos de diversas disciplinas da fase de desenvolvimento. A atividade visa desenvolver um sistema de autoatendimento para uma lanchonete em expansão, com foco em melhorar a eficiência do atendimento e a satisfação dos clientes.

## Funcionalidades do Sistema

### Pedidos
- **Cadastro de Cliente**: O cliente pode se identificar via CPF, se cadastrar com nome e e-mail, ou fazer o pedido anonimamente.
- **Montagem de Combos**: O cliente pode montar seu pedido seguindo uma sequência opcional:
    - Lanche
    - Acompanhamento
    - Bebida
    - Sobremesa
- **Exibição de Produtos**: Em cada etapa, são exibidos o nome, a descrição e o preço dos produtos disponíveis.

### Pagamento
- **QR Code para Pagamento**: O sistema possuirá integração com QR Code do Mercado Pago para realizar o pagamento do pedido.

### Acompanhamento de Pedido
- **Status do Pedido**: Após confirmado e pago, o pedido é enviado à cozinha e o cliente pode acompanhar seu progresso nas etapas:
    - Recebido
    - Em preparação
    - Pronto
    - Finalizado

### Entrega
- **Notificação de Pronto para Retirada**: O sistema notifica o cliente quando o pedido está pronto para retirada, e o status é atualizado para finalizado após a retirada.

### Painel Administrativo
- **Gerenciamento de Clientes**: Identificação de clientes para campanhas promocionais.
- **Gerenciamento de Produtos e Categorias**: Configuração de produtos, nome, preço, descrição, e imagens. Categorias fixas:
    - Lanche
    - Acompanhamento
    - Bebida
    - Sobremesa
- **Acompanhamento de Pedidos**: Monitoramento dos pedidos em andamento e controle do tempo de espera.

## Entregáveis Fase 1

1. **Documentação do Sistema (DDD)**:
    - Documentação utilizando **Event Storming** para os fluxos:
        - Realização do pedido e pagamento
        - Preparação e entrega do pedido

2. **Aplicação Backend (Monolito)**:
    - Arquitetura hexagonal.
    - APIs (Swagger disponível para documentação):
        - Cadastro e identificação de cliente via CPF
        - CRUD de produtos e listagem por categoria
        - Envio de produtos escolhidos para a fila (fake checkout)
        - Listagem de pedidos
    - Banco de dados:
        - Organização e fila dos pedidos em banco de dados
    - **Docker**:
        - Dockerfile e docker-compose.yml configurados para execução e ambiente completo.

## Ambiente de Desenvolvimento

- **Java 21**
- **Maven**: Apache Maven 3.9.9
- **Banco de Dados**: PostgreSQL 17
    - Username: `postgres`
    - Password: `1234`

**Limitações de Infraestrutura para a POC**:
- 1 instância para o banco de dados
- 1 instância para execução da aplicação

---

# Passo a passo para execução

1. Após realizar o clone do projeto deve-se primeiro se atentar as versões do java e do maven suportadas pelo projeto de acordo com o tópico **Ambiente de Desenvolvimento** acima;
2. Posteriormente, basta rodar a seguinte sequência de scripts que seguem abaixo concatenados:
```shell
 kubectl apply -f k8s-infra/env/secret.yaml &
 kubectl apply -f k8s-infra/env/configmap.yaml &
 kubectl apply -f k8s-infra/db/postgresdb-statefulset.yaml &
 kubectl apply -f k8s-infra/db/postgresdb-service.yaml &
 kubectl apply -f k8s-infra/fastfoodapi/fastfoodapi-deployment.yaml &
 kubectl apply -f k8s-infra/fastfoodapi/fastfoodapi-service.yaml & 
 kubectl apply -f k8s-infra/hpa/fastfoodapi-hpa.yaml
```
3. A aplicação estará disponível em http://localhost:30001/fastfood/swagger-ui/index.html
4. Segue abaixo ordem indicada para o uso das APIs:
   1. cliente-controller (cadastro e busca de clientes)
   2. produto-controller (cadastro, atualização, busca e deleção de produtos
   3. pedido-controller (cadastro, atualização e busca de pedidos)
   4. pagamento-controller (pagamento e verificação)
   5. status-pagamento-webhook-controller (webhook)
