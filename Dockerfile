FROM ibmjava:8-sfj
VOLUME /tmp
EXPOSE 8080

RUN echo $(find / -name *ibra*)

COPY target/mylibrairies.jar /app.jar

ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]