package com.ochwada.healthcare_management.controller;


import com.ochwada.healthcare_management.model.Appointment;
import com.ochwada.healthcare_management.model.Status;
import com.ochwada.healthcare_management.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


/**
 * *******************************************************
 * Package: com.ochwada.healthcare_management.controller
 * File: AppointmentController.java
 * Author: Ochwada
 * Date: Monday, 14.Jul.2025, 4:32 PM
 * Description :REST Controller for mapping HTTP's Requests' URL's with Java methods.
 * Objective:
 * *******************************************************
 */

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    // Dependency on the Appointment to delegate business logic

    private final AppointmentService service;

    /**
     * Constructor-based dependency injection for the AppointmentService
     * Spring automatically injects the required bean at runtime
     *
     * @param service the service handling Appointment-related operations
     */
    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    /**
     * -------------------------------------------------------------
     * --------------------------------------------------------------
     * API endpoints (e.g., @GetMapping, @PostMapping) can be defined here.
     * --------------------------------------------------------------
     * --------------------------------------------------------------
     */
    /**
     * 1.
     * Adds a new appointment to the system.
     *
     * <p>This endpoint accepts an {@link Appointment} object in the request body,
     * validates it using {@code @Valid}, and delegates saving to the service layer.
     *
     * @param appointment the appointment object received in the request body, validated before saving
     * @return the saved {@link Appointment} object
     */
    @PostMapping
    public Appointment addAppointment(@Valid @RequestBody Appointment appointment) {
        return service.addAppointment(appointment);
    }


    /**
     * 2.
     * Retrieves all appointments associated with a specific doctor.
     *
     * <p>This endpoint uses the doctor’s ID as a path variable to query all related appointments.
     *
     * @param doctorId the ID of the doctor whose appointments are being retrieved
     * @return a list of {@link Appointment} objects for the specified doctor, or an empty list if none found
     */
    @GetMapping("/doctors/{doctorId}")
    public List<Appointment> findAllAppointmentsForDoctor(@PathVariable String doctorId) {
        return service.getAllAppointmentsForDoctor(doctorId);
    }

    /**
     * 3.
     * Retrieves all appointments associated with a specific patient.
     *
     * <p>This endpoint uses the patient’s ID as a path variable to fetch all related appointments
     * from the system via the service layer.
     *
     * @param patientId the ID of the patient whose appointments are being retrieved
     * @return a list of {@link Appointment} objects for the specified patient, or an empty list if none are found
     */
    @GetMapping("/patients/{patientId}")
    public List<Appointment> findAllAppointmentsForPatient(@PathVariable String patientId) {
        return service.getAllAppointmentsForPatient(patientId);
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
     * Retrieves all appointments with a specific status.
     *
     * <p>Example: GET /appointments/status/SCHEDULED
     *
     * @param status the status of the appointments to retrieve (e.g., SCHEDULED, CANCELLED)
     * @return a list of {@link Appointment} objects with the specified status
     */
    @GetMapping("/status/{status}")
    public List<Appointment> getAppointmentsByStatus(@PathVariable Status status) {
        return service.getAppointmentByStatus(status);
    }

    /**
     * 5.
     * Retrieves all appointments scheduled between two dates (inclusive).
     *
     * <p>Example: GET /appointments/range?startDate=2025-07-01&endDate=2025-07-31
     *
     * @param startDate the start of the date range (format: yyyy-MM-dd)
     * @param endDate the end of the date range (format: yyyy-MM-dd)
     * @return a list of {@link Appointment} objects within the specified date range
     */
    @GetMapping("/range")
    public List<Appointment> getAppointmentsBetweenDates(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return service.getAppointmentBetweenDates(startDate, endDate);
    }


}
