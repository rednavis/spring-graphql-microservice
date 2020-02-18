# spring-graphql-microservice

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/7d36295503574b40bb06bd4975dc40f6)](https://app.codacy.com/gh/rednavis/spring-graphql-microservice?utm_source=github.com&utm_medium=referral&utm_content=rednavis/spring-graphql-microservice&utm_campaign=Badge_Grade_Settings)

## Build
1. `./gradlew clean bootJar jibDockerBuild`
2. `docker-compose up` 

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

Test query:

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

Test query:

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

Test query:

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