FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/mylibrairies.jar
ADD ${JAR_FILE} mylibrairies.jar
ENTRYPOINT ["java","-jar","/mylibrairies.jar"]