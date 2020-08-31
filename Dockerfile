FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} speakercommand.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/speakercommand.jar"]