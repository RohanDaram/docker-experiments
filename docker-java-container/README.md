# Containerized JDK

This project demonstrates how to use a containerized JDK and Bind Mounts / Docker Volumes to compile and run Java classes on the Docker host using the JDK inside the container.

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
This repository organizes each project/experiment into its own folder. To explore this project, navigate to the docker-java-container directory.
```bash
cd docker-java-container
```
### 4. Project Structure
Navigating into the "docker-java-container" directory should resemble the following project structure on your machine.
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
    │                   ├── GuessTheNumber.class
    │                   ├── GuessTheNumber.java
    │                   ├── Hangman.class
    │                   ├── Hangman.java
    │                   ├── Magic8Ball.class
    │                   ├── Magic8Ball.java
    │                   ├── NumberPattern.class
    │                   ├── NumberPattern.java
    │                   ├── RockPaperScissors.class
    │                   └── RockPaperScissors.java
    └── test
        └── java
            └── com
                └── rohan
                    └── docker
                        └── AppTest.java
```

### 5. Java project with multiple class files
This project contains multiple standalone Java classes that can each be executed on their own without any dependencies. Refer to the project structure above for the name of each individual class.


##### Next, we'll compile and run the Java classes on the host using the OpenJDK 17 runtime within the container.

### 6. Building the Docker Image
Use the docker build command with the ```-t``` (short for ```--tag```) flag to assign a name to the image:
```bash
docker build -t docker-java-container .
```
<img width="1048" alt="building-image-with-tag-option" src="https://github.com/RohanDaram/docker-experiments/blob/main/docker-java-container/images/building-image-with-tag-option.png" />

Note: Don’t leave out the trailing dot at the end of the build command — it's the little thing that makes everything work!

### 7. Running a Docker Container with Bind Mounts
Binding a source folder on the host to a folder in the container using Docker bind mounts. Below are three different methods to do this.
- Method 1: Mapping src/main/java on the host to /app-source in the container using ```-v``` option
```bash
docker container run -v ./src/main/java:/app-source -it docker-java-container
```
<img width="1264" alt="bind-mount-with-v-option" src="https://github.com/RohanDaram/docker-experiments/blob/main/docker-java-container/images/bind-mount-with-v-option.png" />

- Method 2: Mapping src/main/java on the host to /app-source in the container using ```--mount```, ```src```, and ```dst``` flags.
```bash
docker container run --mount type=bind,src=./src/main/java,dst=/app-source -it docker-java-container
```
<img width="1430" alt="bind-mount-with-mount-option" src="https://github.com/RohanDaram/docker-experiments/blob/main/docker-java-container/images/bind-mount-with-mount-option.png" />

- Method 3:  Mapping src/main/java on the host to /app-source in the container using ```--mount```, ```source```, and ```target``` flags.
```bash
docker container run --mount type=bind,source=./src/main/java,target=/app-source -it docker-java-container
```
<img width="1432" alt="bind-mount-with-mount-option-v2" src="https://github.com/RohanDaram/docker-experiments/blob/main/docker-java-container/images/bind-mount-with-mount-option-v2.png" />


Assuming everything goes smoothly (with a bit of Docker magic), you should be able to run Java classes on the host machine using the JDK within the container:

Compiling the Java Classes

<img width="593" alt="compiling-class-files" src="https://github.com/RohanDaram/docker-experiments/blob/main/docker-java-container/images/compiling-class-files.png" />

Running a few of the Java Class Files

<img width="584" alt="running-java-hangman" src="https://github.com/RohanDaram/docker-experiments/blob/main/docker-java-container/images/running-java-hangman.png" />

<img width="548" alt="running-java-number-pattern" src="https://github.com/RohanDaram/docker-experiments/blob/main/docker-java-container/images/running-java-number-pattern.png" />



## The Dockerfile Revealed: Don’t Worry, It’s Not That Scary

```dockerfile
# Use the official OpenJDK 17 image as the base image for the container
FROM openjdk:17

# Setting the working directory inside the container to /app-source
WORKDIR /app-source

# Setting sh as the default command during container startup
CMD ["sh"]
```
### Key Points:
- *Compile and run Java classes with different JDK implementations and versions, without the need to install JDK or JRE on the host.*
## Notes

- This project uses the OpenJDK 17 image, but feel free to swap in other OpenJDK versions if you prefer.
- You can explore additional images on ([Docker Hub](https://hub.docker.com/))
