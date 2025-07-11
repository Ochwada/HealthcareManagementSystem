package com.ochwada.healthcare_management.model;


import com.fasterxml.jackson.annotation.*;

/**
 * *******************************************************
 * Package: com.ochwada.healthcare_management.model
 * File: Status.java
 * Author: Ochwada
 * Date: Friday, 11.Jul.2025, 2:04 PM
 * Description:  Represents the Status of  patients in the system
 * Objective:
 * *******************************************************
 */

public enum Status {
    SCHEDULED,
    COMPLETED,
    CANCELLED;

    /**
     * Factory method to enable case-insensitive deserialization of enum values.
     * *
     * This method is automatically used by Jackson when deserializing JSON
     * due to the @JsonCreator annotation.
     *
     * @param input the Status string from JSON (e.g., "scheduled", "CANCELLED")
     * @return the corresponding Status enum constant
     * @throws IllegalArgumentException if input does not match any Status
     */
    @JsonCreator
    public static Status fromString(String input) {
        try {
            return Status.valueOf(input.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid status: " + input);
        }
    }

    /**
     * Serialize enum value to lowercase string in JSON responses.
     *
     * @return enum name in lowercase
     */
    @JsonValue
    public String toValue() {
        return name().toLowerCase();
    }
}
