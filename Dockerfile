FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

WORKDIR /app

COPY . .
RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

WORKDIR /app

COPY --from=build /target/todolist-1.0.0.jar app.jar

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://isabelle.db.elephantsql.com:5432/lawfzdxy
ENV SPRING_DATASOURCE_USERNAME=lawfzdxy
ENV SPRING_DATASOURCE_PASSWORD=3T5Xs3u71llgJ5jaaIzuJN4g0JPunYJF

ENTRYPOINT ["java", "-jar", "app.jar"]