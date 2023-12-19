package com.example.demo2;

/**
 * The Student class represents an individual who is a student and extends the Person class.
 * It includes specific attributes related to students, such as student ID, graduation status,
 * and secondary school grade.
 */
public class Student extends Person {

    private int id;
    private Boolean isGraduated = false;
    private final Double secondarySchoolGrade;
    static Integer studentId = 0;




    public Student(String name, int nationalId, GENDER gender, String location,
                   Double secondarySchoolGrade, int age, long phoneNumber) {
        super(name, nationalId, gender, location, age, phoneNumber);
        this.id = id;
        ++studentId;


        // Validate and set the secondary school grade of the student
        if (secondarySchoolGrade < College.COLLEGE_GRADE) {
            throw new IllegalArgumentException("Your Grade must be higher than " + College.COLLEGE_GRADE);
        } else {
            this.secondarySchoolGrade = secondarySchoolGrade;
        }
    }

    //Getter method to retrieve the secondary school grade of the student.

    public Double getSecondarySchoolGrade() {
        return secondarySchoolGrade;
    }

    //Getter method to retrieve the graduation status of the student.

    public Boolean getGraduated() {
        return isGraduated;
    }

    //Setter method to set the graduation status of the student.

    public void setGraduated(Boolean graduated) {
        isGraduated = graduated;
    }
}

