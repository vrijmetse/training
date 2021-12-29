FROM adoptopenjdk:11-jre-hotspot
ADD target/training-0.0.1-SNAPSHOT.jar training-0.0.1-SNAPSHOT.jar
EXPOSE 8080:8080
ENV DATABASE_HOST=localhost
ENV DATABASE_PORT=5432
ENTRYPOINT ["java","-jar","/training-0.0.1-SNAPSHOT.jar"]