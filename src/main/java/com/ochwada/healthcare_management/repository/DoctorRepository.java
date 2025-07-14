package com.ochwada.healthcare_management.repository;


import com.ochwada.healthcare_management.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.*;

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

    /**
     * ---------------------------------------------------------------------------
     * --------------------------------------------------------------
     * Custom Query:
     * - Find doctors by specialty
     * - Find doctors with experience > X years
     * --------------------------------------------------------------
     * ---------------------------------------------------------------------------
     */

    /**
     * Find doctors by speciality
     *
     * @param speciality  speciality of the doctor e.g. "Cardiology", "Dermatology", "Pediatrics", etc.
     * @return list of Doctors with a given speciality.
     */
    List<Doctor> findDoctorsBySpeciality(String speciality);

    /**
     * Find doctors with years of experience greater than a given year.
     *
     * @param years years of experience
     * @return a list of doctors with more than the give years of experience.
     */
    List<Doctor> findByYearsOfExperienceGreaterThan(int years);

}
