FROM java:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} mylibrairies.jar
ENTRYPOINT ["java","-jar","/mylibrairies.jar"]