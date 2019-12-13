/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcardparser;

/**
 * Interface defining the public API required by all report card parser classes
 * 
 * @author bachle
 */
public interface IReportCardParser {
    /**
     * Parse the contents of a report card file and return the data as
     * a ReportCard object
     * 
     * @return ReportCard object containing the parsed data
     */
    ReportCard parse();
}
