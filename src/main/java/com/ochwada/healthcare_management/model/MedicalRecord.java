package com.ochwada.healthcare_management.model;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

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

    private String id;
}
