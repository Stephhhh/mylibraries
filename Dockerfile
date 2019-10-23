FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
COPY target/mylibrairies.jar /app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java $JAVA_OPTS","-jar","/app.jar"]