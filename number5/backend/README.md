# Parking Ticket System API Documentation

## Overview

Parking Ticket System API is a backend service for managing vehicle check-in and check-out operations in a parking system. It provides endpoints to register vehicles, retrieve ticket details, and process check-outs.

## Tech Stack

- Java Spring Boot
- Maven

## Installation Guide

### Prerequisites

Before installing and running the project, ensure you have the following:

- Java 17 or later
- Maven 3.8+
- PostgreSQL

### Clone the Repository

```sh
git clone https://github.com/your-repo/vehicle-ticket-system.git
cd vehicle-ticket-system
```

### Configure Database

Update `application.properties` in `src/main/resources/` with your database credentials:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/parking_db
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
```

### Build and Run the Application

```sh
mvn clean install
mvn spring-boot:run
```

## API Endpoints

### 1. Vehicle Check-In

**Endpoint:** `POST /api/check-in`

- **Request Body:**

```json
{
  "plateNumber": "ABC123"
}
```

- **Response:**

```json
{
  "id": "26a7f462-75bd-42a0-9403-a793276499d8",
  "plateNumber": "AB123C2D",
  "checkInTime": "2025-02-12T11:07:43.718+00:00",
  "checkOutTime": null,
  "totalPrice": null,
  "status": "ACTIVE"
}
```

### 2. Vehicle Check-Out

**Endpoint:** `POST /api/check-out`

- **Request Body:**

```json
{
  "plateNumber": "ABC123"
}
```

- **Response:**

```json
{
  "id": "26a7f462-75bd-42a0-9403-a793276499d8",
  "plateNumber": "AB123C2D",
  "checkInTime": "2025-02-12T11:07:43.718+00:00",
  "checkOutTime": "2025-02-12T11:09:10.913+00:00",
  "totalPrice": 3000,
  "status": "COMPLETED"
}
```

### 3. Get Ticket Details

**Endpoint:** `GET /api/ticket/{plateNumber}`

- **Response:**

```json
{
  "id": "26a7f462-75bd-42a0-9403-a793276499d8",
  "plateNumber": "AB123C2D",
  "checkInTime": "2025-02-12T11:07:43.718+00:00",
  "checkOutTime": null,
  "totalPrice": 3000,
  "status": "ACTIVE"
}
```

## CORS Configuration

To allow frontend access from `http://localhost:5173`, CORS is enabled in the `@CrossOrigin` annotation.

## Notes

- Ensure database is running before starting the application.
- Use Postman or curl to test API endpoints.

## Future Enhancements

- Implement authentication and authorization.
- Add pricing calculations for parking duration.
- Improve logging and error handling.
