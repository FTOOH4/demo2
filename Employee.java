package com.example.demo2;

/**
 * The Employee class represents an individual employed in an educational institution.
 * It extends the Person class and includes additional information such as job title, salary, and employment date.
 */
public class Employee extends Person {

    // Instance variables to store information about the employee
    private JopTitle jobTitle;          // The job title of the employee
    private double salary;               // The salary of the employee
    private String employmentDate;       // The date of employment for the employee

    //Constructor to initialize an Employee object with the provided information.

    public Employee(String name, int nationalId, GENDER gender, String location, int age, int phoneNumber,
                    JopTitle jobTitle, String employmentDate) {
        super(name, nationalId, gender, location, age, phoneNumber);
        this.jobTitle = jobTitle;
        this.employmentDate = employmentDate;
    }

    //Getter method to retrieve the job title of the employee.

    public JopTitle getJobTitle() {
        return jobTitle;
    }

    //Getter method to retrieve the salary of the employee.

    public double getSalary() {
        return salary;
    }

    //Getter method to retrieve the employment date of the employee.

    public String getEmploymentDate() {
        return employmentDate;
    }
}

