## Microservices-Based Payment System

This project entails the development of a microservices-based system consisting of four core microservices: User, Card, Transaction, and Product. Each service is designed to serve specific functions, facilitating user authentication, card management, payments, and product information retrieval.

### Microservices Overview:

#### User Service

- **Authentication:** Allows users to register and log in using JWT tokens.
- **User Card Management:** Enables users to add new cards to the Card Service, including a 16-digit card number, expiration date, CVV, and balance.
- **Transaction History:** Provides users access to their transaction history.
- **Viewing Cards:** Allows users to view the cards they have added.

#### Card Service

- **Card Storage:** Stores card details, including encrypted card numbers, expiration dates, encrypted CVVs, balances, and associated user information.
- **Multiple Cards:** Supports users having multiple cards.

#### Transaction Service

- **Transaction History:** Stores user information, card details, product information, and timestamps related to payments.

#### Product Service

- **Product Information:** Stores product names, stock details, and prices.
- **Viewing Products:** Enables users to view all available products in stock.

## Design Decisions

### Microservice Architecture

The decision to implement microservices architecture was made due to its inherent advantages in scalability, flexibility, and maintainability. Each microservice encapsulates specific business functionality, ensuring independent development and deployment.

### Database Selection

Different database technologies were chosen for each microservice to optimize data storage based on specific requirements. MySQL, MongoDB, PostgreSQL, and MariaDB were selected for their suitability in handling different types of data and scaling capabilities.

### RESTful APIs

The microservices communicate via RESTful APIs, ensuring seamless interaction between services. This architectural approach provides a standardized and language-agnostic interface for effective communication.

### Security Measures

The use of JWT tokens for user authentication ensures secure user access across services. Encryption techniques are implemented for sensitive data like card numbers and CVVs, enhancing data security and confidentiality.


### Running the Application:

To successfully run this microservices-based system, follow these steps:

1. **Start Database Services:** Navigate to each microservice's directory and run the respective Docker Compose file to initiate the required databases. Ensure all necessary databases (MySQL, MongoDB, PostgreSQL, MariaDB, etc.) are running correctly.

2. **Run Microservices:**

    - **User Service:** Run the User Service application from its Application class. It typically runs on port 8080.
    - **Transaction Service:** Run the Transaction Service application using its Application class. Often runs on port 8081.
    - **Product Service:** Start the Product Service application from its Application class. Generally operates on port 8082.
    - **Card Service:** Start the Card Service application from its Application class. Usually operates on port 8083.

Ensure to run each microservice individually on its respective port, ensuring they start without any issues.

**Note:** Cloud-based deployment strategies might not have been implemented yet. Ensure Docker is installed and properly configured to orchestrate and deploy the microservices locally.



## Technology Stack

## Tech Stack (User Service)

#### Spring Boot Dependencies:

- `spring-boot-starter-web`: For building RESTful APIs.
- `spring-boot-starter-security`: Implements security features.
- `spring-boot-starter-validation`: Supports input validation.
- `spring-boot-starter-data-jpa`: Manages relational databases using JPA.

#### Spring Cloud Dependencies:

- `spring-cloud-starter-openfeign`: Integrates with Feign clients.

#### JSON and Token Management:

- `jackson-databind`: For JSON serialization and deserialization.
- `jjwt-api`, `jjwt-impl`, `jjwt-jackson`: Libraries for JSON Web Token (JWT) support.

#### Password Validation and Security:

- `passay`: Library for password policy enforcement.

#### Utility Libraries:

- `guava`: General-purpose utility library.

#### Database Connector:

- `mysql-connector-java`: Connector for MySQL database.

#### Mapping and Object-Relational Mapping (ORM):

- `mapstruct`: Generates mapping code between DTOs and entities.

#### Additional Tools:

- `lombok`: Reduces boilerplate code in Java.

### Notes:

- `spring-cloud-starter-openfeign` integrates Feign clients, aiding HTTP requests to other microservices.
- `jjwt` libraries manage JWT tokens for token generation and validation.
- `passay` enforces password policy rules.
- `mapstruct` simplifies mapping between DTOs and entity objects.
- `lombok` reduces Java code verbosity by generating boilerplate code.


## Tech Stack (Transaction Service)

The Transactions Service leverages the following additional dependency:

### Spring Boot Dependencies


- `spring-boot-starter-data-mongodb`: Integrates the Transactions Service with MongoDB for data storage.



## Tech Stack (Product Service)

The Product Service incorporates the following additional dependency:

### Database Dependency

- `postgresql`: PostgreSQL JDBC driver for interacting with a PostgreSQL database.


## Tech Stack (Card Service)

The Card Service utilizes the following additional dependency:

### Database Dependency

- `mariadb-java-client`: MariaDB JDBC driver for interacting with a MariaDB database.
