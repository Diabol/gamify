FROM dockerfile/java:openjdk-7-jdk

ADD target/gamify-1.0-SNAPSHOT.jar  /data/gamify-1.0-SNAPSHOT.jar

CMD java -jar gamify-1.0-SNAPSHOT.jar server

EXPOSE 8080
