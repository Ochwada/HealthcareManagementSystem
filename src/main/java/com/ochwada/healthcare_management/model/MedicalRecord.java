package com.ochwada.healthcare_management.model;


import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * *******************************************************
 * Package: com.ochwada.healthcare_management.model
 * File: MedicalRecord.java
 * Author: Ochwada
 * Date: Friday, 11.Jul.2025, 10:59 AM
 * Description: Represents a medical record stored in the MongoDB collect "healthcareDB"
 * Objective:
 * *******************************************************
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "medical_records")
public class MedicalRecord {

    /** Unique identifier for the medical record (MongoDB ObjectId).*/
    @Id
    private String id;

    /** Reference ID of the patient. */
    @NotBlank(message = "Patient ID is required")
    private String patientID;

    /** Diagnosis of the patient. */
    @NotBlank(message = "Diagnosis is required")
    private  String diagnosis;

    /** Treatment of the patient. */
    @NotBlank(message = "Treatment is required")
    private String treatment;

    /** Date the record was created (must be today or in the past). */
    @NotNull(message = "Created date is required")
    @PastOrPresent(message = "Created date must be in the past or today")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate createdOn;
}
