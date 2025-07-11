# 📜 Healthcare Management System – Spring Boot & MongoDB


**Goal:**
Building a RESTful Healthcare Management System using Spring Boot and MongoDB.

You will design **multiple domain models** representing a simplified healthcare domain (patients, doctors, appointments, 
etc.), enforce **validation rules**, and implement **custom MongoDB queries**.

## 📚 Domain Overview

System manages:

* **Patients**
* **Doctors**
* **Appointments**
* **Medical Records**

Each of these are separate **MongoDB collections** with clear relationships.

## 💾 Database

* Uses **MongoDB** as the data store.
* Uses **Spring Data MongoDB** with `MongoRepository`.
* Configure connection in `application.properties`.

## 🗂️ Package Structure

```
com.example.healthcare
  ├── model
  │     ├── Patient.java
  │     ├── Doctor.java
  │     ├── Gender.java         <-! (enum) -->
  │     ├── Appointment.java
  │     └── MedicalRecord.java
  ├── repository
  │     ├── PatientRepository.java
  │     ├── DoctorRepository.java
  │     ├── AppointmentRepository.java
  │     └── MedicalRecordRepository.java
  ├── controller
  │     ├── PatientController.java
  │     ├── DoctorController.java
  │     ├── AppointmentController.java
  │     └── MedicalRecordController.java
  └── service
        ├── PatientService.java
        ├── DoctorService.java
        ├── AppointmentService.java
        └── MedicalRecordService.java
```

