FROM adoptopenjdk/openjdk11:alpine
VOLUME /tmp
WORKDIR /app
COPY target/user-api-0.0.1.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
LABEL version="0.0.1" description="Disponibilizando o user-api" maintainer="Jorge Amaro<inf.amaro.jc@gmail.com>" 