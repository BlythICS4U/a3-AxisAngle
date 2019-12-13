/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcardparser;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Class to handle parsing of a Type 2 report card
 *
 * @author bachle
 */
public class ReportCardParserType2 extends AbstractReportCardParser {

    private String filePath; // Path to the report card file

    /**
     * Constructor
     *
     * @param filePath Path to the report card file
     */
    public ReportCardParserType2(String filePath) {
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

            String DOBLine = br.readLine();

            br.readLine(); //Skips a line due to it being blank

            String[] placeholder = br.readLine().split(",");
            CourseMark[] subject = new CourseMark[placeholder.length / 2];

            double sum = 0;
            for (int i = 0; i < subject.length; i++) {
                subject[i] = new CourseMark(placeholder[i * 2], Integer.parseInt(placeholder[(i * 2) + 1]));
                sum += subject[i].getMark();
            }
            double average = sum / subject.length;
            return new ReportCard(nameLine, DOBLine, subject, average);
        } catch (IOException ioe) {
            ioe.printStackTrace(System.out);
        }
        return null;
    }
}
