# Bookstore CRUD Application

This is a simple CRUD application for managing a bookstore, built using **Spring Boot** and **Maven**.

## **Project Structure**
```
src
 └─ main
     ├─ java
     │   └─ com
     │       └─ example
     │           └─ bookstore
     │               ├─ controller
     │               │    └─ BookController.java
     │               ├─ model
     │               │    └─ Book.java
     │               ├─ repository
     │               │    └─ BookRepository.java
     │               └─ Application.java (entry point)
     └─ resources
         ├─ application.properties
         └─ static (optional for web resources)
```

---

## **Prerequisites**
- **Java 17 or higher**
- **Eclipse IDE** with Spring Boot support
- **Maven** installed (comes with most IDEs)

---

## **How to Run the Application**

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd bookstore
   ```

2. **Import the Project into Eclipse**
   - Open Eclipse.
   - File > Import > Maven > Existing Maven Projects.
   - Select the folder where the project is located.
   - Click Finish.

3. **Configure Application Properties**
   Open the `src/main/resources/application.properties` file and ensure it has the following configuration:
   ```properties
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=password
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   spring.h2.console.enabled=true
   ```

4. **Run the Application**
   - Right-click the project in Eclipse.
   - Select **Run As** > **Spring Boot App**.

5. **Access the H2 Console** (Optional)
   - Open your browser and go to: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **Username**: `sa`
   - **Password**: `password`
   - Click Connect.

---

## **API Endpoints**

| **Method** | **Endpoint**       | **Description**        |
|------------|-------------------|------------------------|
| **GET**    | `/api/books`       | Get all books           |
| **POST**   | `/api/books`       | Create a new book       |
| **GET**    | `/api/books/{id}`  | Get a book by ID        |
| **PUT**    | `/api/books/{id}`  | Update a book by ID     |
| **DELETE** | `/api/books/{id}`  | Delete a book by ID     |

---

## **How to Test Using Postman**
1. **Open Postman**.
2. Send requests to the following URLs:

### **Get All Books**
- **URL**: `http://localhost:8080/api/books`
- **Method**: GET

### **Create a New Book**
- **URL**: `http://localhost:8080/api/books`
- **Method**: POST
- **Body** (raw, JSON):
  ```json
  {
    "title": "Clean Code",
    "author": "Robert C. Martin",
    "price": 29.99
  }
  ```

### **Get Book by ID**
- **URL**: `http://localhost:8080/api/books/{id}`
- **Method**: GET

### **Update Book by ID**
- **URL**: `http://localhost:8080/api/books/{id}`
- **Method**: PUT
- **Body** (raw, JSON):
  ```json
  {
    "title": "The Pragmatic Programmer",
    "author": "Andrew Hunt",
    "price": 35.99
  }
  ```

### **Delete Book by ID**
- **URL**: `http://localhost:8080/api/books/{id}`
- **Method**: DELETE

---

## **Common Issues**
1. **404 Not Found**: Make sure your URL is correct and the controller is properly mapped with `@RequestMapping`.
2. **H2 Console Not Working**: Ensure `spring.h2.console.enabled=true` is set in `application.properties`.
3. **Port Already in Use**: Another app might be using port **8080**. Change the port in `application.properties` using:
   ```properties
   server.port=8081
   ```

---

## **Author**
Hari Maulana
