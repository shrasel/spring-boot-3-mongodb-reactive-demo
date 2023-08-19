# Spring Boot 3 with MongoDB Reactive Example

This project demonstrates how to build a simple Spring Boot 3 application using MongoDB Reactive for asynchronous database interactions.

## Prerequisites

- Java 17 or later
- Spring Boot 3.1.2
- Maven
- MongoDB

## Getting Started

1. Clone the repository:

   ```sh
   git clone https://github.com/shrasel/spring-boot-3-mongodb-reactive.git
   cd spring-boot-3-mongodb-reactive

### Configure MongoDB: ###

Make sure you have a MongoDB server running locally or update the MongoDB connection settings in **src/main/resources/application.yml**

### Build and run the application: ###

```sh
mvn spring-boot:run
```

Access the application:

The application will be available at http://localhost:8080. You can use tools like curl, Postman, or your web browser to interact with the API.

### **API Endpoints** ###
The following API endpoints are available:

- POST /students: Create a new student.
- GET /students: Retrieve all students.
- GET /students/{id}: Retrieve a student by their ID.
- GET /students/findByAge/{age}: Retrieve students by age.
- GET /students/findByFirstName/{firstName}: Retrieve a student by first name.
- PUT /students/{id}: Update a student by their ID.
- DELETE /students/{id}: Delete a student by their ID.
### Technologies Used ###
- Spring Boot 3
- Spring WebFlux (Reactive)
- Spring Data MongoDB Reactive
- MongoDB
### Contributing ###
Contributions are welcome! If you find any issues or want to enhance the project, feel free to submit a pull request.