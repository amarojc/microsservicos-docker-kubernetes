# Microsserviços, Docker e Kubernetes[^1]
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/amarojc/microsservicos-docker-kubernetes/blob/main/LICENSE) 

# Sobre o projeto

A aplicação é formada por três microsserviços que consistem em um serviço para cadastro de cliente (user-api), um para o cadastro de produtos (product-api) e um para compras (shopping-api). Para a execução das compras, os clientes e os produtos devem ser validados, o que requer a comunicação entre os serviços.

Foram utilizados o Docker para criação de contêineres, o Kubernetes, para criação de um cluster local que executa os contêineres Docker e o Postman para teste das requisições REST.

## Clone - SSH
git@github.com:amarojc/microsservicos-docker-kubernetes.git

# Tecnologias utilizadas
> Linguagem
- Java 11

> Implementação
- Autenticação com o padrão UUID (Universally Unique Identifier) 
- Tratamento de exceções personalizadas
- Validações com Validations
- Desenvolvimento em camadas usando padrão MVC
- Implementado perfil de Teste e Desenvolvimento
- Protocolo HTTP no padrão REST

> Frameworks
- Spring Boot
- Spring Data
- Spring Cloud
- Hibernate ORM

> Gerenciador de dependências e automatização de builds
- Maven



> Criação de contêineres
- Docker

Utilizado o plugin spotify para gerar a imagem do Docker. Necessário habilitá-lo para que o mesmo possa ser utilizado nos projetos.

Acesse a pasta do maven, no seu diretório, e procure pelo arquivo **settings.xml** . (tente em maven/conf/)

Dentro de &lt;settings&gt; &lt;pluginGroups&gt; adicione a tag:

```<pluginGroup>com.spotify</pluginGroup>```


As configurações de criação da imagem estão no arquivo Dockerfile de cada aplicação.
Para construir a imagem do Docker, basta executar os comandos direto do Maven na raiz:

Gerando o arquivo .jar

```mvn clean install```

Gerando a imagem do Docker

```mvn dockerfile:build```

**Executando os serviços em um contêiner Docker**

Utilizado o docker-compose para inicializar todos os serviços de uma só vez.

Abra um terminal e navegue até o caminho no diretório onde o arquivo foi criado ..\microsservicos-docker-kubernetes\backend,  e execute o comando: 

```docker-compose up```

Parando os serviços

```docker-compose down```

Para subir apenas um serviço específico, exemplo: user-api:

```docker-compose up user . ```

Gerando um contêiner usando a imagem **postgres** (Caso não tenha a imagem o Docker irá baixar direto do DockerHub (<https://hub.docker.com/>) e irá instalar direto no Docker local.

```docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres```

> Criação do Cluster
- Kubernetes

Criando os elementos configuration-postgres no Cluster:

Os arquivos de configurações estão no arquivo ./backend/**postgres-configuration**

Elementos | Comando
--------- | ------
Deployment |  ```kubectl create -f postgres-deployment.yaml``` 
Services |  ```kubectl create -f postgres-service.yaml``` 
Config Map |  ```kubectl create -f config-map.yaml``` 
User | ```kubectl create -f cluster-user.yaml``` 
Ingress | ```kubectl create -f ingress.yaml``` 

Criando os elementos das APIs no Cluster:

Os arquivos de configurações estão em: [./backend/user-api/deploy]  [./backend/product-api/deploy]  [./backend/shopping-api/deploy]

API | Elemento | Comando
----|--------- | ------
user-api | Deployment | ```kubectl create -f user-deploy.yaml``` 
product-api | Deployment | ```kubectl create -f product-deploy.yaml``` 
shopping-api | Deployment | ```kubectl create -f shopping-deploy.yaml``` 
user-api | Service | ```kubectl create -f user-service.yaml``` 
product-api | Service | ```kubectl create -f product-service.yaml``` 
shopping-api | Service | ```kubectl create -f shopping-service.yaml``` 
shopping-api | ConfiMap | ```kubectl create -f shopping-configmap.yaml``` 


> Testes API Rest
- Postman
- Utilizado também, o Kubernetes com um Cluster local rodando em background.

> Banco de Dados
- Postgres

> Gerenciamento do Banco de Dados
- PgAdmin

> Camada de Dados
- Flywaydb

Utilizado no gerenciamento de migrações do banco de dados, mantendo as mudanças dos modelos de dados versionadas e reproduzíveis.

# Autor
Jorge Amaro de Carvalho


[^1]: REFERÊNCIAS: Livro Back-end Java - Microsserviços, Spring Boot e Kubernetes de Eduardo Felipe Zambom Santana - 2021, Casa do Código / Alura. | <https://docs.nginx.com/> | <https://docs.nginx.com/nginx-ingress-controller/configuration/ingress-resources/basic-configuration/> | <https://kubernetes.io/docs/tasks/tools/install-kubectl-windows/>


