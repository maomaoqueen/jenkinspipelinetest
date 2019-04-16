FROM 10.10.200.135:5000/java:openjdk-8-jre-alpine-withfontandtimezone
VOLUME /tmp
ADD target/pipeline-demo2.jar pipeline-demo2.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/pipeline-demo2.jar"]