# Microservices-Based Payment System

## Description

This repository contains a Postman API collection for a microservices-based payment system. The collection covers endpoints for User Service, Transaction Service, Product Service, and Card Service.

## API Collection

### User Service

#### Sign In

- **Method:** POST
- **URL:** http://localhost:8080/api/users/sign-in

#### Test

- **Method:** GET
- **URL:** http://localhost:8080/api/users/

#### Sign Up

- **Method:** POST
- **URL:** http://localhost:8080/api/users/sign-up

#### getUserCards

- **Method:** GET

#### getAllProducts

- **Method:** GET

#### addCard

- **Method:** POST
- **URL:** http://localhost:8080/api/cards/add

#### makePayment

- **Method:** GET

#### getUserTransactions

- **Method:** GET

#### getUserList

- **Method:** GET

### Transaction Service

#### addTransaction

- **Method:** POST
- **URL:** http://localhost:8080/api/transactions/add

#### testMethod

- **Method:** GET
- **URL:** http://localhost:8080/api/transactions/

#### viewTransactionHistory

- **Method:** GET
- **URL:** http://localhost:8080/api/transactions/history/:userId

### Product Service

#### updateInventory

- **Method:** PATCH
- **URL:** http://localhost:8080/api/products/:productId/updateInventory

#### addProduct

- **Method:** POST
- **URL:** http://localhost:8080/api/products/add

#### getAllProducts

- **Method:** GET
- **URL:** http://localhost:8080/api/products/all

#### isProductInStock

- **Method:** GET
- **URL:** http://localhost:8080/api/products/:productId/isInStock

### Card Service

#### getCardsForUser

- **Method:** GET
- **URL:** http://localhost:8080/api/cards/:userId

#### addCard

- **Method:** POST
- **URL:** http://localhost:8080/api/cards/add

#### deductAmountFromCardBalance

- **Method:** PATCH
- **URL:** http://localhost:8080/api/cards/:cardNumber/deduct?amount=5

