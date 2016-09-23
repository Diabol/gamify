FROM openjdk:8

ADD target/gamify-1.0-SNAPSHOT.jar  /gamify-1.0-SNAPSHOT.jar

CMD java -jar /gamify-1.0-SNAPSHOT.jar server

EXPOSE 8080
