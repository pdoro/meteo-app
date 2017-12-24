#! /usr/bin/env bash

mvn clean package -Dmaven.test.skip=true
mvn clean -f ../remote_meteo_service/pom.xml package -Dmaven.test.skip=true
mvn clean -f ../actuator_admin/pom.xml package -Dmaven.test.skip=true

docker-compose build
