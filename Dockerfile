FROM openjdk:8
COPY target/OpenKart-0.0.1-SNAPSHOT.jar OpenKart-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/OpenKart-0.0.1-SNAPSHOT.jar"]
