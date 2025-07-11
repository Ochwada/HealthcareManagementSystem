package com.ochwada.healthcare_management.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * *******************************************************
 * Package: com.ochwada.healthcare_management.model
 * File: Gender.java
 * Author: Ochwada
 * Date: Friday, 11.Jul.2025, 11:07 AM
 * Description: Represents the genders of  patients in the system
 * Objective:
 * *******************************************************
 */


public enum Gender {
    FEMALE,
    MALE,
    OTHERS;

    /**
     * Factory method to enable case-insensitive deserialization of enum values.
     * *
     * This method is automatically used by Jackson when deserializing JSON
     * due to the @JsonCreator annotation.
     *
     * @param input the gender string from JSON (e.g., "male", "MALE")
     * @return the corresponding Gender enum constant
     * @throws IllegalArgumentException if input does not match any Gender
     */
    @JsonCreator
    public static Gender fromString(String input){
        try {
            return  Gender.valueOf(input.trim().toUpperCase());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid gender: " + input);
        }
    }

    /**
     * Serialize enum value to lowercase string in JSON responses.
     *
     * @return enum name in lowercase in JSON responses
     */
    @JsonValue
    public String toValue(){
        return name().toLowerCase();
    }
}
