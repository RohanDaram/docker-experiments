# Dockerized Java Hello World

This project outlines the steps to create a Docker image that and runs a precompiled Java application (.class file) to print "Docker Hello World!" It provides a step-by-step guide to getting your Java application up and running within a Docker container.


## Prerequisites

- Docker installed on your computer ([Install Docker](https://docs.docker.com/get-docker/))
- Basic understanding of Docker and Java (optional, but recommended)
 
### How to install and verify Docker setup
- Follow the instructions in this ([link](https://docs.docker.com/get-docker/)) to install Docker
- Once Docker is installed, make sure that it is open and running on your machine
```bash
docker --version
```
# How to have fun and tinker with this repository

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
This repository organizes each project/experiment into its own folder. To explore this project, navigate to the docker-helloworld-using-java-class directory.
```bash
cd docker-helloworld-using-java-class
```
### 4. Project Structure
Navigating into the "docker-helloworld-using-java-class" directory should resemble the following project structure on your machine.
```
.
├── Dockerfile
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── rohan
    │               └── docker
    │                   └── DockerHelloWorld.java
    └── test
        └── java
            └── com
                └── rohan
                    └── docker
                        └── DockerHelloWorldTest.java
```

### 5. The Java Application
The java application of this project that prints "Docker Hello World!"

```java
package com.rohan.docker;

public class DockerHelloWorld 
{
    public static void main (String[] args )
    {
        System.out.println("Docker Hello World!");
    }
}
```

##### Next, we'll use the files in the docker-helloworld-java-class directory to build an image and then run a container from that image.
### 6. Building the Docker Image

Ensure you're in the docker-helloworld-using-java-class directory, then run the following command in your terminal to build the Docker image:

```bash
docker build .
```

Note: After building the image with the command above, you'll need to run it using its ID. To obtain the ID, run the following command:

```bash
docker image ls
```

Once you've obtained the image ID from the previous command, use the following docker run command to start the container:
```bash
docker container run <image-id>
```

#### Alternate way to build the image and run the container (using the image name)
Use the docker build command with the ```-t``` (short for ```--tag```) flag to assign a name to the image:
```bash
docker build -t docker-helloworld-using-java-class .
```

Note: Don’t leave out the trailing dot at the end of the build command — it's the little thing that makes everything work!

### 7. Running the Docker Container
Run the container using the image tag you specified — it’s showtime for your Docker container!
The following command will run the container, provided you've specified the image tag correctly:
```bash
docker container run docker-helloworld-using-java-class
```

Assuming the Docker magic happens (and the Docker gods are smiling upon you), you should see something like this:
```bash
Docker Hello World!
```

## The Dockerfile Revealed: Don’t Worry, It’s Not That Scary

```dockerfile
# Use the official OpenJDK 17 image as the base image for the application
FROM openjdk:17

# Copy the compiled class files from the local /target/classes directory to the /app-bin directory inside the container
COPY ./target/classes /app-bin

# Set the default command to run the HelloWorld Java application with the specified classpath
CMD ["java", "-cp", "app-bin", "com.rohan.docker.DockerHelloWorld"]
```
### Key Points / Changes compared to the previous project:
- The ```COPY``` command copies the compiled .class files from the local ./target/classes directory into the container’s /app-bin directory rather than compiling the source code within the container.
## Notes

- This project uses the OpenJDK 17 image, but feel free to swap in other OpenJDK versions if you prefer.
- You can explore additional images on ([Docker Hub](https://hub.docker.com/))
