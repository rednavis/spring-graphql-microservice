# spring-graphql-microservice

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
* http://localhost:8090/employeeEntity/graphiql

Test query:
**findAll**
```
query {
  findAll {
    id
    organizationId
    departmentId
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
    organizationId
    departmentId
    name
    age
    city
    salary
  }
}
```

**findByOrganizationId**
```
query {
  findByOrganizationId(organizationId:"352a1566-1349-460c-835c-1245e2bc4cd8") {
    id
    organizationId
    departmentId
    name
    age
    city
    salary
  }
}
```

**findByDepartmentId**
```
query {
  findByDepartmentId(departmentId:"980bc49c-b59b-4ecc-86e7-7475a96de095") {
    id
    organizationId
    departmentId
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
    organizationId: "organizationId",
    departmentId: "departmentId",
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
    organizationId: "organizationId_Update",
    departmentId: "departmentId_Update",
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