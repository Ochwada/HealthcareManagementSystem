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
 * File: Appointment.java
 * Author: Ochwada
 * Date: Friday, 11.Jul.2025, 10:58 AM
 * Description: Represents  appointment stored in the MongoDB collect "healthcareDB"
 * Objective:
 * *******************************************************
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "appointments")
public class Appointment {
    /** Unique identifier for the appointment (MongoDB ObjectId).*/
    @Id
    private String id;

    /** Reference ID of the patient. */
    @NotNull(message = "Patient ID is required")
    private String patientId;

    /** Reference ID of the doctor. */
    @NotBlank(message = "Doctor ID is required")
    private String doctorId;

    /** Date of the appointment in ISO format (yyyy-MM-dd). */
    @NotNull(message = "Appointment date is required")
    @FutureOrPresent(message = "Appointment date must be today or in the future")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    /** Reason for the appointment. */
    @NotNull(message = "Reason for visit required")
    private String reason;

    /** Status of the appointment: Scheduled, Completed, or Cancelled. */
    @NotNull(message = "Status is required")
    private Status status; //  Enum type for stricter validation

}
