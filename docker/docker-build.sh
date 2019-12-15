#!/bin/bash

source .env

docker-compose down

echo Building image: $DOCKER_IMAGE_NAME

docker-compose build

docker rmi -f $(docker images | grep "<none>" | awk "{print \$3}")

docker tag $DOCKER_IMAGE_NAME:latest $DOCKER_IMAGE_NAME:$DOCKER_IMAGE_VERSION

docker images $DOCKER_IMAGE_NAME