# Java Spring Boot To-Do Application

This is a simple to-do application built using Java Spring Boot framework. It provides basic CRUD (Create, Read, Update, Delete) operations for managing a to-do list. The application follows the RESTful API architecture and uses an in-memory H2 database for data persistence.

<img width="955" alt="TodoApplication_TodoListPage" src="https://github.com/pinaki1010/TodoApplication/assets/42297763/c4fb7409-a8f2-4147-b560-2625a2eab78e">

## Prerequisites

To run this application, you need to have the following installed:

- Java Development Kit (JDK) 11 or above
- Maven (for dependency management)

## Getting Started

Follow the steps below to get the application up and running on your local machine:

1. Clone the repository:

   ```
   git clone https://github.com/your-username/java-spring-boot-todo.git
   ```

2. Navigate to the project directory:

   ```
   cd java-spring-boot-todo
   ```

3. Build the application using Maven:

   ```
   mvn clean install
   ```

4. Run the application:

   ```
   mvn spring-boot:run
   ```

The application will start running on `http://localhost:8080`.

## API Endpoints

The following API endpoints are available:

### Get all tasks

```
GET /api/tasks
```

This endpoint retrieves all tasks in the to-do list.

### Get a specific task

```
GET /api/tasks/{id}
```

This endpoint retrieves a specific task by its ID.

### Create a new task

```
POST /api/tasks
```

This endpoint creates a new task. The task details should be provided in the request body as JSON.

### Update a task

```
PUT /api/tasks/{id}
```

This endpoint updates an existing task identified by its ID. The updated task details should be provided in the request body as JSON.

### Delete a task

```
DELETE /api/tasks/{id}
```

This endpoint deletes a task from the to-do list.

## Data Model

The application uses the following data model for tasks:

```java
public class Task {
    private Long id;
    private String title;
    private String description;
    // Other fields and getters/setters
}
```
<img width="949" alt="TodoApplication_UpdatePage" src="https://github.com/pinaki1010/TodoApplication/assets/42297763/94409263-b15c-4518-b01f-dea16252af6c">

## Configuration

The application's configuration can be found in the `application.properties` file. You can modify this file to change the database configuration, server port, etc.

## Dependencies

The main dependencies used in this project are:

- Spring Boot Starter Web: For building web applications using Spring MVC.
- Spring Data JPA: For working with the database and data persistence.
- H2 Database: An in-memory database for development and testing purposes.
- Maven: For dependency management and build automation.

## Contributing

Contributions to this project are welcome. You can submit bug reports, feature requests, or pull requests through the project's GitHub repository.

## License

This project is licensed under the [MIT License](LICENSE).

---

That's it! You now have a basic understanding of the Java Spring Boot To-Do Application. Feel free to explore and extend the application based on your requirements.
