# Trackify – Todo Management REST API

Trackify is a **RESTful backend API** for managing todo tasks and task lists.  
It is built using **Spring Boot** and follows a clean layered architecture including controllers, services, repositories, DTOs, mappers, and exception handling.

The application allows users to organize tasks into lists, track their status and priority, and manage them through a well-structured API.

---

# Features

- Create and manage **Task Lists**
- Create, update, and delete **Tasks**
- Assign **priority** and **status** to tasks
- Structured **DTO-based API responses**
- **Global exception handling**
- **Swagger/OpenAPI documentation**
- **PostgreSQL database**
- **Docker Compose** support for easy environment setup
- Clean **layered architecture**

---

# Tech Stack

## Backend
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate

## Database
- PostgreSQL

## Tools
- Docker
- Docker Compose
- Swagger / OpenAPI

---

# Project Architecture

The project follows a **layered architecture** to keep responsibilities clearly separated.
```
controllers
 ├── TaskListController
 ├── TasksController
 └── GlobalExceptionHandler

domain
 ├── dto
 │    ├── TaskDto
 │    ├── TaskListDto
 │    └── ErrorResponse
 │
 └── entities
      ├── Task
      ├── TaskList
      ├── TaskPriority
      └── TaskStatus

exceptions
 └── ResourceNotFoundException

mappers
 ├── TaskMapper
 ├── TaskListMapper
 └── impl
      ├── TaskMapperImpl
      └── TaskListMapperImpl

repositories
 ├── TaskRepository
 └── TaskListRepository

services
 ├── TaskService
 ├── TaskListService
 └── impl
      ├── TaskServiceImpl
      └── TaskListServiceImpl
```

---


# API Documentation

Swagger UI is available to explore and test the API.

```
http://localhost:8080/api/swagger-ui/index.html
```

---

# Running the Project

## 1. Clone the Repository

```bash
git clone https://github.com/abdalrhman002/trackify.git
cd trackify
```

---

## 2. Run with Docker Compose

Make sure **Docker** is installed.

```bash
docker-compose up -d
```

This will start the **PostgreSQL database** container.

---

## 3. Run the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or run the `TrackifyApplication` class from your IDE.

---

# API Endpoints

## Task Lists

Create a task list

```
POST /api/task-lists
```

Get all task lists

```
GET /api/task-lists
```

Get a task list by ID

```
GET /api/task-lists/{id}
```
Update a task list

```
PUT /api/task-lists/{id}
```

Delete a task list

```
DELETE /api/task-lists/{id}
```

---

## Tasks


Get all tasks of a task list
```
GET /api/task-lists/{taskListId}/tasks
```

Get a task by ID
```
GET /api/task-lists/{taskListId}/tasks/{taskId}
```

Create a task
```
POST /api/task-lists/{taskListId}/tasks
```

Update a task

```
PUT /api/task-lists/{taskListId}/tasks/{taskId}
```

Delete a task

```
DELETE /api/task-lists/{taskListId}/tasks/{taskId}
```

