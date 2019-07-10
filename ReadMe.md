
# Microservices with Cloud Tools - Hybrid Environment

### Technologies

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Cloud Config Server](https://spring.io/projects/spring-cloud-config)
- [Spring Cloud OpenFeign](https://spring.io/projects/spring-cloud-openfeign)
- [Spring Cloud Consul](https://spring.io/projects/spring-cloud-consul)
- [Consul - Service Discovery](https://www.consul.io/)
- [Traefik](https://traefik.io/)
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- [Swagger2](https://github.com/springfox/springfox/springfox-swagger2), [Swagger-UI](https://github.com/springfox/springfox/springfox-ui) 
- [Spring Boot Admin](http://codecentric.github.io/spring-boot-admin/current/)

### Purpose

The host networking driver only works on Linux hosts, and is not supported on Docker Desktop for Windows.
To achieve inter-service communication between host network and docker network we need to setup a hybrid development environment for microservices with cloud tools. 

### Scenario
- Run some services with docker-compose
- Run config-server and run/debug one or more services on your IDE.
- All services automatically join consul catalog and are dynamically configured on traefik.
- Handles inter-service communication via opeinfeign & service discovery
 

### Usage

To use this environment you need access privileges;
- docker network to host network by ip
- host network to docker network by ip

##### Windows:
By default, host can not access containers' ip addresses on Windows platform.
 
Alter route table with:
```console
route /P add  172.24.0.0 MASK 255.255.0.0 10.0.75.2
```
##### Linux:
By default, containers can not access host ip address on Linux platform.
 
Access to host from docker network (Linux/RedHat)

```console
firewall-cmd --permanent --zone=public --add-rich-rule='rule family=ipv4 source address=172.24.0.0/16 accept' 
firewall-cmd --reload
```
Or, you can add [route](http://man7.org/linux/man-pages/man8/route.8.html) definition.

#### Build
```console
mvn clean install 
```

#### Dockerize
```console
mvn jib:dockerBuild
```

#### Run & Stop
```console
cd ./docker-compose
docker-compose up 
docker-compose down --remove-orphans
```

#### Spring Boot Admin

[http://localhost/admin-server](http://localhost/admin-server)

#### Swagger

[http://localhost/city-service/swagger-ui.html](http://localhost/city-service/swagger-ui.html)

[http://localhost/country-service/swagger-ui.html](http://localhost/country-service/swagger-ui.html)

