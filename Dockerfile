FROM ubuntu:latest
LABEL authors="docker"
WORKDIR /app
COPY ./target/dockerME-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8181
CMD ["java", "-jar", "dockerME-0.0.1-SNAPSHOT.jar"]
ENTRYPOINT ["top", "-b"]