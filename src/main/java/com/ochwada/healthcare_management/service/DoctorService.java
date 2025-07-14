package com.ochwada.healthcare_management.service;


import com.ochwada.healthcare_management.model.Doctor;
import com.ochwada.healthcare_management.model.Status;
import com.ochwada.healthcare_management.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * *******************************************************
 * Package: com.ochwada.healthcare_management.service
 * File: DoctorService.java
 * Author: Ochwada
 * Date: Friday, 11.Jul.2025, 5:27 PM
 * Description: Service layer for Doctor operations. Service class for handling business logic related to doctors
 * Objective:
 * *******************************************************
 */
@Service
public class DoctorService {

    // Dependency on the repository layer to perform CRUD operations on Doctor documents
    private final DoctorRepository repository;

    /**
     * Constructor-based dependency injection  using @Autowired. (constructor injection of repository)
     * Spring injects ('introduces') an instance of DoctorRepository at runtime.
     *
     * @param repository The repository used to access Doctor data from MongoDB
     */
    @Autowired
    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }
    /**
     * ---------------------------------------------------------------------------
     * --------------------------------------------------------------
     * Business methods like
     * - addDoctor(),
     * - getAllDoctor(),
     * - getDoctorById(),
     * - updateDoctor(),
     * - deleteDoctor()
     * --------------------------------------------------------------
     * ---------------------------------------------------------------------------
     */

    /**
     * 1.
     * Create a new doctor record.
     *
     * @param doctor Doctor to insert
     * @return inserted Doctor
     */
    public Doctor addDoctor(Doctor doctor) {
        return repository.insert(doctor);
    }

    /**
     * 2.
     * Retrieve all Doctor from the MongoDB database
     *
     * @return a List of all Doctor objects stored in the database.
     */
    public List<Doctor> getAllDoctor() {
        return repository.findAll();
    }

    /**
     * 3.
     * Retrieve a single Doctor by its unique identifier
     *
     * @return An {@link Optional} containing the Doctor if found, or empty if not found.
     */
    public Optional<Doctor> findDoctorById(String id) {
        return repository.findById(id);
    }

    /**
     * 4.
     * Updates an existing Doctor with the given ID using the provided update data.
     *
     * @param id           The unique identifier of the Doctor to be updated.
     * @param updateDoctor The updated Doctor data. The ID will be set to match the given ID.
     * @return The updated {@link Doctor} saved in the database.
     */
    public Doctor updateDoctor(String id, Doctor updateDoctor) {
        updateDoctor.setId(id);
        return repository.save(updateDoctor);
    }

    /**
     * 5.
     * Deletes a Doctor by its unique identifier.
     *
     * @param id The unique identifier of the Doctor to delete.
     *           If the ID does not exist, no action is taken.
     */
    public void deleteDoctor(String id) {
        repository.deleteById(id);
    }

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
     * 6.
     * Retrieves all doctors with the specified speciality.
     * *
     * Delegates to the repository layer to find all doctors whose speciality  matches the given string (e.g., "Cardiology",
     * "Dermatology", "Pediatrics").
     *
     * @param speciality the medical speciality to filter by
     * @return a list of {@link Doctor} objects with the specified speciality
     */
    public List<Doctor> getDoctorsBySpeciality(String speciality) {
        return repository.findDoctorsBySpeciality(speciality);
    }

    /**
     * 7.
     * Retrieves all doctors whose years of experience exceed the given value.
     * *
     * Delegates to the repository layer to find all doctors whose {@code experience} field is greater than the provided threshold.
     *
     * @param years the minimum number of years of experience
     * @return a list of {@link Doctor} objects with more than the given experience
     */
    public List<Doctor> getDoctorWithExperienceMoreThan(int years) {
        return repository.findDoctorsExperienceGreaterThan(years);
    }


}
