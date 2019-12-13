/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcardparser;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Class to handle parsing of a Type 1 report card
 *
 * @author bachle
 */
public class ReportCardParserType1 extends AbstractReportCardParser {

    private String filePath; // Path to the report card file

    /**
     * Constructor
     *
     * @param filePath Path to the report card file
     */
    public ReportCardParserType1(String filePath) {
        super(filePath);
    }

    /**
     * Parse the configured report card file
     *
     * @return ReportCard object containing the data from the configured report
     * card file
     */
    @Override
    ReportCard parseFile(BufferedReader br) {

        try {
            String nameLine = br.readLine();
            nameLine = nameLine.replace("Name: ", "");

            String DOBLine = br.readLine();
            DOBLine = DOBLine.replace("DOB: ", "");

            br.readLine(); //Skips a line due to it being blank

            String subjectLine;
            CourseMark[] subject = new CourseMark[8];
            int i = 0;
            while ((subjectLine = br.readLine()) != null) {
                String[] placeholder = subjectLine.split("\\t+");
                subject[i] = new CourseMark(placeholder[0], Integer.parseInt(placeholder[1]));
                i++;
            }
            double sum = 0;
            for (int a = 0; a < subject.length; a++) {
                sum += subject[a].getMark();
            }
            double average = sum / subject.length;
            return new ReportCard(nameLine, DOBLine, subject, average);
        } catch (IOException ioe) {
            ioe.printStackTrace(System.out);
        }
        return null;
    }
}