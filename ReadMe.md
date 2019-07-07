
# Microservices with Cloud Tools 

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


### Usage

To use this environment you need access privileges;
- docker network to host network by ip
- host network to docker network by ip

Example, access to host from docker network (Linux/RedHat)

```console
firewall-cmd --permanent --zone=public --add-rich-rule='rule family=ipv4 source address=172.24.0.0/16 accept' 
firewall-cmd --reload
```
Or, you can simply add [route](http://man7.org/linux/man-pages/man8/route.8.html) definitions.

#### Build
```console
mvn clean install -P docker 
mvn jib:dockerBuild
```

#### Run & Stop
```console
cd ./docker-compose
docker-compose up 
docker-compose down --remove-orphans
```

You can also fire up one of the services from your ide or cli. Service will automatically join consul catalog and dynamically configured for traefik.

#### Swagger

[http://localhost/city-service/swagger-ui.html](http://localhost/city-service/swagger-ui.html)

[http://localhost/country-service/swagger-ui.html](http://localhost/country-service/swagger-ui.html)

