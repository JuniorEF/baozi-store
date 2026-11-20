# Baozi Store — API REST (UNINTER)

**Aluno:** Edegar Foss Junior — **RU:** 5401581  
**Disciplina:** Desenvolvimento Web Back-End

## Tecnologias
Java 17, Spring Boot 3.5.7, Spring Web, Spring Data JPA, Hibernate e banco relacional H2 em arquivo.

## Executar
1. Instale JDK 17+ e Maven 3.9+.
2. Na pasta do projeto, execute `mvn spring-boot:run`.
3. API: `http://localhost:8080`.
4. Console H2: `http://localhost:8080/h2-console`  
   JDBC URL: `jdbc:h2:file:./data/baozistore` | usuário `sa` | senha em branco.

O banco é persistido na pasta `data/` e as tabelas são criadas/atualizadas pelo JPA.

## Endpoints
Para cada recurso (`clientes`, `produtos`, `pedidos`):
- `POST /api/{recurso}` — criar (201)
- `GET /api/{recurso}` — listar (200)
- `GET /api/{recurso}/{id}` — consultar por ID (200; 404 se ausente)
- `PUT /api/{recurso}/{id}` — atualizar (200)
- `DELETE /api/{recurso}/{id}` — excluir (204; 404 se ausente)

### JSON de exemplo — sequência recomendada no Postman
**Cliente** `POST /api/clientes`
```json
{"nome":"Edegar Foss Junior 5401581","clienteDesde":"2026-11-18"}
```
**Produto** `POST /api/produtos`
```json
{"nome":"Baozi tradicional","preco":8.50,"estoque":true}
```
**Pedido** `POST /api/pedidos` (use os IDs retornados nas duas primeiras respostas)
```json
{"clienteId":1,"produtoId":1,"quantidade":4}
```

## Postman
Importe `postman/Baozi-Store.postman_collection.json`. A coleção contém requisições para POST, GET geral, GET por ID, PUT e DELETE. Execute primeiro os POST e salve os IDs retornados nas variáveis `clienteId`, `produtoId` e `pedidoId` da coleção.

**Importante sobre a entrega:** a atividade exige capturas reais do Postman (criação de cada entidade, listagem geral, consulta por ID e exclusão). Elas não podem ser simuladas com segurança neste ambiente. Execute a API, faça as requisições e insira as capturas no relatório PDF antes de entregar.
