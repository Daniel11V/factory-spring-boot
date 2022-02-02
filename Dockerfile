FROM openjdk:slim
ADD ./build/libs/patterns-factory-0.0.1-SNAPSHOT.jar patterns-factory
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo-coderhouse:27017/coderhouse", "-Djava.security.egd=file:/dev/./urandom","-jar","patterns-factory"]
