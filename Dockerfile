FROM openjdk:11
MAINTAINER Guilherme Fernandes
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME
COPY target/explorando-marte-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]