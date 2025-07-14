package com.ochwada.healthcare_management.controller;


import com.ochwada.healthcare_management.model.Gender;
import com.ochwada.healthcare_management.model.Patient;
import com.ochwada.healthcare_management.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * *******************************************************
 * Package: com.ochwada.healthcare_management.controller
 * File: PatientController.java
 * Author: Ochwada
 * Date: Friday, 11.Jul.2025, 3:12 PM
 * Description: REST Controller for mapping HTTP's Requests' URL's with Java methods.
 * - Used for managing Patient data.
 * - Talks to Web Client and Service layer.
 * Objective:
 * *******************************************************
 */
@RestController
@RequestMapping("/patients")
public class PatientController {
    // Dependency on the Patient to delegate business logic
    private final PatientService service;

    /**
     * Constructor-based dependency injection for the PatientService.
     * Spring will automatically inject the required bean at runtime.
     *
     * @param service the service handling Patient-related operations
     */
    @Autowired
    public PatientController(PatientService service) {
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
     * Adds a new patient to the system.
     * *
     * This endpoint handles HTTP POST requests at {@code /add-patient}. It accepts a JSON representation of a
     * {@link Patient} object in the request body, validates it using {@code @Valid}, and delegates the creation to the
     * service layer.
     *
     * @param patient the patient object sent in the request body (validated before processing)
     * @return the saved {@link Patient} object
     */
    @PostMapping("/add-patient")
    public Patient addPatients(@Valid @RequestBody Patient patient) {
        return service.addPatient(patient);
    }


    /**
     * 2.
     * Retrieves all Patients from the database.
     *
     * @return A list of all {@link Patient} objects.
     */
    @GetMapping
    public List<Patient> allPatients() {
        return service.findAllPatients();
    }

    /**
     * 3.
     * Retrieves a patient by their unique ID.
     * *
     * This endpoint handles HTTP GET requests at the path {@code /find-{id}}. The value in the URL (e.g., {@code /find-123})
     * is captured using {@link PathVariable}and passed as the {@code id} argument to look up a patient.
     *
     * @param id the unique ID of the patient to retrieve, extracted from the URL path
     * @return an {@link Optional} containing the patient if found, or empty if not
     */
    @GetMapping("/findById-{id}")
    public Optional<Patient> findPatientById(@PathVariable String id) {
        return service.findPatientById(id);
    }

    /** 4.
     * Updates an existing Patient by its unique identifier.
     *
     * @param id      The unique identifier of the Patient to update.
     * @param patient The updated Patient data received in the request body.
     * @return The updated {@link Patient} object after saving to the database.
     */
    @PutMapping("update-{id}")
    public Patient updatePatientById(@PathVariable String id,
                                     @RequestBody Patient patient) {
        return service.updatePatient(id, patient);
    }

    /** 5.
     * Deletes a Patient by its unique identifier.
     *
     * @param id The unique identifier of the Patient to delete.
     * @return A {@link ResponseEntity} with HTTP status 204 No Content.
     */
    @DeleteMapping("/delete-{id}")
    public ResponseEntity<Void> deletePatientById(@PathVariable String id){
        service.deletePatient(id);
        return ResponseEntity.noContent().build();

    }

    /**
     * ---------------------------------------------------------------------------
     * --------------------------------------------------------------
     * Custom Query Controller:
     * --------------------------------------------------------------
     * ---------------------------------------------------------------------------
     */

    /** 6.
     * Retrieves all patients whose age is greater than the specified value.
     * *
     * This endpoint handles HTTP GET requests at {@code /greaterThan/{age}}. It uses the {@link PathVariable} to extract
     * the {@code age} value from the URL path and delegates the filtering logic to the service layer.
     *
     * @param age the minimum age to filter by (exclusive)
     * @return a list of {@link Patient} objects older than the specified age
     */
    @GetMapping("/greaterThan-{age}")
    public List<Patient> getPatientsByAgeGreaterThan(@PathVariable int age){
        return service.getPatientsOlderThan(age);
    }

    /**7.
     * Retrieves all patients with the specified gender.
     * *
     * This endpoint handles HTTP GET requests at {@code /Gender-{gender}}. The gender is extracted from the URL path
     * using {@link PathVariable} and mapped to a {@link Gender} enum value. The lookup is case-insensitive if the enum is
     * properly configured with {@code @JsonCreator}.
     *
     * @param gender the gender to filter by (e.g., MALE, FEMALE, OTHERS)
     * @return a list of {@link Patient} objects matching the given gender
     */
    @GetMapping("/gender-{gender}")
    public List<Patient> getPatientsByGivenGender(@PathVariable Gender gender){
        return service.getPatientsByGender(gender);
    }


}
