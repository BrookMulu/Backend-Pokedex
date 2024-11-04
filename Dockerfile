# Start with a base image for Java
FROM openjdk:17-jdk-slim

# Add a volume for logs or other persistent data, if needed
VOLUME /tmp

# Set the working directory in the container
WORKDIR /app

# Copy your JAR file into the container
COPY target/backend_podedex.jar app.jar

# Expose the port on which your app will run
EXPOSE 8080

# Run the application with externalized environment variables
ENTRYPOINT ["java", "-jar", "app.jar"]
