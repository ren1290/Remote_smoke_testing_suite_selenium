# Use the official OpenJDK base image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot application JAR file into the container
COPY target/Form-0.0.1-SNAPSHOT.war .

# Expose the port your Spring Boot application is running on (e.g., 8080)
EXPOSE 8080

# Command to run your Spring Boot application
CMD ["java", "-jar", "Form-0.0.1-SNAPSHOT.war"]
