#Dockerfile contains all the commands with which
#Docker can build images reading the instructions.

FROM openjdk:11
RUN apt-get update && apt-get install -y maven
COPY . /project
RUN  cd /project && mvn package

WORKDIR /project

ENTRYPOINT ["java","-jar", "target/service-0.0.1-SNAPSHOT.jar"]




