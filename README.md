# Spring Boot on Docker connecting to MySQL Docker container

1. Use MySQL Image published by Docker Hub (https://hub.docker.com/_/mysql/)

Command to run the mysql container
`docker run --name iqbusiness-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=iqbusiness_db -e MYSQL_USER=sa -e MYSQL_PASSWORD=password -d mysql:5.7,34`

2. In the Spring Boot Application, use the same container name of the mysql instance in the application.properties
`spring.datasource.url = jdbc:mysql://iqbusiness-mysql:3306/iqbusiness_db`

3. Create a `Dockerfile` for creating a docker image from the Spring Boot Application
FROM openjdk:8
ADD target/mysql-docker.jar mysql.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "mysql-docker.jar"]`

4. Using the Dockerfile create the Docker image.
From the directory of Dockerfile - `docker build . -t mysql-docker`

5. Run the Docker image (mysql-docker) created in #4.
`docker build . -t mysql-docker`

## Useful Docker commands
- `docker images`
- `docker container ls`
- `docker logs <container_name>`
- `docker container rm <container_name`
- `docker image rm <image_name`
