FROM maven:3.8.1-openjdk-11-slim AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn clean -e -B package

FROM openjdk:11
WORKDIR /app
COPY --from=builder /app/target/explorando-marte-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "./explorando-marte-0.0.1-SNAPSHOT.jar"]