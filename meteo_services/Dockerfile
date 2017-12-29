FROM openjdk:8-jre-alpine

WORKDIR /app

COPY /target/remote_meteo_service-1.0-SNAPSHOT.jar /app/remote-meteo.jar

EXPOSE 8080

CMD ["java", "-jar", "remote-meteo.jar"]
