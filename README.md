# Microsserviços, Docker e Kubernetes
O projeto foi desenvolvido com base no Livro Back-end Java - Microsserviços, Spring Boot e Kubernetes (Autor: Eduardo Felipe Zambom Santana - 2021, Casa do Código) .

# Sobre o projeto

A aplicação é formada por três microsserviços que consistem em um serviço para cadastro de cliente (user-api), um para o cadastro de produtos (product-api) e um para compras (shopping-api). Para a execução das compras, os clientes e os produtos devem ser validados, o que requer a comunicação entre os serviços.

Foram utilizados o Docker para criação de contêineres, o Kubernetes, para criação de um cluster local que executam os contêineres Docker e o Postman para teste das requisições REST.


# Tecnologias utilizadas
## Linguagem
Java 11

## Implementação
- Autenticação com o padrão UUID (Universally Unique Identifier) 
- Tratamento de exceções personalizadas
- Validações com Validations
- Desenvolvimento em camadas usando padrão MVC
- Implementado perfil de Teste e Desenvolvimento
- Protocolo HTTP no padrão REST

## Frameworks
- Spring Boot
- Spring Data
- Spring Cloud
- Hibernate ORM

## Gerenciador de dependências e automatização de builds
- Maven

## Criação de contêineres
- Docker

## Criação do Cluster
- Kubernetes

## Testes API Rest
- Postman
- Utilizado também, o Kubernetes com um Cluster local rodando em background.

## Banco de Dados
- Postgres

## Camada de Dados
- Flywaydb
No gerenciamento de migrações do banco de dados, mantendo as mudanças dos modelos de dados versionadas e reproduzíveis.


# Autor
Jorge Amaro de Carvalho
