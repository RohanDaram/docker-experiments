# Dockerized Java Hello World

This project outlines the steps to create a Docker image that compiles and runs a simple Java application that prints "Docker Hello World!"


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

### 1. Clone the Repository.

```bash
cd path_of_your_choice
git clone https://github.com/RohanDaram/docker-experiments.git
```

### 2. Now navigate to the cloned repository.
```bash
cd docker-experiments
```
### 3. This repository organizes each project/experiment into its own folder. To explore this project, navigate to the docker-helloworld directory.
```bash
cd docker-helloworld
```
### 4. Navigating into the "docker-helloworld" directory should resemble the following project structure on your machine.
## Project Structure

```
.
├── src
│   └── com
│       └── rohan
│           └── docker
│               └── DockerHelloWorld.java  # Code that prints "Docker Hello World!"
├── Dockerfile   # Docker configuration file to build the image
└── README.md    # Read me file
```

### DockerHelloWorld.java

The Java application code that prints 'Docker Hello World!' to the console.

```java
package com.rohan.docker;

public class DockerHelloWorld {
	public static void main(String args[]) {
		System.out.println("Docker Hello World!");
	}
}
```

##### Next, we'll use the files in the docker-helloworld directory to build an image and then run a container from that image.
### 5. Building the Docker Image

Ensure you're in the docker-helloworld directory, then run the following command in your terminal to build the Docker image:

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
Use the docker build command with the -t (short for --tag) flag to assign a name to the image:
```bash
docker build -t docker-helloworld .
```
Note: Don’t leave out the trailing dot at the end of the build command — it's the little thing that makes everything work!

## Running the container
### 6. Run the container using the image tag you specified — it’s showtime for your Docker container!

The following command will run the container, provided you've specified the image tag correctly:
```bash
docker run docker-helloworld
```
Assuming the Docker magic happens (and the Docker gods are smiling upon you), you should see something like this:
```bash
Docker Hello World!
```

## The Dockerfile Revealed: Don’t Worry, It’s Not That Scary

```dockerfile
# Using the official OpenJDK:17 image as the base image for the hello world application
FROM openjdk:17

# Setting the working directory inside the container to docker-helloworld-app folder
WORKDIR /docker-helloworld-app

# Copying the java file from the local machine to the container's working directory
COPY src .

# Creating a 'bin' directory to store compiled Java class file.
RUN mkdir -p bin

# Compiling the hello world Java file into the 'bin' directory
RUN javac -d bin ./com/rohan/docker/DockerHelloWorld.java

# Setting the command to run the Java class
CMD ["java", "-cp", "bin", "com.rohan.docker.DockerHelloWorld"]
```

## Notes

- This project uses the OpenJDK 17 image, but feel free to swap in other OpenJDK versions if you prefer.
- You can explore additional images on ([Docker Hub](https://hub.docker.com/))
