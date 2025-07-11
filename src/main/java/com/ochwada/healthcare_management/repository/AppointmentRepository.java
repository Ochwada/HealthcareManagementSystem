package com.ochwada.healthcare_management.repository;


import com.ochwada.healthcare_management.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * *******************************************************
 * Package: com.ochwada.healthcare_management.repository
 * File: AppointmentRepository.java
 * Author: Ochwada
 * Date: Friday, 11.Jul.2025, 2:32 PM
 * Description: Repository interface for the Appointments document. Spring Data MongoDB automatically implements
 * the interface at runtime, providing built-in CRUD methods
 * Objective:
 * *******************************************************
 */


public interface AppointmentRepository extends MongoRepository<Appointment, String> {
 // MongoRepository provides out-of-the-box CRUD methods

    /**
     * ---------------------------------------------------------------------------
     * --------------------------------------------------------------
     * Custom Query:
     * - Find appointments by status
     * - Find appointments between dates
     * --------------------------------------------------------------
     * ---------------------------------------------------------------------------
     */
}
