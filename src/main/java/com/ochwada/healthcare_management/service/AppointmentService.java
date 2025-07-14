package com.ochwada.healthcare_management.service;


import com.ochwada.healthcare_management.model.Appointment;
import com.ochwada.healthcare_management.model.Doctor;
import com.ochwada.healthcare_management.model.Status;
import com.ochwada.healthcare_management.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

/**
 * *******************************************************
 * Package: com.ochwada.healthcare_management.service
 * File: AppointmentService.java
 * Author: Ochwada
 * Date: Monday, 14.Jul.2025, 3:17 PM
 * Description:Service layer for Appointments operations. Service class for handling business logic related to appointments
 * Objective:
 * *******************************************************
 */

@Service
public class AppointmentService {

    // Dependency on the repository layer to perform CRUD operations on the Appointment document
    private final AppointmentRepository repository;

    /**
     * Constructor-based dependency injection  using @Autowired. (constructor injection of repository)
     * Spring injects ('introduces') an instance of AppointmentRepository at runtime.
     *
     * @param repository The repository used to access Appointment data from MongoDB
     */
    @Autowired
    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    /**
     * ---------------------------------------------------------------------------
     * --------------------------------------------------------------
     * Business methods like
     * - addAppointment(),
     * - getAllAppointmentsForPatient(),
     * - getAllAppointmentsForDoctor()
     * --------------------------------------------------------------
     * ---------------------------------------------------------------------------
     */
    /**
     * 1.
     * Create a new Appointment record
     *
     * @param appointment Appointment to insert.
     * @return inserted Appointment.
     */
    public Appointment addAppointment(Appointment appointment) {
        return repository.insert(appointment);
    }

    /**
     * 2.
     * Retrieve all Appointments from MongoDB database of a specific Patient.
     *
     * @param patientId id of the Patient the appointments are being retrieved.
     * @return an {@link Optional} containing the Appointments of a specific a patient if found or if not found.
     */
    public List<Appointment> getAllAppointmentsForPatient(String patientId) {
        return repository.findByPatientId(patientId);
    }

    /**
     * 3.
     * Retrieves all appointments from the MongoDB database for a specific doctor.
     *
     * @param doctorId the ID of the doctor whose appointments are being retrieved
     * @return a list of {@link Appointment} objects for the given doctor, or an empty list if none found
     */
    public List<Appointment> getAllAppointmentsForDoctor(String doctorId) {
        return repository.findByDoctorId(doctorId);
    }


    /**
     * ---------------------------------------------------------------------------
     * --------------------------------------------------------------
     * Custom Query:
     * - Find appointments by status (getAppointmentByStatus())
     * - Find appointments between dates (getAppointmentBtnDates())
     * --------------------------------------------------------------
     * ---------------------------------------------------------------------------
     */
    /**
     * 4.
     * Retrieves all appointments that match the given status.
     *
     * @param status the {@link Status} of the appointment (e.g., SCHEDULED, COMPLETED, CANCELLED)
     * @return a list of {@link Appointment} objects with the specified status if found or an empty list
     */
    public List<Appointment> getAppointmentByStatus(Status status) {
        return repository.findAppointmentsByStatus(status);
    }

    /**
     * 5.
     * Finds an appointment scheduled between two dates (inclusive).
     *
     * @param startDate the start of the date range
     * @param endDate   the end of the date range
     * @return an {@link Optional} containing an appointment within the date range, or empty if none found
     */
    public List<Appointment> getAppointmentBetweenDates(LocalDate startDate, LocalDate endDate) {
        return repository.findAppointmentsBetweenDates(startDate, endDate);
    }
}
