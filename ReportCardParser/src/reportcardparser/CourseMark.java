/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcardparser;

/**
 * Class used to store a single mark earned by a student in a particular course
 * 
 * @author bachle
 */
public class CourseMark {
    private String name; // Stores the name of the course
    private int mark; // Stores the mark earned in the course
    
    /**
     * Constructor
     * 
     * @param name The course name
     * @param mark The course mark
     */
    public CourseMark(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    /**
     * Get the name of the course
     * 
     * @return Course name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the mark earned in the course
     * 
     * @return The course mark
     */
    public int getMark() {
        return mark;
    }
}
