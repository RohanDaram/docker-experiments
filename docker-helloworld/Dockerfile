# Using the official OpenJDK:17 image as the base image for my hello world application
FROM openjdk:17

# Setting the working directory inside the container to docker-helloworld-app folder
WORKDIR /docker-helloworld-app

# Copying my hello world java file from my local machine to the container's working directory
COPY src .

# Creating a 'bin' directory to store compiled Java class file.
RUN mkdir -p bin

# Compiling my hello world Java file into the 'bin' directory
RUN javac -d bin ./com/rohan/docker/DockerHelloWorld.java

# Setting the command to run my hello world java class
CMD ["java", "-cp", "bin", "com.rohan.docker.DockerHelloWorld"]
