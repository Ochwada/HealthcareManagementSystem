# 📜 Healthcare Management System – Spring Boot & MongoDB

## 📝 Description
A Spring Boot application for managing healthcare entities such as patients, doctors, appointments, and medical records.  
This project is modularized using standard layered architecture: `Controller → Service → Repository → Model`.

You will design **multiple domain models** representing a simplified healthcare domain (patients, doctors, appointments, 
etc.), enforce **validation rules**, and implement **custom MongoDB queries**.

### 📚  Overview

System manages:

* **Patients**
* **Doctors**
* **Appointments**
* **Medical Records**

Each of these are separate **MongoDB collections** with clear relationships.

### Features
1. **Patient Management**: Create, read, update, and delete patient records.
2. **Doctor Profiles**: Manage doctors' details, specializations, and availability.
3. **Appointments**: Schedule, update, or cancel patient-doctor appointments.
4. **Medical Records**: Store and retrieve medical history linked to patients.
5. **`Gender` & `Status` Models**: Support for structured metadata (e.g., gender, status types).
6. **RESTful API**: Clean and modular endpoints for each core entity.
7. **Spring Boot + MongoDB**: Scalable backend powered by Spring and a NoSQL database.
8. **Environment-based Configuration**: Secure use of `.env `for API keys and DB URIs.
9. **Unit Testing with JUnit**: Pre-built test setup for application logic validation.

## RESTful API Endpoints
Below are the primary REST endpoints (assuming default `/api` base path):

#### 👤 Patient
```
| Method | Endpoint                             | Description                             |
| ------ | ------------------------------------ | --------------------------------------- |
| GET    | `/api/patients`                      | List all patients                       |
| GET    | `/api/patients/findById-{id}}`       | Get a patient by ID                     |
| POST   | `/api/patients/add-patient`          | Create a new patient                    |
| PUT    | `/api/patients/{id}`                 | Update patient details                  |
| DELETE | `/api/patients/delete-{id}           | Delete a patient                        |
| GET    |  `/api/patients/greaterThan-{age}`   | Find patients with age greater than x   |
| GET    |  `/api/patients/gender-{gender}}`    | Find patients with given gender         |

```
#### 🧑‍⚕️ Doctor
```
| Method | Endpoint                                       | Description                         |
| ------ | ---------------------------------------------- | ----------------------------------- |
| GET    | `/api/doctors`                                 | List all doctors                    |
| GET    | `/api/doctors/findById-{id}`                   | Get a doctor by ID                  |
| POST   | `/api/doctors/add-doctor`                      | Add a new doctor                    |
| PUT    | `/api/doctors/update-{id}`                     | Update doctor profile               |
| DELETE | `/api/doctors/delete-{id}`                     | Remove a doctor                     |
| GET    | `/api/doctors/findBySpeciality-{speciality}`   | Find doctors by speciality          |
| GET    | `/api/doctors/experience-{yearsOfExperience}`  | Find doctors by years of Experience |

```
#### 📅 Appointment
``` 
| Method | Endpoint                             | Description                                                       |
| ------ | ------------------------------------ | ----------------------------------------------------------------- |
| POST   | `/api/appointments`                  | Schedule a new appointment                                        |
| GET    | `/appointments/doctors/{doctorId}`   | View all appointments from a doctor                               |
| GET    | `/appointments/patients/{patientId}` | View all appointments from a patient                              |
| GET    | `/appointments/status/{status}`      | Retrieves all appointments with a specific status.                |
| GET    | `/appointments/range}`               | Retrieves all appointments scheduled between two dates (inclusive)|

```

#### 📄 Medical Records
``` 
| Method | Endpoint                    | Description                |
| ------ | --------------------------- | -------------------------- |
| GET    | `/api/medical-records`      | Get all medical records    |
| GET    | `/api/medical-records/{id}` | Get a medical record by ID |
| POST   | `/api/medical-records`      | Add a new medical record   |
| PUT    | `/api/medical-records/{id}` | Update a medical record    |
| DELETE | `/api/medical-records/{id}` | Delete a medical record    |
```
## 🗂️ Package Structure

```yaml
├── ---------------------------------------------------------------------------------------------- 

healthcare-management/
├── .env                       # Environment variables (e.g., DB credentials, API keys)
├── .gitignore                 # Git ignore rules
├── HELP.md                   # Optional helper file or documentation notes
├── healthcare-management.iml  # IntelliJ project config
├── mvnw / mvnw.cmd            # Maven Wrapper scripts
├── pom.xml                    # Maven project configuration

├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.ochwada.healthcare_management/
│   │   │       ├── controller/             # REST API controllers
│   │   │       ├── model/                  # Domain models/entities
│   │   │       │   ├── Appointment.java
│   │   │       │   ├── Doctor.java
│   │   │       │   ├── Gender.java
│   │   │       │   ├── MedicalRecord.java
│   │   │       │   ├── Patient.java
│   │   │       │   └── Status.java
│   │   │       ├── repository/             # Spring Data repositories
│   │   │       ├── service/                # Business logic layer
│   │   │       └── HealthcareManagementApplication.java  # Main Spring Boot application class
│   │   └── resources/                      # Application resources (e.g., application.properties, static files)

│
│   ├── test/
│   │   └── java/
│   │       └── com.ochwada.healthcare_management/
│   │           └── HealthcareManagementApplicationTests.java  # Unit and integration tests

├── ---------------------------------------------------------------------------------------------- 
```

#### 🧭 Structure Overview
- `model/`: Contains data classes/entities for domain objects like Patient, Doctor, Appointment, etc.
- `controller/`: REST controllers handling HTTP requests and routing.
- `service/`: Business logic and orchestration between controllers and repositories.
- `repository/`: Interfaces for data access (e.g., MongoDB, JPA).
- `resources/`: Application config files like application.properties or application.yml.
- `test/`: Unit and integration test classes.
- `HealthcareManagementApplication.java`: The entry point of the Spring Boot app.

## Tech Stack 
#### Backend
- **Java 21+** – Primary programming language 
- **Spring Boot** – Backend framework for building REST APIs 
- **Spring Web** – For creating RESTful web services 
- **Spring Data MongoDB** – For database access and repository support  (connected via `.env`)
- **Lombok (optional)** – To reduce boilerplate code in model and service classes

#### Database
- **MongoDB** – NoSQL document-oriented database 
- **MongoDB Atlas** – (optional) for cloud-based MongoDB hosting
  - Uses **MongoDB** as the data store. 
  - Uses **Spring Data MongoDB** with `MongoRepository`. 
  - Configure connection in `application.properties`.

#### Testing
- **JUnit 5** – Unit and integration testing 
- **Spring Boot Test** – For context-aware testing 
- **Mockito** – For mocking dependencies

#### Build Tool
- Maven – Dependency management and build automation

#### Deployment / Configuration
- **Spring Profiles** – For managing environment-specific configs 
- **`.env` file** – To inject secrets (like MongoDB URI and API keys)
- **Spring Configuration Properties** – For externalized application settings


### Running the App
```bash
./mvnw spring-boot:run
```

### Running tests
```bash
./mvnw test
```
