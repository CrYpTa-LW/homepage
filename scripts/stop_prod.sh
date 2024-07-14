#!/bin/bash

if [ "$EUID" -ne 0 ]
  then echo "Please run as root"
  exit
fi

echo "Docker compose down for webserver_homepage"
docker compose --file /home/crypta/dockerContainers/webserver_homepage/docker-compose-fullstack.yml down
echo "###Done###"
