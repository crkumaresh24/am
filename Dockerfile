FROM openjdk:17-jdk-alpine
RUN addgroup -S platform-user && adduser -S platform-user -G platform-user
USER platform-user:platform-user
ARG JAR_FILE=build/libs/*SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]