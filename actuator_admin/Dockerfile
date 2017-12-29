FROM openjdk:8-jre-alpine

WORKDIR /app

COPY /target/actuator_admin-0.0.1-SNAPSHOT.jar /app/actuator-admin.jar

EXPOSE 8080

CMD ["java", "-jar", "actuator-admin.jar"]

