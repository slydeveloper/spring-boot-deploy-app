#!/bin/bash

source ./.env
kubectl rollout history deployment.apps/$DEPLOYMENT_APP
