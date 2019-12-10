/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcardparser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class to handle parsing of a Type 1 report card
 * 
 * @author chris
 */
public class ReportCardParserType1 implements IReportCardParser {
    
    private String filePath; // Path to the report card file
    
    /**
     * Constructor
     * 
     * @param filePath Path to the report card file
     */
    public ReportCardParserType1(String filePath) {
        this.filePath = filePath;
    }
    
    /**
     * Parse the configured report card file
     * 
     * @return ReportCard object containing the data from the configured report card file
     */
    @Override
    public ReportCard parse() {
        // REPLACE ME WITH A REAL IMPLEMENTATION!
        BufferedReader br = null;
        
        try {
            br = new BufferedReader(new FileReader(filePath));
            
            String nameLine = br.readLine();
            nameLine =  nameLine.replace("Name: ", "");
            String DOBLine = br.readLine();
            DOBLine = DOBLine.replace("DOB: ", "");
            br.readLine();
            String subjectLine;
            CourseMark[] subject = new CourseMark[8];
            int i = 0;
            while((subjectLine = br.readLine()) != null) {
                String[] placeholder  = subjectLine.split("\\t+");
                subject[i] = new CourseMark(placeholder[0], Integer.parseInt(placeholder[1]));
                i++;
             }
            double sum = 0;
            for (int a = 0; a < subject.length; a++)
            {
                sum += subject[a].getMark();
            }
            double average = sum/subject.length;
            return new ReportCard(nameLine, DOBLine, subject, average);

        } catch (IOException ioe) {
            ioe.printStackTrace(System.out);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error in closing the BufferedReader");
                ioe.printStackTrace(System.out);
            }      
    }
        return null;
}
}