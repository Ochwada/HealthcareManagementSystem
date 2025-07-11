package com.ochwada.healthcare_management.repository;


import com.ochwada.healthcare_management.model.Gender;
import com.ochwada.healthcare_management.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * *******************************************************
 * Package: com.ochwada.healthcare_management.repository
 * File: PatientRepository.java
 * Author: Ochwada
 * Date: Friday, 11.Jul.2025, 2:28 PM
 * Description: Repository interface for the Patient document. Spring Data MongoDB automatically implements
 * the interface at runtime, providing built-in CRUD methods
 * Objective:
 * *******************************************************
 */


public interface PatientRepository extends MongoRepository<Patient,String> {
 // MongoRepository provides out-of-the-box CRUD methods

    /**
     * ---------------------------------------------------------------------------
     * --------------------------------------------------------------
     * Custom Query:
     * - Find Patients by Age < given value
     * - Find patients by gender
     * --------------------------------------------------------------
     * ---------------------------------------------------------------------------
     */

    /**
     * Finds patients older than a given age.
     * @param age minimum age
     * @return list of patients older than the given age
     */
    List<Patient> findPatientsByAgeGreaterThan(int age);

    /**
     * Finds patients by gender (case-sensitive match).
     * @param gender gender enum value (e.g. Gender.MALE)
     * @return list of patients with the given gender
     */
    List<Patient> findPatientsByGender(Gender gender);
}
