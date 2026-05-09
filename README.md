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

- GET /empresa
- GET /empresa/{id}
- GET /usuario
- GET /usuario/{id}
- GET /veiculo
- GET /veiculo/{id}
- GET /venda
- GET /venda/{id}
- GET /mercadoria
- GET /mercadoria/{id}
- GET /servico
- GET /servico/{id}
