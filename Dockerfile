FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/product-management-0.0.1-SNAPSHOT.jar product-management.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","product-management.jar"]
