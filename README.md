# Spring Boot RESTful API with MySQL

## About

A simple RESTful API built using Spring Boot and Spring Data JPA with a MySQL database.
The API supports basic CRUD operations and demonstrates how to build backend services using Spring Boot.

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven

## Features

* Create, Read, Update, Delete (CRUD) operations
* RESTful API endpoints
* Database integration with MySQL
* Layered architecture (Controller, Service, Repository)

## Project Structure

src/main/java
├── controller
├── service
├── repository
├── model
└── main application class

## API Endpoints

GET /api/users → Get all users
GET /api/users/{id} → Get user by ID
POST /api/users → Create new user
PUT /api/users/{id} → Update user
DELETE /api/users/{id} → Delete user

## How to Run

1. Clone the repository
   git clone https://github.com/your-username/your-repository-name.git

2. Navigate to project folder
   cd your-repository-name

3. Configure MySQL database in application.properties

4. Run the project
   mvn spring-boot:run

## Author
Arif Khan

