FROM maven:3.9.2-eclipse-temurin-17

WORKDIR /app

COPY pom.xml /app/
COPY src /app/src

RUN mvn clean package

RUN cp /app/target/*.jar /app/app.jar
RUN rm -rf /app/target /app/src /app/pom.xml

ENTRYPOINT ["java", "-jar", "/app/app.jar"]