
FROM openjdk:8
ADD target/mysql-docker.jar mysql-docker.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "mysql-docker.jar"]