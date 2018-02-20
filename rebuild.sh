#! /usr/bin/env bash

mvn -f meteo/pom.xml clean package -Dmaven.test.skip=true
#mvn -f meteo_services/pom.xml clean package -Dmaven.test.skip=true
# mvn -f actuator_admin/pom.xml clean package -Dmaven.test.skip=true

docker-compose build
