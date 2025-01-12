FROM openjdk:21-jdk-slim

LABEL authors="ATHARVA PARDESHI"

WORKDIR /app

COPY target/*.jar  app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]