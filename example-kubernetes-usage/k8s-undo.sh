#!/bin/bash

source ./.env
kubectl rollout undo deployment.apps/$DEPLOYMENT_APP