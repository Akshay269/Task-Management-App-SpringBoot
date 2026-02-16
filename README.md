
# Spring Boot Task Management App

A professional-grade Spring Boot application designed to track and manage daily tasks. This project demonstrates clean coding practices, layered architecture, and REST API development.

## 🚀 Features
- **Create Tasks:** Set titles, descriptions, due dates, and priority levels.
- **List Tasks:** View all tasks sorted by creation date.
- **Update Tasks:** Edit task details or mark them as complete.
- **Delete Tasks:** Remove tasks permanently.
- **Validation:** Robust input validation using Jakarta Validation.
- **Error Handling:** Standardized JSON error responses.

## 🛠️ Tech Stack
- **Language:** Java 25
- **Framework:** Spring Boot 4.0
- **Build Tool:** Apache Maven
- **Database:** H2 (In-Memory)
- **Containerization:** Docker (for UI testing)

## 📋 Prerequisites
- JDK 25
- Maven (or use the included `./mvnw` wrapper)
- Docker (to run the optional UI)

## 🛠️ Getting Started

1. **Clone the repository:**
   ```bash
   git clone <your-repo-url>
   cd task-app



### 🚀 API Reference

All API requests should be sent to the base path:

`POST/GET/PUT/DELETE` → `http://localhost:8080/api/v1/tasks`

---

#### 1. Create a New Task

Creates a task and sets its initial status to `OPEN`.

* **URL:** `/api/v1/tasks`
* **Method:** `POST`
* **Headers:** `Content-Type: application/json`

**Request Body:**

```json
{
  "title": "Walk the Dog",
  "description": "Take Rex to the park",
  "dueDate": "2026-12-31",
  "priority": "HIGH"
}

```

| Field | Type | Constraints |
| --- | --- | --- |
| `title` | String | Required. 1-255 characters. |
| `description` | String | Optional. Max 1000 characters. |
| `dueDate` | String (ISO) | Optional. Must be today or a future date. |
| `priority` | Enum | Required. `HIGH`, `MEDIUM`, or `LOW`. |

**Success Response:**

* **Code:** `201 Created`
* **Body:** Returns the created task object including its generated `id`.

---

#### 2. List All Tasks

Retrieves all tasks stored in the database.

* **URL:** `/api/v1/tasks`
* **Method:** `GET`

**Success Response:**

* **Code:** `200 OK`
* **Body:**

```json
[
  {
    "id": "550e8400-e29b-41d4-a716-446655440000",
    "title": "Walk the Dog",
    "description": "Take Rex to the park",
    "dueDate": "2026-12-31",
    "status": "OPEN",
    "priority": "HIGH"
  }
]

```

---

#### 3. Update a Task

Updates all fields of an existing task. Used for editing details or changing status (e.g., completing a task).

* **URL:** `/api/v1/tasks/{id}`
* **Method:** `PUT`
* **URL Params:** `id=[UUID]`

**Request Body:**

```json
{
  "title": "Walk the Dog",
  "description": "Rex needs a long walk",
  "dueDate": "2026-12-31",
  "status": "COMPLETE",
  "priority": "MEDIUM"
}

```

**Success Response:**

* **Code:** `200 OK`
* **Body:** Returns the updated task object.

---

#### 4. Delete a Task

Permanently removes a task from the system.

* **URL:** `/api/v1/tasks/{id}`
* **Method:** `DELETE`
* **URL Params:** `id=[UUID]`

**Success Response:**

* **Code:** `204 No Content`

---

### ⚠️ Error Responses

The API uses a standardized error format for validation failures and "Not Found" errors.

**Common Error Codes:**

* `400 Bad Request`: Validation failed (e.g., title too long, date in the past) or task ID does not exist.
* `500 Internal Server Error`: Unexpected server error.

**Error Body:**

```json
{
  "error": "Task with ID '550e8400-e29b-41d4-a716-446655440000' does not exist"
}

```

---

### 📋 Enums Data Values

| Enum Type | Allowed Values |
| --- | --- |
| **TaskStatus** | `OPEN`, `COMPLETE` |
| **TaskPriority** | `HIGH`, `MEDIUM`, `LOW` |
