# Video-Recommend-Engine

A full-stack web application for users to search twitch resources (https://www.twitch.tv/) and get recommendations.

Language and tools: React, Ant Design, Java, Spring MVC, MySQL, Hibernate, deployed on Amazon EC2 with Docker.

**Video Demo: https://recordit.co/WKnMFFURHq**

## Features:

- Authentication: Login, Logout, Register.
- Custom Search: if name matched, customed game would return on the home screen.
- Popular games: Display top popular games on twitch website.
- Add favorite items: After login, user could add favorite item by clicking star.
- Recommendation: After login, the web could recommend similar items based on the favorite history.

## Frontend:

Frontend codes are stored in "/twitchfe" folder and are implemented with **React** library.

"utils.js" defines helper functions making http requests from client to server using **fetch API**.

All other UI-related components are built with **Ant Design library** (https://ant.design/).

## Backend:

Backend code diagram: https://drive.google.com/file/d/1Ye-WrWurGY4l-7HuWGUJR5SLfExgvuMF/view

Backend codes are stored in "/twitchbe" and use **Java** and **Spring MVC** framework.

- "/controller": handle features' incoming requests, manipulate data using the Model component and return responses.

- "/service": define features' business logics. Use **Apache HTTP Client library** to make RESTful requests from loacl services to Twitch API.

- "/dao": define favorite,login,register features' APIs to manipulate databases using **Hibernate**.

- "/entity"
  - "/entity/db": Use **Hibernate** to map three java class (Item/User/favorite_record) to three database tables.
  - "/entity/request": Payload that frontend sends to server.
  - "/entity/response": Payload that server sends back to frontend.

## Deploy on EC2:

- Step1: genearte client's build file

firstly Maven clean, then
```Java
npm run build
```
- Step2: Launch and connect to an EC2 instance (Ubuntu Server)

```
chmod 600 PRIVATE_KEY_LOCATION

ssh -i PRIVATE_KEY_LOCATION ubuntu@INSTANCE_IP
```

- Step3: Build war file (need to Maven clean first) and scp to EC2 instance

- Step4: Install Docker on EC2 instance

```
sudo apt-get update

sudo apt-get install \
    apt-transport-https \
    ca-certificates \
    curl \
    gnupg-agent \
    software-properties-common

curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

sudo add-apt-repository \
"deb [arch=amd64] https://download.docker.com/linux/ubuntu \
$(lsb_release -cs) \
stable"

sudo apt-get update

sudo apt-get install docker-ce docker-ce-cli containerd.io

```

Verify Docker is installed correctly

```
sudo docker run hello-world
```

- Step5: vim a dockerfile and build a docker image

```Linux
vim Dockerfile

FROM tomcat:9.0.65-jdk17                                   
MAINTAINER haijingzhang0601@gmail.com                                                                                                                        
COPY ./jupiter.war /usr/local/tomcat/webapps/ROOT.war       
EXPOSE 8080                                                            
CMD ["catalina.sh", "run"]


sudo docker build -t jupiter 
```
- Step6: Run docker container
```Linux
sudo docker run -d -p 80:8080 jupiter
```

check running containers:

```
sudo docker ps
```
