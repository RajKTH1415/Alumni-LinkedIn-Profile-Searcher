# 🎓 Alumni LinkedIn Profile Searcher

A Spring Boot-based RESTful API to search LinkedIn profiles of alumni based on university, designation, and pass-out year.
The application simulates integration with **PhantomBuster API** to fetch LinkedIn data, stores relevant profiles in a MySQL database, and provides endpoints to retrieve this data.


---

## 🚀 Features

- 🔍 Search alumni profiles by **university name**, **designation**, and **pass-out year**
- 🛠️ Save alumni LinkedIn details to **MySQL database**
- 📤 Retrieve all saved alumni profiles
- 📘 Complete **Swagger/OpenAPI documentation** for easy API testing
- ✅ Unit and integration tests using **JUnit**, **Mockito**, and **MockMvc**
- 🔐 Basic input validation with exception handling
- 📊 Health and metrics endpoints exposed via **Spring Boot Actuator**

---

## 🧱 Tech Stack

- **Java 17**
- **Spring Boot 3.2.5**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Swagger/OpenAPI (SpringDoc)**
- **JUnit 5 + Mockito**
- **Maven**

---

## 🧪 API Endpoints

Base URL: `http://localhost:8080/api/alumni`

### 📌 Search Alumni (POST)

```http
POST http://localhost:8080/api/alumni/search

Request Body:

{
  "university": "Massachusetts Institute of Technology",
  "designation": "Software Engineer",
  "passoutYear": 2020
}

Response (200 OK):

{
    "status": "success",
    "data": [
        {
            "name": "John Doe",
            "currentRole": "Software Engineer",
            "university": "Massachusetts Institute of Technology",
            "location": "New York, NY",
            "linkedinHeadline": "Passionate Software Engineer at XYZ Corp",
            "passoutYear": 2020
        },
        {
            "name": "Jane Smith",
            "currentRole": "Data Scientist",
            "university": "Massachusetts Institute of Technology",
            "location": "San Francisco, CA",
            "linkedinHeadline": "Data Scientist | AI Enthusiast",
            "passoutYear": 2019
        }
    ]
}


Get All Alumni (GET)
```http
GET http://localhost:8080/api/alumni/all

Response:

{
    "status": "success",
    "data": [
        {
            "name": "John Doe",
            "currentRole": "Software Engineer",
            "university": "Massachusetts Institute of Technology",
            "location": "New York, NY",
            "linkedinHeadline": "Passionate Software Engineer at XYZ Corp",
            "passoutYear": 2020
        },
        {
            "name": "Jane Smith",
            "currentRole": "Data Scientist",
            "university": "Massachusetts Institute of Technology",
            "location": "San Francisco, CA",
            "linkedinHeadline": "Data Scientist | AI Enthusiast",
            "passoutYear": 2019
        }
    ]
}



📂 Project Structure
.
├── controller            # REST controllers (API layer)
├── service               # Business logic
├── model                 # JPA entities
├── repository            # Spring Data JPA repos
├── response/request      # DTOs
├── exception             # Global exception handling
├── config                # Swagger/OpenAPI config
├── test                  # Unit and integration tests
└── resources


🔧 Setup Instructions
📌 Prerequisites
Java 17
Maven 3.8+
MySQL running locally
📦 Clone and Build

git clone https://github.com/RajKTH1415/Alumni-LinkedIn-Profile-Searcher.git
cd Alumni-LinkedIn-Profile-Searcher
mvn clean install


⚙️ Database Config
Create a MySQL database (or let Spring auto-create one):

CREATE DATABASE backend_assessment_02;

Update src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/backend_assessment_02?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root

✅ Customize your DB credentials as needed.


Run the Application
mvn spring-boot:run


🧪 Testing
Run all unit/integration tests using:

mvn test

Controller tests – MockMvc
Service tests – Mockito enabled
📘 API Documentation
Visit http://localhost:8080/swagger-ui.html after running the app.

The documentation includes interactive endpoint testing.




Contributors
Rajkumar Prasad
📧 rajkumarprasadkth@gmail.com
🔗 GitHub - RajKTH1415
