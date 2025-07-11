package com.ochwada.healthcare_management.repository;


import com.ochwada.healthcare_management.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * *******************************************************
 * Package: com.ochwada.healthcare_management.repository
 * File: DoctorRepository.java
 * Author: Ochwada
 * Date: Friday, 11.Jul.2025, 2:31 PM
 * Description: Repository interface for the Doctors document. Spring Data MongoDB automatically implements
 * the interface at runtime, providing built-in CRUD methods
 * Objective:
 * *******************************************************
 */


public interface DoctorRepository extends MongoRepository<Doctor, String> {
 // MongoRepository provides out-of-the-box CRUD methods
}
