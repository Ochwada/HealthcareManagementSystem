package com.ochwada.healthcare_management.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * *******************************************************
 * Package: com.ochwada.healthcare_management.model
 * File: Doctor.java
 * Author: Ochwada
 * Date: Friday, 11.Jul.2025, 10:57 AM
 * Description: Represents a doctor stored in the MongoDB collect "healthcareDB"
 * Objective:
 * *******************************************************
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "doctors")
public class Doctor {
    /** Unique identifier for the doctor (MongoDB ObjectId).*/
    @Id
    private String id;

    /** Full name of the doctor. */
    @NotBlank(message = "Name is required")
    private String name;

    /** Speciality of the doctor, e.g. "Cardiology", "Dermatology", "Pediatrics", etc. */
    @NotBlank(message = "Speciality is required")
    private String speciality;

    /** Years of Experience of the doctor with 0 as the minimum. */
    @NotNull(message = "Years of experience needed")
    @Min(value = 0, message = "Minimum value is 0")
    private int yearsOfExperience;

    /** Email address of the doctors. Must be a valid format. */
    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;


}
