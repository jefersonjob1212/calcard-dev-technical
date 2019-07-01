#!/bin/bash

docker run -d \
    --name postgres-calcard \
    -e POSTGRESD_DB=calcard \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=postgres \
    -p 5432:5432 \
    postgres:9.5