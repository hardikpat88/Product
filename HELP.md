# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.3/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.3/gradle-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.5.3/reference/htmlsingle/#using-boot-devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.3/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.3/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.5.3/reference/htmlsingle/#production-ready)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* https://kubernetes.io/docs/reference/kubectl/cheatsheet/

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

Docker services:
Mysql: 
docker run --name dev-mysql -p 3306:3306 -v /opt/storage/mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root -d mysql:5.7

product-service:
docker build -t <USER_NAME>/product:1.2 .
docker login -user <USER_NAME>
docker push <USER_NAME>/product:1.2

network communication:
(1) docker network create product-mysql
(2) docker run --network product-mysql --name dev-mysql -p 3306:3306 -v /opt/storage/mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root -d mysql:5.7
(3) docker run --network product-mysql --name product -p 8080:8080 <USER_NAME>/product:1.2




===============================
Pushing a Docker container image to Docker Hub
To push an image to Docker Hub, you must first name your local image using your Docker Hub username and the repository name that you created through Docker Hub on the web.

You can add multiple images to a repository by adding a specific :<tag> to them (for example docs/base:testing). If it’s not specified, the tag defaults to latest.

Name your local images using one of these methods:

When you build them, using 
		docker build -t <hub-user>/<repo-name>[:<tag>]
By re-tagging an existing local image 
		docker tag <existing-image> <hub-user>/<repo-name>[:<tag>]
By using 
		docker commit <existing-container> <hub-user>/<repo-name>[:<tag>] to commit changes
Now you can push this repository to the registry designated by its name or tag.

 		docker push <hub-user>/<repo-name>:<tag>
The image is then uploaded and available for use.

================================

kubectl apply -f mysqldb-credentials.yml
kubectl apply -f mysqldb-root-credentials.yml
kubectl apply -f mysql-configmap.yml
kubectl apply -f mysql-deployment.yml
kubectl apply -f product-deployment.yml


Note: If you have used Node Port for service then u can access endpoint url from below command
minikube service <Service_name> --url
 ex. minikube service product-app --url





