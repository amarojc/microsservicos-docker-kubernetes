# Imagem utilizada
FROM adoptopenjdk/openjdk11:alpine
#cria a pasta /tmp no contêiner com os arquivos do projeto.
VOLUME /tmp
#Definindo o ambiente aonde será executado as instruções RUN, ENTRYPOINT, ADD, COPY e CMD
WORKDIR /app
# Faz uma cópia do arquivo jar como o nome app.jar
COPY target/product-api-0.0.1.jar /app/app.jar
#Porta
EXPOSE 8081
#Definindo o comando que será executado dentro do contêiner java -jar /app.jar
ENTRYPOINT ["java","-jar","app.jar"]
# Definindo a versão, descrição e o autor do projeto
LABEL version="0.0.1" description="Disponibilizando o product-api" maintainer="Jorge Amaro<inf.amaro.jc@gmail.com"