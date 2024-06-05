# Flowerista

Flowerista is a Spring Boot application serving as a backend service for a flower shop. It interacts with a database and provides an API for a frontend application.

## Key Features

- **CRUD Operations**: Handles Create, Read, Update, and Delete operations for entities like Bouquet, Flower, and Color.
- **Image Handling**: Manages bouquet images, including uploading to Cloudinary and deleting images.
- **Search Functionality**: Provides search functionality for bouquets.
- **Stock Management**: Manages bouquet stock, including checking availability and updating stock based on orders.
- **Email Functionality**: Implemented using Spring Mail.
- **Security Features**: Uses JWT with refresh token rotation for authentication and Redis as storage for tokens.
- **API Documentation**: Provided through Swagger UI.
- **Complex Queries**: Handled using QueryDSL and native sql query.
- **Object Mapping**: Handled using MapStruct.
- **Boilerplate Code Reduction**: Achieved through the use of Lombok.
- **Payment Processing**: Handled using the PayPal SDK.
- **Server-side Java Template Engine**: Implemented using Thymeleaf.
- **Caching**: Implemented using Spring cache with refreshing on period of time.
- **Integration Tests**: Handled using Testcontainers.

## Technologies Used

- Java
- JavaScript
- Spring Boot
- JWT
- Redis
- Postgres
- SQL
- Maven
