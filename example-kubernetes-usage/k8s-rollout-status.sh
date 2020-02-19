#!/bin/bash

source ./.env
kubectl rollout status deployment.apps/$DEPLOYMENT_APP
