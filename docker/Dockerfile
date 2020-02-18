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

ARG BUILD_DATE
ARG BUILD_NAME
ARG BUILD_VERSION
ARG VCS_REF

LABEL org.label-schema.schema-version="1.0"
LABEL org.label-schema.build-date=$BUILD_DATE
LABEL org.label-schema.name=$BUILD_NAME
LABEL org.label-schema.description="Spring Boot Admin Docker"
LABEL org.label-schema.url="https://github.com/slydeveloper/spring-boot-admin-docker"
LABEL org.label-schema.vcs-url="https://github.com/slydeveloper/spring-boot-admin-docker"
LABEL org.label-schema.vcs-ref=$VCS_REF
LABEL org.label-schema.vendor="Sylwester Sokolowski"
LABEL org.label-schema.version=$BUILD_VERSION
LABEL org.label-schema.docker.cmd="docker run -d -p 1111:1111 --name spring-boot-admin slydeveloper/spring-boot-admin"

COPY --from=build-stage /tmp/target/*.jar /opt/app.jar
EXPOSE 8080
WORKDIR /opt

ENTRYPOINT ["java","-jar","app.jar"]