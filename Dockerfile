FROM openjdk:11
COPY target/OpenKart-0.0.1-SNAPSHOT.war OpenKart-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java", "-jar", "/OpenKart-0.0.1-SNAPSHOT.war"]