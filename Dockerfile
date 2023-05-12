FROM openjdk:11
COPY  target/kubes.jar kubes.jar
ENTRYPOINT ["java","-jar","/kubes.jar"]