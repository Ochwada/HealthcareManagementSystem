package com.ochwada.healthcare_management.repository;


import com.ochwada.healthcare_management.model.MedicalRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * *******************************************************
 * Package: com.ochwada.healthcare_management.repository
 * File: MedicalRecordRepository.java
 * Author: Ochwada
 * Date: Friday, 11.Jul.2025, 2:33 PM
 * Description: Repository interface for the Medical Records document. Spring Data MongoDB automatically
 * implements the interface at runtime, providing built-in CRUD methods
 * Objective:
 * *******************************************************
 */


public interface MedicalRecordRepository extends MongoRepository<MedicalRecord, String> {
    // MongoRepository provides out-of-the-box CRUD methods


}
