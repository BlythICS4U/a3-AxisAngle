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
 * Class to handle parsing of a Type 3 report card
 * 
 * @author chris
 */
public class ReportCardParserType3 implements IReportCardParser {

    private String filePath; // Path to the report card file

    /**
     * Constructor
     * 
     * @param filePath Path to the report card file
     */
    public ReportCardParserType3(String filePath) {
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
            nameLine = nameLine.replace("Name: ", "");
            
            String DOBLine = br.readLine();
            DOBLine = DOBLine.replace("Date of Birth: ", "");
            
            br.readLine();//Skips a line due to it being blank
            
            String[] subjectName = br.readLine().split("\\t+");
            String[] subjectMark = br.readLine().split("\\t+");
            
            CourseMark[] subject = new CourseMark[subjectName.length];
            double sum = 0;
            for(int i = 0; i  < subject.length; i++)
            {
                subject[i] = new CourseMark(subjectName[i], Integer.parseInt(subjectMark[i]));
                sum+= Integer.parseInt(subjectMark[i]);
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


