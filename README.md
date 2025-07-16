# Sweet_shop_java_TDD
This Repo is basically the backend implementation of a Sweet_Shop in java that follows the Test Driven Development Approach. Here the User can Add, Delete, View, Search, Sort, Restock and purchase the sweets.

## Features
- Add new sweets (ID, name, category, price, quantity)
- Delete sweets by ID
- View all available sweets
- Search by name, category, or price range
- Sort sweets by name or price
- Purchase sweets (stock check included)
- Restock existing sweets

## Test-Driven Development (TDD)
- All features are developed following TDD.
- Unit tests are written before implementation using JUnit 5.
- Tests are located in:  
  `src/test/java/com/sweetshop/service/SweetShopServiceTest.java`

## Requirements
- Java 11 or higher
- JUnit 5
- Maven (optional but recommended)

## How to Run the Project

Using IntelliJ IDEA / Eclipse
Clone the repository
git clone <repo-url>
Run the tests
Navigate to SweetShopServiceTest.java and click ▶ on the class or individual test methods.

If using Maven:
Navigate to the project folder:
cd sweet-shop
Run the tests:
mvn test

## No frontend is implemented (backend logic only)
