package com.ochwada.healthcare_management.controller;


import com.ochwada.healthcare_management.model.Doctor;
import com.ochwada.healthcare_management.model.Patient;
import com.ochwada.healthcare_management.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * *******************************************************
 * Package: com.ochwada.healthcare_management.controller
 * File: DoctorController.java
 * Author: Ochwada
 * Date: Friday, 11.Jul.2025, 5:23 PM
 * Description: REST Controller for mapping HTTP's Requests' URL's with Java methods.
 * - Used for managing Doctor data.
 * - Talks to Web Client and Service layer.
 * Objective:
 * *******************************************************
 */

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    // Dependency on the Doctor to delegate business logic
    private final DoctorService service;

    /**
     * Constructor-based dependency injection for the DoctorService.
     * Spring will automatically inject the required bean at runtime.
     *
     * @param service the service handling Doctor-related operations
     */
    public DoctorController(DoctorService service) {
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
     * Adds a new doctor to the system.
     * *
     * This endpoint handles HTTP POST requests at {@code /add-doctor}. It accepts a JSON-formatted {@link Doctor} object
     * in the request body, validates it using {@code @Valid}, and passes it to the service layer for persistence.
     *
     * @param doctor the doctor object received in the request body, validated before saving
     * @return the saved {@link Doctor} object
     */
    @PostMapping("/add-doctor")
    public Doctor addDoctor(@Valid @RequestBody Doctor doctor) {
        return service.addDoctor(doctor);
    }

    /**
     * 2.
     * Retrieves all Doctors from the database.
     *
     * @return A list of all {@link Doctor} objects.
     */
    @GetMapping
    public List<Doctor> allDoctor() {
        return service.getAllDoctor();
    }

    /**
     * 3.
     * Retrieves a doctor by their unique identifier.
     * *
     * This endpoint handles HTTP GET requests at {@code /found-{id}}. The {@code id} is extracted from the URL using
     * {@link PathVariable} and passed to the service layer to look up the corresponding {@link Doctor}.
     *
     * @param id the unique identifier of the doctor to retrieve
     * @return an {@link Optional} containing the doctor if found, or empty if not found
     */
    @GetMapping("/found-{id}")
    public Optional<Doctor> findDoctorById(@PathVariable String id) {
        return service.findDoctorById(id);
    }

    /**
     * 4.
     * Updates an existing doctor identified by their ID.
     * *
     * This endpoint handles HTTP PUT requests at {@code /update/{id}}. It extracts the {@code id} from the URL using
     * {@link PathVariable} and receives the updated {@link Doctor} data in the request body. The service layer performs
     * the update and returns the modified record.
     *
     * @param id     the unique identifier of the doctor to update
     * @param doctor the updated {@link Doctor} object from the request body
     * @return the updated {@link Doctor} object
     */
    @PutMapping("update-{id}")
    public Doctor updatePatientById(@PathVariable String id,
                                    @RequestBody Doctor doctor) {
        return service.updateDoctor(id, doctor);
    }

    /**
     * Deletes a doctor from the system by their unique ID.
     * *
     * This endpoint handles HTTP DELETE requests at {@code /delete-{id}}. It extracts the {@code id} from the URL using
     * {@link PathVariable} and delegates the deletion process to the service layer.
     * *
     * If the doctor exists, they are deleted from the database. A {@code 204 No Content} HTTP status is returned to indicate
     * successful deletion with no response body.
     *
     * @param id the unique identifier of the doctor to delete
     * @return a {@link ResponseEntity} with HTTP status {@code 204 No Content}
     */
    @DeleteMapping("/delete-{id}")
    public ResponseEntity<Void> deleteDoctorById(@PathVariable String id) {
        service.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }


}
