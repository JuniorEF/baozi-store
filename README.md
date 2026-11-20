# Baozi Store — API REST

**Projeto acadêmico de Desenvolvimento Web Back-End — 2026**

**Aluno:** Edegar Foss Junior  
**RU:** 5401581

## Sobre o projeto

A Baozi Store é uma API REST desenvolvida em Java com Spring Boot para gerenciar produtos, clientes e pedidos de uma loja fictícia especializada em Baozi.

A aplicação permite cadastrar, consultar, atualizar e excluir registros, utilizando JSON para comunicação e banco de dados H2 para persistência.

## Tecnologias utilizadas

- Java 17
- Spring Boot 3.5.7
- Spring Web
- Spring Data JPA
- Hibernate
- Banco de dados H2
- Maven
- Postman

## Configuração e execução

1. Instale o Java 17.
2. Abra o terminal na pasta do projeto.
3. Execute:

```bash
mvn spring-boot:run
```

A aplicação será iniciada na porta **8081**.

Endereço-base:

```text
http://localhost:8081
```

Console do banco H2:

```text
http://localhost:8081/h2-console
```

Configuração JDBC:

```text
jdbc:h2:file:./data/baozistore
```

## Endpoints da API

### Produtos

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/api/produtos` | Cadastrar produto |
| GET | `/api/produtos` | Listar produtos |
| GET | `/api/produtos/{id}` | Consultar produto |
| PUT | `/api/produtos/{id}` | Atualizar produto |
| DELETE | `/api/produtos/{id}` | Excluir produto |

Exemplo de cadastro:

```json
{
  "nome": "Baozi Tradicional",
  "preco": 15.90,
  "estoque": 50
}
```

### Clientes

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/api/clientes` | Cadastrar cliente |
| GET | `/api/clientes` | Listar clientes |
| GET | `/api/clientes/{id}` | Consultar cliente |
| PUT | `/api/clientes/{id}` | Atualizar cliente |
| DELETE | `/api/clientes/{id}` | Excluir cliente |

Exemplo de cadastro:

```json
{
  "nome": "Edegar Foss Junior",
  "clienteDesde": "2026-11-18"
}
```

### Pedidos

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/api/pedidos` | Cadastrar pedido |
| GET | `/api/pedidos` | Listar pedidos |
| GET | `/api/pedidos/{id}` | Consultar pedido |
| PUT | `/api/pedidos/{id}` | Atualizar pedido |
| DELETE | `/api/pedidos/{id}` | Excluir pedido |

Exemplo de cadastro:

```json
{
  "clienteId": 2,
  "produtoId": 37,
  "quantidade": 3
}
```

## Estrutura do projeto

```text
baozi-store/
├── src/
│   └── main/
│       ├── java/br/com/baozistore/
│       │   ├── controller/
│       │   ├── exception/
│       │   ├── model/
│       │   └── repository/
│       └── resources/
│           └── application.properties
├── postman/
├── Evidencias_Postman/
├── pom.xml
└── README.md
```

## Testes

Os endpoints foram testados utilizando o Postman, incluindo operações de cadastro, consulta, atualização e exclusão.

As capturas de tela dos testes estão disponíveis na pasta `Evidencias_Postman`.

## Autor

**Edegar Foss Junior — RU 5401581**

Projeto acadêmico desenvolvido para a disciplina de Desenvolvimento Web Back-End.
