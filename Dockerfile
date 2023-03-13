FROM openjdk:8
COPY target/blogit-1.0.jar blogit-1.0.jar
ENTRYPOINT ["java", "-jar", "/blogit-1.0.jar"]
