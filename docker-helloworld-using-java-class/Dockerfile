# Use the official OpenJDK 17 image as the base image for the application
FROM openjdk:17

# Copy the compiled class files from the local /target/classes directory to the /app-bin directory inside the container
COPY ./target/classes /app-bin

# Set the default command to run the HelloWorld Java application with the specified classpath
CMD ["java", "-cp", "app-bin", "com.rohan.docker.DockerHelloWorld"]