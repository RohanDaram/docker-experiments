#  Argument Passing to Java Programs in Docker Containers

This project demonstrates how to pass command-line arguments to a Java program running inside a Docker container by supplying arguments through the Docker run command.

## Prerequisites

- Docker installed on your computer ([Install Docker](https://docs.docker.com/get-docker/))
- Basic understanding of Docker and Java (optional, but recommended)
 
### How to install and verify Docker setup
- Follow the instructions in this ([link](https://docs.docker.com/get-docker/)) to install Docker
- Once Docker is installed, make sure that it is open and running on your machine
```bash
docker --version
```
# Getting started with this Repository

### 1. Clone the Repository
First, clone the repository to your local machine

```bash
cd path_of_your_choice
git clone https://github.com/RohanDaram/docker-experiments.git
```

### 2. Navigating to the Project Directory
Navigate to the directory consisting of all the docker experiments
```bash
cd docker-experiments
```
### 3. Navigating to a Specific Project Folder
This repository organizes each project/experiment into its own folder. To explore this project, navigate to the docker-java-command-line-args directory.
```bash
cd docker-java-command-line-args
```
### 4. Project Structure
Navigating into the "docker-java-command-line-args" directory should resemble the following project structure on your machine.
```
.
├── Dockerfile
├── pom.xml
├── src
├── main
│   └── java
│       └── com
│           └── rohan
│               └── docker
│                   ├── CommandLineCalculator.class
│                   └── CommandLineCalculator.java
└── test
    └── java
        └── com
            └── rohan
                └── docker
                    └── AppTest.java
```

### 5. Java project with a class that take command-line arguments
This project contains a Java class that accepts and processes command-line arguments. Refer to the project structure above for the name of the class.


##### Next, we'll execute the Java class file within the container by passing arguments through the Docker run command, utilizing the OpenJDK 17 runtime available in the container.

### 6. Building the Docker Image
Use the docker build command with the ```-t``` (short for ```--tag```) flag to assign a name to the image:
```bash
docker build -t docker-java-command-line-args .
```
<img width="1432" alt="building-image-with-tag-option" src="https://github.com/RohanDaram/docker-experiments/blob/main/docker-java-command-line-args/images/building-image-with-tag-option.png" />

Note: Don’t leave out the trailing dot at the end of the build command — it's the little thing that makes everything work!

### 7. Running a Docker Container with Arguments
Running the Docker container from the image we created, along with the desired command-line arguments to be passed to the Java program inside the container. 
If no arguments are provided, the default arguments specified in the ```CMD``` instruction of the Dockerfile will be used.
- Running the docker run command without any command-line arguments
```bash
docker container run commandline-args-calculator
```
<img width="1301" alt="docker-run-without-arguments" src="https://github.com/RohanDaram/docker-experiments/blob/main/docker-java-command-line-args/images/docker-run-without-arguments.png" />

- Running the docker run command with the arguments that you would like to pass on to the Java program within the container.
- Note: When using the multiplication operator, make sure to surround it with quotes as shown below:
```bash
docker container run commandline-args-calculator + 5 15
docker container run commandline-args-calculator - 20 5
docker container run commandline-args-calculator "*" 5 10
docker container run commandline-args-calculator / 10 5
```
<img width="1400" alt="docker-run-with-arguments" src="https://github.com/RohanDaram/docker-experiments/blob/main/docker-java-command-line-args/images/docker-run-with-arguments.png" />

## The Dockerfile Revealed: It's Simpler than it Seems!

```dockerfile
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
```
### Key Points:
- *Involves passing command-line arguments to a Java program in a Docker container using the Docker ```run``` command.*
## Notes

- This project uses the OpenJDK 17 image, but feel free to swap in other OpenJDK versions if you prefer.
- You can explore additional images on ([Docker Hub](https://hub.docker.com/))
