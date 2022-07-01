FROM openjdk:8
EXPOSE 8080
#TODO
#USER
#DIR
#DYNAMIC VERSION
ADD target/jenkinstest-0.0.1-SNAPSHOT.jar jenkinstest-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/jenkinstest-0.0.1-SNAPSHOT.jar"]