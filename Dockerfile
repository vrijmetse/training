FROM adoptopenjdk:11-jre-hotspot
ADD target/pajak-training.jar pajak-training.jar
EXPOSE 8080:8080
ENTRYPOINT ["java","-jar","/pajak-training.jar"]