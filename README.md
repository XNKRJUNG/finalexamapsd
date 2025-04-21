# 🚀 Mission Control: Satellite-Astronaut Tracking System

This Spring Boot REST API allows you to manage astronauts and satellites, including their assignments, updates, and validations.

---

## 📦 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate Validator
- PostgreSQL
- MapStruct
- Lombok
- Postman (for testing)

---

## 📁 Features Implemented

✅ Data Persistence with JPA  
✅ `@ManyToMany` relationships  
✅ DTO + Mapper architecture using MapStruct  
✅ RESTful endpoints with `@RestController`  
✅ Full validation via `@Valid`, `@NotBlank`, `@Pattern`, `@Past`  
✅ `ResponseEntity<>` + proper HTTP status codes  
✅ Exception handling with `@RestControllerAdvice` and `ApiError`  
✅ Pagination & sorting using `Pageable`, `PageRequest`

---

## 🔧 How to Run

1. Configure PostgreSQL and set credentials in `application.properties`
2. Run the application 

---

## 📸 Screenshot 

1. 🎯 POST /api/v1/astronauts
Create a new astronaut with a list of satellite IDs.

✅ Sample Request
{
  "firstName": "Neil",
  "lastName": "Armstrong",
  "experienceYears": 20,
  "satelliteIds": [1, 2]
}
  ![Create Astronaut1](screenshots/post-astronaut-success1.png)
  ![Create Astronaut2](screenshots/post-astronaut-success2.png)
  ![Create Astronaut3](screenshots/post-astronaut-success3.png)

2. 📄 GET /api/v1/astronauts?page=0&size=5&sort=experienceYears,desc
Get all astronauts (paginated & sorted)
  ![Sorted Astronauts1](screenshots/get-astronauts-sorted1.png)
  ![Sorted Astronauts2](screenshots/get-astronauts-sorted2.png)
  ![Sorted Astronauts3](screenshots/get-astronauts-sorted3.png)


3. ✏️ PUT /api/v1/satellites/{id}
Update a satellite if it's not decommissioned.

✅ Request:
{
  "name": "Hubble Telescope",
  "launchDate": "1990-04-24",
  "orbitType": "LEO",
  "decommissioned": false
}
  ![Successful Satellite Update](screenshots/put-satellite-success.png)


4. ❌ PUT /api/v1/satellites/{id} (Decommissioned)
Attempt to update a decommissioned satellite.
  ![Decommission Error](screenshots/put-satellite-decommissioned-error.png)

5. ⚠️ POST /api/v1/astronauts (Validation Failures)
  a. Missing field:
  {
    "firstName": "Buzz",
    "experienceYears": 15,
    "satelliteIds": [1]
  }
  ![Validation Error1](screenshots/validation-error1.png)

  b. Invalid satellite ID:
  {
  "firstName": "Yuri",
  "lastName": "Gagarin",
  "experienceYears": 10,
  "satelliteIds": [9999]
  }
  ![Validation Error2](screenshots/validation-error2.png)



Thank you!!
