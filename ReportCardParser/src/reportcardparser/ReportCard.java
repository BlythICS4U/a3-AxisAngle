/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcardparser;

/**
 * Class representing a student's report card
 * 
 * @author bachle
 */
public class ReportCard {
    private String name;
    private String dob;
    private CourseMark[] marks;
    private double average;
    
    /**
     * Constructor
     * 
     * @param name Student's name
     * @param dob Student's date of birth
     * @param marks Array containing all of the student's marks
     * @param average Student's average
     */
    public ReportCard(String name, String dob, CourseMark[] marks, double average) {
        this.name = name;
        this.dob = dob;
        this.marks = marks;
        this.average = average;
    }

    /**
     * Get the student's name
     * 
     * @return Student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the student's date of birth
     * 
     * @return Student's date of birth
     */
    public String getDob() {
        return dob;
    }

    /**
     * Get all marks for a student
     * 
     * @return Array containing all student's marks
     */
    public CourseMark[] getMarks() {
        return marks;
    }

    /**
     * Get student's average
     * 
     * @return Average of all student's marks
     */
    public double getAverage() {
        return average;
    }
}
