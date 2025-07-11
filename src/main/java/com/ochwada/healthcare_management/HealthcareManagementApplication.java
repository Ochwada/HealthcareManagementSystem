package com.ochwada.healthcare_management;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Healthcare Management System application.
 * This Spring Boot application loads environment variables from a `.env` file using the dotenv-java library.
 * Specifically, it looks for the `MONGODB_URI` variable and sets it as a system property for use by Spring Data MongoDB.
 *
 * @author Ochwada
 */
@SpringBootApplication
public class HealthcareManagementApplication {
	static {
		// Load environment variables from .env (ignore if .env is missing, e.g., on Heroku)
		Dotenv dotenv = Dotenv.configure()
				.ignoreIfMissing()
				.load();

		// Retrieve the MongoDB URI from the .env
		String uri = dotenv.get("MONGODB_URI");

		// Set the URI as a system property if found, so Spring Boot can use it
		if (uri != null) {
			System.setProperty("MONGODB_URI", uri);
			System.out.println("✅ MONGODB_URI loaded and set.");
		} else {
			System.out.println("⚠️ MONGODB_URI not found in .env file. Skipping System.setProperty.");
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(HealthcareManagementApplication.class, args);
	}

}
