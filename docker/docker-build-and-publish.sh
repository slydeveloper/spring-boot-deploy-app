#!/bin/bash

source docker-build.sh

docker push $DOCKER_IMAGE_NAME:latest

docker push $DOCKER_IMAGE_NAME:$DOCKER_IMAGE_VERSION