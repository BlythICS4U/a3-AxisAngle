/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcardparser;

/**
 * Class for analyzing collections of report cards
 * 
 * @author chris
 */
public class ReportCardStats {
    
    /**
     * Find the student with the highest average
     * 
     * @param reportCards The array of report cards to search
     * @return The name of the student with the highest average
     */
    public static String GetBestStudent(ReportCard[] reportCards) {
        // REPLACE ME WITH A REAL IMPLEMENTATION!
        double highestAverage = 0;
        String bestStudent = "";
        for (int i = 0; i < reportCards.length; i++)
        {
            if(highestAverage < reportCards[i].getAverage())
            {
                highestAverage = reportCards[i].getAverage();
                bestStudent = reportCards[i].getName();
            }
        }
        return bestStudent;
    }
    
    /**
     * Find the best subject for the given report card
     * 
     * @param reportCard The report card to evaluate
     * @return The name of the subject with the highest mark
     */
    public static String GetBestSubject(ReportCard reportCard) {
        int bestSubject = 0;
        int index = 0;
        for (int i = 0; i < reportCard.getMarks().length; i++)
        {
            if(bestSubject < reportCard.getMarks()[i].getMark())
            {
             bestSubject = reportCard.getMarks()[i].getMark();
             index = i;
            }
        }
        return reportCard.getMarks()[index].getName();
    }
    
    /**
     * Calculate the average mark for a given subject
     * 
     * @param reportCards The array of report cards to search
     * @param subject The subject for average calculation
     * @return The average mark of the passed-in subject
     */
    public static double SubjectAverage(ReportCard[] reportCards, String subject) {
        // REPLACE ME WITH A REAL IMPLEMENTATION!
        int subjectIndex = 0;
        switch (subject) {
            case "English":
                subjectIndex = 0;
                break;
            case "Business Studies":
                subjectIndex = 1;
                break;
            case "Computer Science":
                subjectIndex = 2;
                break;
            case "Calculus":
                subjectIndex = 3;
                break;
            case "Principles of Mathematics":
                subjectIndex = 4;
                break;
            case "Chemistry":
                subjectIndex = 5;
                break;
            case "Physics":
                subjectIndex = 6;
                break;
            case "Biology":
                subjectIndex = 7;
                break;
        }
       int sum = 0;
        for (int i = 0; i < reportCards.length; i++)
        {
            sum+= reportCards[i].getMarks()[subjectIndex].getMark();
        }

        double average = (double) sum / reportCards[0].getMarks().length;
        return average;
    }
}
