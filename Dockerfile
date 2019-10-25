FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/Stephhhh/mylibraries.git && cd mylibraries && git checkout cloud

FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app
COPY --from=clone /app/mylibraries /app
RUN RUN echo $(mvn clean install) && RUN echo $(ls -al)

FROM ibmjava:8-sfj
WORKDIR /app
COPY --from=build target/mylibrairies.jar /app.jar

ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]