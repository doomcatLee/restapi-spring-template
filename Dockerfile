FROM openjdk:22-jdk
WORKDIR /app
COPY target/restapi-template-0.0.1.jar /app/restapi-template-0.0.1.jar
# Expose the port your app will run on (optional if you need to expose services)
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "restapi-template-0.0.1.jar"]