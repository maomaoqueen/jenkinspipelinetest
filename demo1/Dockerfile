FROM 10.10.200.135:5000/java:openjdk-8-jre-alpine-withfontandtimezone
VOLUME /tmp
ADD target/pipeline-demo1.jar pipeline-demo1.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/pipeline-demo1.jar"]