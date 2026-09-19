# GraphQL Student API with Spring Boot

## Overview
This project provides a GraphQL API using Spring Boot for managing students. It supports querying, creating, updating, and deleting students, plus pagination and filtering.

## Technologies
- Java 17
- Spring Boot
- Spring for GraphQL
- Spring Data JPA
- H2 (runtime)

## Run
Requirements:
- Java 17
- Maven

From project root:

1) Run with Spring Boot plugin:
   mvn spring-boot:run

2) Or build and run jar:
   mvn -DskipTests package
   java -jar target/student-0.0.1-SNAPSHOT.jar

## Endpoints
- GraphQL HTTP endpoint: http://localhost:8080/graphql
- GraphiQL / Playground (if UI dependency available):
  - http://localhost:8080/graphiql
  - http://localhost:8080/playground

## Example GraphQL operations
Query paged students:
```graphql
{
  getStudents(page:0,size:5,nameFilter:"Ann"){
    totalCount
    students{
      id
      name
      contact
    }
  }
}
```

Add a student:
```graphql
mutation {
  addStudent(input:{name:"Alice", contact:"12345"}){
    status
    studentId
    message
  }
}
```

Update a student:
```graphql
mutation {
  updateStudent(id:1, input:{name:"Alice Updated", contact:"6789"}){
    status
    studentId
    message
  }
}
```

Delete a student:
```graphql
mutation {
  deleteStudent(id:1){
    status
    studentId
    message
  }
}
```

## Notes
- If the GraphiQL UI does not appear, ensure Maven downloads the UI dependency and rebuild the app.
- Configure port and other properties in src/main/resources/application.properties.

## Author
Developed by Nitesh Rawal.
