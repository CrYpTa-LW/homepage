#!/bin/bash

if [ "$EUID" -ne 0 ]
  then echo "Please run as root"
  exit
fi

echo "###Docker compose down for webserver_homepage###"
docker compose --file /home/crypta/dockerContainers/webserver_homepage/docker-compose-fullstack.yml down
echo "###Done###"

echo "###Building Backend###"
mvn -f /home/crypta/git/homepage/backend/pom.xml -Dmaven.test.skip clean install
echo "###Done###"

echo "###Building Frontend###"
npm --prefix /home/crypta/git/homepage/frontend run build
echo "###Done###"

echo "###Removing old files###"
rm /home/crypta/dockerContainers/webserver_homepage/backend-data/homepage-backend-prod.jar
rm -r /home/crypta/dockerContainers/webserver_homepage/frontend-data/build/
echo "###Done###"

echo "###Coping new files and rename"
cp /home/crypta/git/homepage/backend/target/homepage-0.0.1-SNAPSHOT.jar /home/crypta/dockerContainers/webserver_homepage/backend-data/
mv /home/crypta/dockerContainers/webserver_homepage/backend-data/homepage-0.0.1-SNAPSHOT.jar /home/crypta/dockerContainers/webserver_homepage/backend-data/homepage-backend-prod.jar
cp -r /home/crypta/git/homepage/frontend/build/ /home/crypta/dockerContainers/webserver_homepage/frontend-data/
echo "###Done###"

echo "Docker compose up (detach) for webserver_homepage"
docker compose --file /home/crypta/dockerContainers/webserver_homepage/docker-compose-fullstack.yml up -d
echo "###Done###"
