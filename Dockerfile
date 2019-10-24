FROM maven:3.5-jdk-8-alpine
RUN echo $(mvn install)

FROM ibmjava:8-sfj
COPY target/mylibrairies.jar /app.jar

ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]