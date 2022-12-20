FROM adoptopenjdk/openjdk11:alpine
VOLUME /tmp
WORKDIR /app
COPY target/shopping-api-0.0.1.jar /app/app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","app.jar"]
LABEL version="0.0.1" description="Disponibilizando o shopping-api" maintainer="Jorge Amaro<inf.amaro.jc@gmail.com"