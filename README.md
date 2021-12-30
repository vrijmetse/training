## Deployment steps using docker-compose (Spring Boot + Postgresql)
1. build jar -> `mvn install`
2. build image -> `docker build -t pajak/training .`
3. deploy -> `docker-compose -f src/main/docker/app.yml up -d`

# Command to execute individual container
### postgres 
`docker run --name postgresql-container -p 5432:5432 -e POSTGRES_PASSWORD=training -e POSTGRES_USER=training -d postgres:12.3`

### Spring Boot app
`docker run -p 8080 pajak/training`

