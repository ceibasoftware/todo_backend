FROM openjdk:8-jdk-alpine

VOLUME /tmp
RUN adduser --disabled-password --gecos '' app
WORKDIR /home/app

COPY ./build/libs/todo-demo-0.1.0.jar /home/app/todo-demo-0.1.0.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/app/todo-demo-0.1.0.jar"]