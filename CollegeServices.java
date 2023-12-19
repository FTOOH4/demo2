package com.example.demo2;

//import java.awt.*;

/**
 * The CollegeServices class provides various services related to college operations.
 * Services include requesting a graduation certificate, uploading certificates to the cloud,
 * and processing fee payments for different college years.
 */
public class CollegeServices {

    // Constant representing the fees for a graduation certificate
    public static final double FEES_FOR_GRADUATION_CERTIFICATE = 50.0;

    //Method to request a graduation certificate for a student.

    public Boolean requestGraduationCertificate(int studentId, int graduationYear) {
        // TODO: Implement logic for requesting a graduation certificate.
        return true;
    }

    //Method to upload a certificate image to the cloud.
/*
    public Boolean uploadCertificateToCloud(Image image) {
        // TODO: Implement logic for uploading a certificate image to the cloud.
        return true;
    }
*/

    // Method to process fee payment for a specific college year.


    public Boolean payFees(CollegeYears year, double fees) {
        // Switch statement to handle different college years
        switch (year) {
            case FIRST_YEAR -> {
                System.out.println("done");
            }
            case SECOND_YEAR -> {
                // TODO: Implement logic for processing fees for the second year.
            }
            case THIRD_YEAR -> {
                // TODO: Implement logic for processing fees for the third year.
            }
            case FOURTH_YEAR -> {
                // TODO: Implement logic for processing fees for the fourth year.
            }
            case FIFTH_YEAR -> {
                // TODO: Implement logic for processing fees for the fifth year.
            }
        }
        return true;
    }
}
