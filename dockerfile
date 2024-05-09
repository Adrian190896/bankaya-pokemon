FROM maven:3.8.4-openjdk-17-slim AS builder

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean package

FROM openjdk:17

COPY --from=builder /app/target/bankaya-pokemon-soap-0.0.1-SNAPSHOT.jar /app/bankaya-pokemon-soap-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/bankaya-pokemon-soap-0.0.1-SNAPSHOT.jar"]