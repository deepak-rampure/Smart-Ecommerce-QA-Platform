# API Testing Report

## Project Name

Smart-Ecommerce-QA-Platform

## API Testing Tool

Postman

## Backend Technology

Node.js + Express.js

## Database

MySQL

## Base URL

http://localhost:5000

---

# 1. API Testing Objective

The objective of API testing is to verify that the ShopEase backend APIs:

- Return correct HTTP status codes
- Return expected response data
- Handle valid requests correctly
- Handle invalid requests correctly
- Validate database interactions
- Handle error conditions properly

---

# 2. API Test Environment

| Component | Details |
|---|---|
| API Tool | Postman |
| Backend | Node.js + Express.js |
| Database | MySQL |
| Server | localhost |
| Port | 5000 |
| Database Name | shopease |

---

# 3. API Test Cases

## API-TC-001: Get All Products

### Endpoint

GET /api/products

### Purpose

Verify that the API returns all products available in the database.

### Request

GET http://localhost:5000/api/products

### Expected Result

- HTTP status code should be 200 OK
- Product list should be returned
- Products should contain ID, name, category and price

### Actual Result

- HTTP 200 OK
- 6 products returned
- Product details matched the MySQL database

### Status

**PASS**

---

## API-TC-002: Get Product by Valid ID

### Endpoint

GET /api/products/:id

### Purpose

Verify that a product can be retrieved using a valid product ID.

### Request

GET http://localhost:5000/api/products/2

### Expected Result

- HTTP status code should be 200 OK
- Product with ID 2 should be returned
- Product should be Laptop

### Actual Result

- HTTP 200 OK
- Laptop product returned successfully

### Status

**PASS**

---

## API-TC-003: Get Product with Invalid ID

### Endpoint

GET /api/products/:id

### Purpose

Verify API behavior when a product ID does not exist.

### Request

GET http://localhost:5000/api/products/99

### Expected Result

- HTTP status code should be 404 Not Found
- Response should indicate that the product was not found

### Actual Result

- HTTP 404 Not Found
- Response message: Product not found

### Status

**PASS**

---

## API-TC-004: Login with Valid Credentials

### Endpoint

POST /api/login

### Purpose

Verify successful login using valid credentials.

### Request

POST http://localhost:5000/api/login

### Request Body

    {
        "email": "test@example.com",
        "password": "Test@123"
    }

### Expected Result

- HTTP status code should be 200 OK
- Login should be successful
- User details should be returned

### Actual Result

- HTTP 200 OK
- Login successful
- User information returned

### Status

**PASS**

---

## API-TC-005: Login with Invalid Credentials

### Endpoint

POST /api/login

### Purpose

Verify that the API rejects incorrect login credentials.

### Request

POST http://localhost:5000/api/login

### Request Body

    {
        "email": "wrong@example.com",
        "password": "wrong123"
    }

### Expected Result

- HTTP status code should be 401 Unauthorized
- API should return an invalid credentials message
- User should not be authenticated

### Actual Result

- HTTP 401 Unauthorized
- Response message: Invalid email or password.
- Login was rejected

### Status

**PASS**

---

## API-TC-006: Login with Empty Credentials

### Endpoint

POST /api/login

### Purpose

Verify API behavior when login credentials are empty.

### Request

POST http://localhost:5000/api/login

### Request Body

    {
        "email": "",
        "password": ""
    }

### Expected Result

- Login should not be successful
- API should reject the request
- Authentication failure response should be returned

### Actual Result

- HTTP 401 Unauthorized
- Login was rejected

### Status

**PASS**

---

## API-TC-007: Create Order with Valid Data

### Endpoint

POST /api/orders

### Purpose

Verify that a valid order can be created successfully.

### Request

POST http://localhost:5000/api/orders

### Request Body

    {
        "customer": {
            "userId": 1,
            "name": "Test User",
            "email": "test@example.com",
            "address": "Bengaluru"
        },
        "items": [
            {
                "id": 2,
                "name": "Laptop",
                "price": 59999,
                "quantity": 1
            },
            {
                "id": 1,
                "name": "Smartphone",
                "price": 24999,
                "quantity": 1
            }
        ],
        "totalAmount": 84998,
        "paymentMethod": "UPI"
    }

### Expected Result

- HTTP status code should be 201 Created
- Order should be created successfully
- Order ID should be generated
- Order details should be stored in the database

### Actual Result

- HTTP 201 Created
- Order created successfully
- Order ID generated
- Order record verified in MySQL
- Order items verified in MySQL

### Status

**PASS**

---

## API-TC-008: Create Order with Invalid Data

### Endpoint

POST /api/orders

### Purpose

Verify that the API rejects incomplete or invalid order details.

### Request

POST http://localhost:5000/api/orders

### Expected Result

- HTTP status code should be 400 Bad Request
- Order should not be created
- API should return an appropriate error message

### Actual Result

- HTTP 400 Bad Request
- Response message: Invalid order details
- Invalid order was rejected

### Status

**PASS**

---

# 4. API Test Execution Summary

| Test Case | API | Expected Status | Actual Status | Result |
|---|---|---:|---:|---|
| API-TC-001 | GET All Products | 200 | 200 | PASS |
| API-TC-002 | GET Product by ID | 200 | 200 | PASS |
| API-TC-003 | Invalid Product ID | 404 | 404 | PASS |
| API-TC-004 | Valid Login | 200 | 200 | PASS |
| API-TC-005 | Invalid Login | 401 | 401 | PASS |
| API-TC-006 | Empty Login | 401 | 401 | PASS |
| API-TC-007 | Valid Order | 201 | 201 | PASS |
| API-TC-008 | Invalid Order | 400 | 400 | PASS |

---

# 5. Overall API Test Result

**Total API Test Cases:** 8

**Passed:** 8

**Failed:** 0

**Skipped:** 0

**Pass Percentage:** 100%

---

# 6. Database Verification

Database verification was performed using MySQL Workbench.

The following database operations were verified:

- Products retrieved successfully from the products table
- Valid user verified during login
- Order record inserted into the orders table
- Order item records inserted into the order_items table
- Invalid order request was rejected
- Valid order information was stored successfully

---

# 7. HTTP Status Codes Tested

| Status Code | Meaning | Usage |
|---|---|---|
| 200 | OK | Successful GET and Login |
| 201 | Created | Successful order creation |
| 400 | Bad Request | Invalid order data |
| 401 | Unauthorized | Invalid login |
| 404 | Not Found | Product not found |

---

# 8. API Testing Coverage

The API testing covered the following areas:

### Product APIs

- Retrieve all products
- Retrieve product by ID
- Handle invalid product ID

### Authentication API

- Valid login
- Invalid login
- Empty login credentials

### Order API

- Create order with valid data
- Reject invalid order data

### Database Validation

- Product data verification
- User authentication verification
- Order insertion verification
- Order item insertion verification

---

# 9. API Testing Conclusion

API testing of the ShopEase backend was completed successfully using Postman.

The tested APIs correctly handled:

- Successful product retrieval
- Invalid product requests
- Valid authentication
- Invalid authentication
- Empty login credentials
- Successful order creation
- Invalid order requests

Database verification using MySQL Workbench also confirmed that valid orders and order items were stored correctly.

## Final API Testing Result

**8/8 test cases passed**

**100% pass percentage**

**API Testing Status: COMPLETED**