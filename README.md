# Users API Service

Exposes REST endpoints to perform CRUD Operations for Users

## Requirements To Run the Application

1. Java - 1.8.x

2. Maven - 3.x.x


## Steps to Setup

### Git command-line tool is required to run below command.

**1. Clone the application from this repository using below command**

```bash
git clone https://github.com/santhosh-maram/user-service.git
```

**2. Build and run the app using maven.**

Run this command from the root directory of the repository cloned in earlier step 1.

```bash
mvn package
java -jar target/user-service-1.0.0.jar
```

The App can also be run without packaging it using the below command -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /users
    
    POST /users
    
    GET /users/{id}
    
    PUT /users/{id}
    
    DELETE /users/{id}
    
    PATCH /users/{id}

You can test them using postman or any other rest client.

## Swagger UI

The app exposes API Documentation using Swagger UI

The Swagger UI can be accessed using the below URL 

<http://localhost:8080/swagger-ui/>

The Request/Response samples can be tested from this swagger page.