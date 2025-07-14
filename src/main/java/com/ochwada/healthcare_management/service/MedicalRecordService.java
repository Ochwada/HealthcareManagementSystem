package com.ochwada.healthcare_management.service;


import com.ochwada.healthcare_management.model.MedicalRecord;
import com.ochwada.healthcare_management.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * *******************************************************
 * Package: com.ochwada.healthcare_management.service
 * File: MedicalRecordService.java
 * Author: Ochwada
 * Date: Monday, 14.Jul.2025, 3:51 PM
 * Description: Service layer for Medical Records operations. Service class for handling business logic related to medical records
 * Objective:
 * *******************************************************
 */

@Service
public class MedicalRecordService {
    // Dependency  on the repository layer to perform CRUD operations on the Medical Records document
    private final MedicalRecordRepository repository;

    /**
     * Constructor-based dependency injection  using @Autowired. (constructor injection of repository)
     * Spring injects ('introduces') an instance of MedicalRecordRepository at runtime.
     *
     * @param repository The repository used to access MedicalRecord data from MongoDB
     */
    @Autowired
    public MedicalRecordService(MedicalRecordRepository repository) {
        this.repository = repository;
    }
    /**
     * ---------------------------------------------------------------------------
     * --------------------------------------------------------------
     * Business methods like
     * - addMedicalRecordRepository(),
     * - getAllMedicalRecordRepositoryForPatient(),
     * --------------------------------------------------------------
     * ---------------------------------------------------------------------------
     */
    /**
     * 1.
     * Creates a new medical record and stores it in the database.
     *
     * @param record the {@link MedicalRecord} object to insert
     * @return the inserted {@link MedicalRecord} object
     */
    public MedicalRecord addMedicalRecord(MedicalRecord record) {
        return repository.insert(record);
    }

    /**
     * 2.
     * Retrieves all medical records stored in the database.
     *
     * @return a list of all {@link MedicalRecord} objects
     */
    public List<MedicalRecord> getAllMedicalRecords() {
        return repository.findAll();
    }


}
