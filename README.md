## Requisitos

- Java 21
- Maven
- MySQL 8

## Configuracao do banco

Crie um schema chamado `base` no MySQL. Configure sua senha no arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.password=SUA_SENHA
```

## Como rodar

Acesse a pasta do projeto:

```
cd automanager
```

Execute:

```
.\mvnw spring-boot:run
```

O servidor sobe na porta `8080`. O banco e populado automaticamente na primeira execucao.

## Endpoints disponiveis

## Endpoints disponiveis

- GET /empresa
- GET /empresa/{id}
- POST /empresa/cadastro
- PUT /empresa/atualizar/{id}
- DELETE /empresa/excluir/{id}
- GET /usuario
- GET /usuario/{id}
- POST /usuario/cadastro
- PUT /usuario/atualizar/{id}
- DELETE /usuario/excluir/{id}
- GET /veiculo
- GET /veiculo/{id}
- POST /veiculo/cadastro
- PUT /veiculo/atualizar/{id}
- DELETE /veiculo/excluir/{id}
- GET /venda
- GET /venda/{id}
- POST /venda/cadastro
- PUT /venda/atualizar/{id}
- DELETE /venda/excluir/{id}
- GET /mercadoria
- GET /mercadoria/{id}
- POST /mercadoria/cadastro
- PUT /mercadoria/atualizar/{id}
- DELETE /mercadoria/excluir/{id}
- GET /servico
- GET /servico/{id}
- POST /servico/cadastro
- PUT /servico/atualizar/{id}
- DELETE /servico/excluir/{id}
