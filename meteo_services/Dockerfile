FROM openjdk:8-jre-alpine

WORKDIR /app

COPY /target/external_meteo_service-1.0-SNAPSHOT.jar /app/external-meteo.jar

EXPOSE 8080

CMD ["java", "-jar", "external-meteo.jar"]
