package com.ochwada.healthcare_management.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * *******************************************************
 * Package: com.ochwada.healthcare_management.controller
 * File: RootController.java
 * Author: Ochwada
 * Date: Friday, 11.Jul.2025, 3:15 PM
 * Description: RootController provides a simple landing endpoint for the Healthcare API. Handles HTTP GET requests to the root URL (/)
 * Objective:
 * *******************************************************
 */
@RestController
public class RootController {

    /**
     * Handles GET requests to the root ("/") path.
     *
     * @return a friendly message indicating the API is running
     */
    @GetMapping("/")
    public String home() {
        return "\uD83C\uDFE5 Healthcare API is running";
    }
}
