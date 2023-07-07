FROM openjdk:17-jdk-slim

RUN mkdir /app
COPY ./app/build/libs/app-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
