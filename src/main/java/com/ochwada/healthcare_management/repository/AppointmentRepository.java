package com.ochwada.healthcare_management.repository;


import com.ochwada.healthcare_management.model.Appointment;
import com.ochwada.healthcare_management.model.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    /**
     * Retrieves all appointments for a specific patient by their ID.
     *
     * @param patientId the patient’s ID
     * @return a list of {@link Appointment} objects, or an empty list if none found
     */
    List<Appointment> findByPatientId(String patientId);

    /**
     * Retrieves all appointments for a specific doctor by their ID.
     *
     * @param doctorId the doctor's ID
     * @return a list of {@link Appointment} objects, or an empty list if none found
     */
    List<Appointment> findByDoctorId(String doctorId);


    /**
     * Retrieves all appointments that match the given status.
     *
     * @param status the {@link Status} of the appointment (e.g., SCHEDULED, COMPLETED, CANCELLED)
     * @return a list of {@link Appointment} objects with the specified status, or an empty list if none found
     */
    List<Appointment> findAppointmentsByStatus(Status status);

    /**
     * Finds all appointments scheduled between two dates (inclusive).
     *
     * @param startDate the start of the date range
     * @param endDate   the end of the date range
     * @return a list of appointments within the date range, or an empty list if none found
     */
    List<Appointment> findByDateBetween(LocalDate startDate, LocalDate endDate);

}
