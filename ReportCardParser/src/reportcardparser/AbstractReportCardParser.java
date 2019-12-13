/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcardparser;

import java.io.*;
/**
 *
 * @author bachle
 */
public abstract class AbstractReportCardParser implements IReportCardParser {
        private String filePath; // Path to the report card file 
        
    /**
     * Constructor
     * 
     * @param filePath Path to the report card file
     */
    public AbstractReportCardParser(String filePath) {
        this.filePath = filePath;
    }
    
    /**
     * Opens and closes the file
     * 
     * @return  null
     */
    @Override
    public ReportCard parse()
    {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            
          return parseFile(br);
            
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
    abstract ReportCard parseFile(BufferedReader br);
}