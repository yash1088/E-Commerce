# E-Commerce Website

## Overview

This project is an e-commerce website developed using Spring Boot, Spring MVC, and a microservices architecture. The system consists of multiple microservices, each responsible for a specific domain or functionality within the e-commerce platform.

## Features

- **User Management**: Register, login, and manage user accounts.
- **Product Catalog**: Browse, search, and view product details.
- **Shopping Cart**: Add, remove, and update items in the shopping cart.
- **Order Management**: Place orders, view order history, and track order status.
- **Payment Gateway Integration**: Securely process payments using integrated payment gateways.
- **Microservices Architecture**: Modular design with independent microservices for scalability and maintainability.

## Technologies Used

- **Spring Boot**: For rapid development of microservices.
- **Spring MVC**: For building web applications with the Model-View-Controller pattern.
- **Spring Data**: For data access and persistence.
- **Spring Security**: For user authentication and authorization.
- **RESTful APIs**: For communication between microservices and clients.
- **Docker**: For containerization and deployment.
- **MySQL**: For relational database management.
- **RabbitMQ**: For asynchronous messaging and communication between microservices.
- **Swagger**: For API documentation and testing.
- **JUnit**: For unit testing.

## Getting Started

1. **Prerequisites**:
   - Java Development Kit (JDK) 11 or higher installed.
   - Maven for building the project.
   - Docker and Docker Compose for running the microservices.
   - MySQL database server.
   - RabbitMQ message broker.

2. **Clone the Repository**:
   -git clone https://github.com/Yash1088/E-commerce.git
    cd E-commerce


3. **Database Setup**:
- Create a MySQL database schema.
- Update the database configurations in each microservice's `application.properties` file.

4. **Build the Project**:
- mvn clean install
  
5. **Run Microservices**:
- Navigate to the root directory of each microservice.
- Build Docker images:
  ```
  docker build -t <image-name> .
  ```
- Run Docker containers using Docker Compose:
  ```
  docker-compose up
  ```

6. **Access the Application**:
- The web application will be available at `http://localhost:8080`.
- Explore the API documentation using Swagger UI at `http://localhost:8080/swagger-ui.html`.

## Contributing

Contributions are welcome! Feel free to open issues or submit pull requests for enhancements, bug fixes, or new features.
