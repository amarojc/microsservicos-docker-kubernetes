# USER-API
User-api será responsável em manter os dados dos usuário da aplicação.
* [Padrão em camadas: Controller, Service e Repository.]
* [Entidades (model) que representam as tabelas do banco de dados.]
* [DTOs (Data Transfer Objects), responsáveis em receber e enviar informações entre os microsserviços e também para o front-end.]

# AUTENTICAÇÃO
Utilizado o padrão UUID (Universally Unique Identifier) para gerar a chave de acesso.
A chave gerada será utilizada para realizar a autenticação do usuário no serviço de compras.
Será criado um parametro na header para receber o valor da chave gerada para o usuário ser autenticado.


# CONFIGURAÇÃO
* [JavaSE 11]
* [Spring Boot 2.3.12.RELEASE]
* [spring-boot-starter-data-jpa para aplicação ter acesso ao banco de dados]
* [org.flywaydb gerenciamento de migrações do danco de dados, mantendo as mudanças dos modelos de dados versionadas e reproduzíveis.]
* [org.postgresql realizar a conexão com o PostgreSQL.]
* [spring-boot-starter-test dependências para realizar testes na aplicação.]
* [spring-boot-devtools utilizando o serviço de cache para melhorar a performance.]
* [application.properties configuração dos acessos ao banco de dados e a porta da aplicação.]
* [spring-boot-maven-plugin gerenciamento de dependências da api e construção das imagens do Docker.]


# CAMADA DE DADOS
Utilizado o conceição de migração de dados para a criação do banco de dados.
* [src/main/resources/db/migration/V1_Create_use_table.sql]
* [A versão (V1) indica a ordens dos scripts, assim sempre que subir a aplicação o Spring verificará se uma migração já foi aplicada no Banco de Dados.]

# TESTE
Utilizado o Postman para testar as requisições REST.
* [As coleções da api está disponível em ...]