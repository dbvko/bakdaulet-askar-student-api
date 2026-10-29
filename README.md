# Bakdaulet Askar Student API

DevOps midterm project.

Student: Bakdaulet Askar

## Technologies
- Java 21
- Spring Boot
- Gradle
- PostgreSQL
- Docker and Docker Compose
- Git and GitHub
- Jenkins

## Features
- Create a student
- Retrieve all students
- Retrieve a student by ID
- Update a student
- Delete a student
- Validate student input
- Return 404 when a student does not exist

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | /api/students | Get all students |
| GET | /api/students/{id} | Get a student by ID |
| POST | /api/students | Create a student |
| PUT | /api/students/{id} | Update a student |
| DELETE | /api/students/{id} | Delete a student |
| GET | /actuator/health | Application health |

## Run with Docker Compose

1. Create a local `.env` file with `POSTGRES_USER` and `POSTGRES_PASSWORD`.
2. Run `docker compose up -d --build`.
3. Open `http://localhost:8080/actuator/health`.

Do not commit `.env` or other files containing credentials.

## Student JSON Example

    {
      "name": "Bakdaulet Askar",
      "email": "bakdaulet@example.com",
      "age": 21
    }

## Linux Script

The system report script is located at:
`scripts/Bakdaulet_Askar_system_report.sh`
