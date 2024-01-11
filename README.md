# API Controle Financeiro

Bem-vindo ao repositório da API Controle Financeiro, um projeto Java utilizando a versão 11, Maven como gerenciador de dependências e MySQL como banco de dados. Esta API oferece endpoints CRUD (Create, Read, Update, Delete) para Balanço, Categoria, Lançamento e Subcategoria.

## Visão Geral

A API Controle Financeiro foi desenvolvida para fornecer funcionalidades essenciais no gerenciamento financeiro pessoal. Com recursos robustos e uma arquitetura flexível, essa API é ideal para o acompanhamento de despesas, receitas e mais.

## Tecnologias Utilizadas

- Java 11
- Maven
- MySQL

## Configuração do Ambiente

Certifique-se de ter as seguintes ferramentas instaladas antes de executar a aplicação:

- Java JDK 11
- Maven
- MySQL Server

Além disso, é necessário configurar as credenciais do banco de dados no arquivo `application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/seu_nome_de_banco
spring.datasource.username=seu_nome_de_usuario
spring.datasource.password=sua_senha
```

## Como Executar

1. Clone o repositório: `git clone https://github.com/seu-usuario/api_controle_financeiro.git`
2. Navegue até o diretório do projeto: `cd api_controle_financeiro`
3. Execute a aplicação: `mvn spring-boot:run`

A API estará disponível em `http://localhost:8080`.

## Endpoints Disponíveis

- `GET /balancos`: Retorna todos os registros de balanço.
- `GET /categorias`: Retorna todos os registros de categoria.
- `GET /lancamentos`: Retorna todos os registros de lançamento.
- `GET /subcategorias`: Retorna todos os registros de subcategoria.
- `POST /balancos`: Registra um novo registro de balanço.
- `POST /categorias`: Registra um novo registro de categoria.
- `POST /lancamentos`: Registra um novo registro de lançamento.
- `POST /subcategorias`: Registra um novo registro de subcategoria.
- `PUT /balancos/{id}`: Atualiza um registro de balanço pelo ID.
- `PUT /categorias/{id}`: Atualiza um registro de categoria pelo ID.
- `PUT /lancamentos/{id}`: Atualiza um registro de lançamento pelo ID.
- `PUT /subcategorias/{id}`: Atualiza um registro de subcategoria pelo ID.
- `DELETE /balancos/{id}`: Exclui um registro de balanço pelo ID.
- `DELETE /categorias/{id}`: Exclui um registro de categoria pelo ID.
- `DELETE /lancamentos/{id}`: Exclui um registro de lançamento pelo ID.
- `DELETE /subcategorias/{id}`: Exclui um registro de subcategoria pelo ID.
