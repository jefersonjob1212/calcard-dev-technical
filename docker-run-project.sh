#!/bin/bash

docker run -it \
    --link postgres-calcard \
    -p 8080:8080 \
    jefersonjob/backend-calcar-app