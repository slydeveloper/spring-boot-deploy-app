# build stage
FROM maven:3.6.1-jdk-11-slim AS build-stage

LABEL maintainer="sylwek.sokolowski@gmail.com"

COPY pom.xml /tmp/

COPY src /tmp/src/

WORKDIR /tmp/

RUN mvn clean package

# run stage
FROM openjdk:11.0.1-jre-slim as run-stage

LABEL maintainer="sylwek.sokolowski@gmail.com"

COPY --from=build-stage /tmp/target/*.jar /opt/app.jar

EXPOSE 8080

WORKDIR /opt

ENTRYPOINT ["java","-jar","app.jar"]