package com.ochwada.healthcare_management.model;


import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * *******************************************************
 * Package: com.ochwada.healthcare_management.model
 * File: Patient.java
 * Author: Ochwada
 * Date: Friday, 11.Jul.2025, 10:56 AM
 * Description: Represents a patient stored in the MongoDB collect "healthcareDB"
 * Objective:
 * *******************************************************
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "patient")
public class Patient {
    /** Unique identifier for the patient (MongoDB ObjectId).*/
    @Id
    private String id;

    /** Full name of the patient. */
    @NotBlank(message = "Name is required")
    private String name;

    /** Age of the patient. Must be a positive integer. */
    @NotNull(message = "Age is required")
    @Min(value = 1, message = "Age should be positive")
    private int age;

    /** Gender of the patient. Required field, represented as an enum. */
    @NotNull(message = "Gender is Required")
    private Gender gender; //  Enum type for stricter validation

    /** Email address of the patient. Must be a valid format. */
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    /**
     * Phone number of the patient.
     * Must contain 10 to 15 digits, with optional leading "+".
     */
    @Pattern(
            regexp = "^\\+?[0-9]{10,15}$",
            message = "Phone number must be 10–15 digits, optional leading +"
    )
    private String phoneNumber;
}
