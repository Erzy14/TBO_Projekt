FROM openjdk:8-jre
WORKDIR /app
COPY target/demo-app-1.0-SNAPSHOT.jar /app/demo-app.jar
RUN echo "This is an important file" > /tmp/important_file
EXPOSE 8080
CMD ["java", "-jar", "demo-app.jar"]
