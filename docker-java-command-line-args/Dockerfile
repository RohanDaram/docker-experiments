# Use the official OpenJDK 17 image as the base image for the container
FROM openjdk:17

# Setting the working directory inside the container to /app
WORKDIR /app

# Copy the built JAR file from the target directory on the host to the container's working directory (/app).
# Rename it to calculator.jar for simplicity
COPY ./target/*.jar ./calculator.jar

# Defines the entry point for the container. In this case the Java application is executed at the container startup.
ENTRYPOINT ["java", "-jar", "calculator.jar"]

# Provide default arguments to the application. These can be overridden at runtime if needed.
CMD ["+", "1", "2"]
