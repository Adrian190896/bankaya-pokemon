FROM openjdk:17

COPY target/bankaya-pokemon-soap-0.0.1-SNAPSHOT.jar /app/bankaya-pokemon-soap-0.0.1-SNAPSHOT.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "bankaya-pokemon-soap-0.0.1-SNAPSHOT.jar"]