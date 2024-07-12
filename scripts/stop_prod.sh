#!/bin/bash

echo "Docker compose up (detach) for webserver_homepage"
docker compose --file /home/crypta/dockerContainers/webserver_homepage/docker-compose-fullstack.yml up -d
echo "###Done###"