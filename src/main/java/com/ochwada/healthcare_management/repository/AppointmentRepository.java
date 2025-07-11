package com.ochwada.healthcare_management.repository;


import com.ochwada.healthcare_management.model.Appointment;
import com.ochwada.healthcare_management.model.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

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
     * Retrieves all appointments that match the given status.
     * *
     * This method uses Spring Data MongoDB’s derived query mechanism to fetch documents from the
     * "appointments" collection where the {@code status} field equals the provided {@link Status} value.
     *
     * @param status the {@link Status} of the appointment (e.g., SCHEDULED, COMPLETED, CANCELLED)
     * @return a list of {@link Appointment} objects with the specified status
     */
    List<Appointment> findAppointmentsByStatus(Status status);

    /**
     * Finds all appointments scheduled between two dates (inclusive).
     *
     * @param startDate the start of the date range
     * @param endDate the end of the date range
     * @return list of appointments within the date range
     */
    List<Appointment> findAppointmentsBetweenDates(LocalDate startDate, LocalDate endDate);
}
