# Weather Report Management System
#  Overview
The Weather Report Management System is a Spring Boot application that allows users to store, retrieve, update, and delete weather reports from a database. It provides a RESTful API to interact with weather data, including temperature, conditions, and city-based reports.

# Tech Stack
- Java 23
- Spring Boot 3.3.8
- Spring Data JPA
- MySQL Database
- Maven
- Postman (for API testing)
#  Features
- Add a new weather report
- Retrieve all weather reports
- Get weather reports by ID or city
- Update weather details
- Delete weather records
- Fetch rainy weather reports
# API Endpoints
 1. Add Weather Report
POST /weather
2. Get All Weather Reports
GET /weather
 3. Get Weather by ID
GET /byid?id=1
 4. Get Weather by City
GET /bycity?city=New York
 5. Update Weather Report
PUT /weather?id=1&condt=Rainy&temp=20°C
 6. Delete Weather Report
DELETE /weather?id=1

# Test the API in Postman
Start your Spring Boot app and send requests using Postman.
