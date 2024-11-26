# Product Order Management System

This project is a product and order management application developed with **Spring Boot**, designed to facilitate the creation, viewing, and management of orders and products.

## Features

- **Order Management**:
  - List all existing orders.
  - Create new orders by selecting available products.

- **Product Management**:
  - List all available products.
  - Add new products to the system.

## Project Structure

### Controllers

1. **OrderController**
   - Handles routes related to order management.
   - **GET /orders**: Displays a list of existing orders and available products for creating an order.
   - **POST /orders**: Creates a new order based on selected products.

2. **ProductController**
   - Handles routes related to product management.
   - **GET /products**: Lists all available products.
   - **POST /products**: Allows adding a new product.

### Services

1. **OrderService**
   - Provides business logic for order operations.

2. **ProductService**
   - Provides business logic for product operations.

### Repositories

1. **OrderRepository**
   - Interacts with the database for CRUD operations related to orders.

2. **ProductRepository**
   - Interacts with the database for CRUD operations related to products.

### Entities

1. **Order**
   - Represents an order, including a list of associated products.

2. **Product**
   - Represents a product with its essential attributes.

## System Requirements

- **Java**: Version 21 or higher.
- **Spring Boot**: Version 3.3.3 or higher.
- **Database**: Any JPA-compatible database (e.g., H2, MySQL, PostgreSQL).
- **Maven**: For dependency management.
