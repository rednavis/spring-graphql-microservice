[![Build Status](https://travis-ci.com/rednavis/spring-webflux-swagger-demo.svg?branch=master)](https://travis-ci.com/rednavis/spring-webflux-swagger-demo)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/143579ed76ba41e88c2d0a1d8744a48d)](https://app.codacy.com/gh/rednavis/spring-webflux-swagger-demo?utm_source=github.com&utm_medium=referral&utm_content=rednavis/spring-webflux-swagger-demo&utm_campaign=Badge_Grade_Dashboard)
[![codecov](https://codecov.io/gh/rednavis/spring-webflux-swagger-demo/branch/master/graph/badge.svg)](https://codecov.io/gh/rednavis/spring-webflux-swagger-demo)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

# spring-graphql-microservice
Demo of using Spring, GraphQL and microservices.

## Prerequisites
- OpenJDK 12.0.2 or higher
- Gradle 6.1.1 or higher

## How to build
`./gradlew clean bootJar jibDockerBuild`

## How to lauch
After build run `docker-compose up`

# REST API exposed
## Eureka
* http://localhost:8761/

## Swagger
* http://localhost:8090/swagger-ui.html

## Test microservice status
* http://localhost:8090/employeeEntity/info
* http://localhost:8090/department/info
* http://localhost:8090/organization/info

## Generate mock data
* http://localhost:8090/mock

## GraphiQL
* http://localhost:8090/employee/graphiql

**findAll**
```
query {
  findAll {
    id
    name
    age
    city
    salary
  }
}
```

**findById**
```
query {
  findById(id: "5e3d2640908949394a94abfc") {
    id
    name
    age
    city
    salary
  }
}
```

**insert**
```
mutation {
  insert(employeeDto: {
    name: "Test Name",
    age: 999,
    city: "Test City",
    salary: 999999
  	}) 
  {
    id
  }
}
```

**save**
```
mutation {
  save(employeeDto: {
    id: "5e3d3362e7113164ae7029e8"
    name: "Test Name_Update",
    age: 999,
    city: "Test City_Update",
    salary: 999999
  	}) 
  {
    id
  }
}
```

**deleteById**
```
mutation {
  deleteById(id: "5e3d3362e7113164ae7029e8")
}
```

* http://localhost:8090/department/graphiql

**findAll**
```
query {
  findAll {
    id
    name
    employees {
      id
      name
      age
      city
      salary
    }
  }
}
```

**findById**
```
query {
  findById(id: "5e3d5a644534b56469a002ba") {
    id
    name
    employees {
      id
      name
      age
      city
      salary
    }
  }
}
```

* http://localhost:8090/organization/graphiql

**findAll**
```
query {
  findAll {
    id
    name
    departments {
      id
      name
    }
  }
}
```

**findById**
```
query {
  findById(id: "5e3d5a644534b56469a002ba") {
    id
    name
    departments {
      id
      name
    }
  }
}
```