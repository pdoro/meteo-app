FROM openjdk:8-jre-alpine

WORKDIR /app

COPY /target/meteo-app-0.0.1-SNAPSHOT.jar /app/meteo.jar

EXPOSE 8080

CMD ["java", "-jar", "meteo.jar"]
