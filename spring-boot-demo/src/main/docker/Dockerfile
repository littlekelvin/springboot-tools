FROM openjdk:8-jdk-alpine

ENV APP_HOME=/usr/app

COPY ./spring-boot-demo-1.0.0.jar ${APP_HOME}/app.jar

RUN chmod 777 ${APP_HOME}/app.jar
RUN cd ${APP_HOME} && ls -a -l

EXPOSE 8090/tcp

WORKDIR ${APP_HOME}

ENTRYPOINT ["java","-jar","app.jar"]