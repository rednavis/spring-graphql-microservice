[![Build Status](https://travis-ci.com/rednavis/spring-graphql-microservice.svg?branch=master)](https://travis-ci.com/rednavis/spring-graphql-microservice)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/7d36295503574b40bb06bd4975dc40f6)](https://app.codacy.com/gh/rednavis/spring-graphql-microservice?utm_source=github.com&utm_medium=referral&utm_content=rednavis/spring-graphql-microservice&utm_campaign=Badge_Grade_Settings)
[![codecov](https://codecov.io/gh/rednavis/spring-graphql-microservice/branch/master/graph/badge.svg)](https://codecov.io/gh/rednavis/spring-graphql-microservice)

# spring-graphql-microservice
Demo of using Spring, GraphQL and microservices.

## Prerequisites
- OpenJDK 12.0.2 or higher
- Gradle 6.1.1 or higher

## How to build
```
$ ./gradlew clean bootJar jibDockerBuild
```

## How to lauch
After build run 
```
$ docker-compose up
```

## Heroku setup
* Login to your heroku account from CLI
```
$ heroku login
```
* Create a new application on Heroku
```
$ heroku apps:create
```
* Add a MongoDB database to your Heroku application with MongoLab. Note that your Heroku account must have a credit card attached in order to use free add-ons other than the PostgreSQL and MySQL add-ons.
```
$ heroku addons:create mongolab:sandbox
```
* Deploy code 
```
$ git push heroku master
```
* Look at your application logs to see what is happening behind the scenes.
```
$ heroku logs
```
* If your application deploys without timing out then open it as follows.
```
$ heroku open
```

## REST API exposed
### Eureka
* http://localhost:8761/

### Swagger
* http://localhost:8090/swagger-ui.html

### Test microservice status
* http://localhost:8090/employeeEntity/info
* http://localhost:8090/department/info
* http://localhost:8090/organization/info

### Generate mock data
* http://localhost:8090/mock

### GraphiQL
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
