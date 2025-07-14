package com.ochwada.healthcare_management.controller;


import com.ochwada.healthcare_management.model.MedicalRecord;
import com.ochwada.healthcare_management.service.MedicalRecordService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * *******************************************************
 * Package: com.ochwada.healthcare_management.controller
 * File: MedicalRecordController.java
 * Author: Ochwada
 * Date: Monday, 14.Jul.2025, 5:33 PM
 * Description: REST Controller for mapping HTTP's Requests' URL's with Java methods.
 * Objective:
 * *******************************************************
 */

@RestController
@RequestMapping("/medical-records")
public class MedicalRecordController {
    // Dependency on the Medical records to delegate business logic
    private final MedicalRecordService service;

    /**
     * Constructor-based dependency injection for the medical record.
     * Spring will automatically inject the required bean at runtime.
     *
     * @param service the service handling medical record -related operations
     */
    public MedicalRecordController(MedicalRecordService service) {
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
     * Creates a new medical record.
     *
     * <p>This endpoint accepts a {@link MedicalRecord} object via the request body,
     * validates it, and stores it using the service layer.</p>
     *
     * @param record the medical record to be added
     * @return the saved {@link MedicalRecord}
     */
    @PostMapping
    public MedicalRecord addMedicalRecord(@Valid @RequestBody MedicalRecord record) {
        return service.addMedicalRecord(record);
    }

    /**
     * 2.
     * Retrieves all medical records.
     *
     * <p>This endpoint fetches all records from the database using the service layer.</p>
     *
     * @return a list of all {@link MedicalRecord} objects
     */
    @GetMapping
    public List<MedicalRecord> getAllMedicalRecord() {
        return service.getAllMedicalRecords();
    }


}
