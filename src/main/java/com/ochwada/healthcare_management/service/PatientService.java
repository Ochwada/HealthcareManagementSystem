package com.ochwada.healthcare_management.service;


import com.ochwada.healthcare_management.model.Gender;
import com.ochwada.healthcare_management.model.Patient;
import com.ochwada.healthcare_management.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * *******************************************************
 * Package: com.ochwada.healthcare_management.service
 * File: PatientService.java
 * Author: Ochwada
 * Date: Friday, 11.Jul.2025, 2:36 PM
 * Description: Service layer for Patient operations. Service class for handling business logic related to patients.
 * Objective:
 * *******************************************************
 */

@Service
public class PatientService {
    // Dependency on the repository layer to perform CRUD operations on Patient documents
    private final PatientRepository repository;

    /**
     * Constructor-based dependency injection  using @Autowired. (constructor injection of repository)
     * Spring injects ('introduces') an instance of PatientRepository at runtime.
     *
     * @param repository The repository used to access Patient data from MongoDB
     */
    @Autowired
    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    /**
     * ---------------------------------------------------------------------------
     * --------------------------------------------------------------
     * Business methods like
     * - addPatient(),
     * - getAllPatients(),
     * - getPatientById(),
     * - updatePatient(),
     * - deletePatient()
     * --------------------------------------------------------------
     * ---------------------------------------------------------------------------
     */

    /**
     * 1.
     * Create a new patient record.
     *
     * @param patient Patient to insert
     * @return inserted Patient
     */
    public Patient addPatient(Patient patient) {
        return repository.insert(patient);
    }

    /**
     * 2.
     * Retrieve all Patients from the MongoDB database
     *
     * @return a List of all Patient objects stored in the database.
     */
    public List<Patient> findAllPatients() {
        return repository.findAll();
    }

    /**
     * 3.
     * Retrieve a single Patient by its unique identifier
     *
     * @return An {@link Optional} containing the Patient if found, or empty if not found.
     */
    public Optional<Patient> findPatientById(String id) {
        return repository.findById(id);
    }

    /**
     * 4.
     * Updates an existing Patient with the given ID using the provided updated data.
     *
     * @param id            The unique identifier of the Patient to be updated.
     * @param updatePatient The updated Patient data. The ID will be set to match the given ID.
     * @return The updated {@link Patient} saved in the database.
     */
    public Patient updatePatient(String id, Patient updatePatient) {
        updatePatient.setId(id);
        return repository.save(updatePatient);
    }

    /**
     * 5.
     * Deletes a Patient by its unique identifier.
     *
     * @param id The unique identifier of the Patient to delete.
     *           If the ID does not exist, no action is taken.
     */
    public void deletePatient(String id) {
        repository.deleteById(id);
    }


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
     * 6.
     * Retrieve all Patients from the MongoDB database greater than a give age
     *
     * @return a List of all Patient objects stored in the database with ages greater than the given.
     */
    public List<Patient> getPatientsOlderThan(int age) {
        return repository.findPatientsByAgeGreaterThan(age);
    }

    /**
     * 7.
     * Retrieves a list of patients filtered by their gender.
     * <p>
     * Delegates to the repository layer to perform a query on the "patients" collection
     * where the {@code gender} field matches the specified {@link Gender} value.
     * </p>
     *
     * @param gender the gender to filter by (e.g., {@code Gender.MALE}, {@code Gender.FEMALE}, {@code Gender.OTHERS})
     * @return a list of {@link Patient} objects with the specified gender
     */
    public List<Patient> getPatientsByGender(Gender gender) {
        return repository.findPatientsByGender(gender);
    }


}
