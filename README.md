# GraphQL Student API with Spring Boot

## Overview

This project provides a GraphQL API using Spring Boot for managing students. It includes functionalities to fetch all students and add a new student.

## Technologies Used

- Java 17
- Spring Boot
- GraphQL (GraphQL Java Tools, GraphQL Spring Boot Starter)
- H2 Database (or any preferred database)
- JPA (Spring Data JPA)

## Features

1. **Get Students API**

   - **Endpoint:** `/graphql`
   - **Method:** Query
   - **Input:** None
   - **Output:** List of all students

2. **Add Student API**

   - **Endpoint:** `/graphql`
   - **Method:** Mutation
   - **Input:** Student details (name, contact)
   - **Output:** Response with status and generated student ID

## Setup & Installation

1. Clone the repository:
   ```bash
   git clone <repo-url>
   cd graphql-student-api
   ```
2. Build and run the application:
   ```bash
   mvn spring-boot:run
   ```
3. Access GraphQL Playground at:
   ```
   http://localhost:8080/graphql
   ```

## GraphQL Schema

### Query to Get All Students

```graphql
query {
  getStudents {
    id
    name
    contact
  }
}
```

### Mutation to Add a Student

```graphql
mutation {
  addStudent(name: "nitesh", contact: "1234567890") {
    status
    studentId
  }
}
```

## Response Format

### Get Students API Response

```json
{
  "data": {
    "getStudents": [
      {
        "id": "1",
        "name": "nitesh",
        "contact": "1234567890"
      }
    ]
  }
}
```

### Add Student API Response

```json
{
  "data": {
    "addStudent": {
      "status": "Success",
      "studentId": "2"
    }
  }
}
```

## Author

Developed by Nitesh Rawal.

