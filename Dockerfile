FROM alpine/git
RUN echo ${ls -al}
WORKDIR /app
RUN git clone https://github.com/Stephhhh/mylibraries.git
RUN git checkout cloud
RUN echo ${ls -al}

FROM maven:3.5-jdk-8-alpine
WORKDIR /app
RUN echo $(mvn clean install)
RUN echo ${ls -al}

FROM ibmjava:8-sfj
WORKDIR /app
COPY target/mylibrairies.jar /app.jar

ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]