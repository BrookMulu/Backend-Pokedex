# Start with a base image for Java
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy your JAR file into the container
COPY target/backend_podedex-3.2.3.jar app.jar

# Expose the port on which your app will run
EXPOSE 8080


# Run the application with externalized environment variables
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]

