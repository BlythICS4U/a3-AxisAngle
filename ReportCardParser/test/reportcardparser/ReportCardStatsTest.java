/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportcardparser;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bachle
 */
public class ReportCardStatsTest {
    
    private static final String Folder = "ReportCards";
    
    private static IReportCardParser[] reportCardParsers = {
        new ReportCardParserType1(Folder + "/ReportType1_1.txt"),
        new ReportCardParserType1(Folder + "/ReportType1_2.txt"),
        new ReportCardParserType1(Folder + "/ReportType1_3.txt"),
        new ReportCardParserType2(Folder + "/ReportType2_1.txt"),
        new ReportCardParserType2(Folder + "/ReportType2_2.txt"),
        new ReportCardParserType2(Folder + "/ReportType2_3.txt"),
        new ReportCardParserType3(Folder + "/ReportType3_1.txt"),
        new ReportCardParserType3(Folder + "/ReportType3_2.txt"),
        new ReportCardParserType3(Folder + "/ReportType3_3.txt")
    };
     
    /**
     * Test of GetBestStudent method, of class ReportCardStats.
     */
    @Test
    public void testGetBestStudent() {
        ReportCard[] reportCards = new ReportCard[reportCardParsers.length];

        for (int i = 0; i < reportCardParsers.length; i++) {
            reportCards[i] = reportCardParsers[i].parse();
        }
        assertEquals(ReportCardStats.GetBestStudent(reportCards), "Bruce Banner");
    }

    /**
     * Test of GetBestSubject method, of class ReportCardStats.
     */
    @Test
    public void testGetBestSubject() {
        ReportCard[] reportCards = new ReportCard[reportCardParsers.length];

        for (int i = 0; i < reportCardParsers.length; i++) {
            reportCards[i] = reportCardParsers[i].parse();
        }
        assertEquals(ReportCardStats.GetBestSubject(reportCards[0]), "Computer Science");
        assertEquals(ReportCardStats.GetBestSubject(reportCards[1]), "Chemistry");
        assertEquals(ReportCardStats.GetBestSubject(reportCards[2]), "English");
        assertEquals(ReportCardStats.GetBestSubject(reportCards[3]), "Business Studies");
        assertEquals(ReportCardStats.GetBestSubject(reportCards[4]), "Biology");
        assertEquals(ReportCardStats.GetBestSubject(reportCards[5]), "Physics");
        assertEquals(ReportCardStats.GetBestSubject(reportCards[6]), "Business Studies");
        assertEquals(ReportCardStats.GetBestSubject(reportCards[7]), "Chemistry");
        assertEquals(ReportCardStats.GetBestSubject(reportCards[8]), "Computer Science");
    }

    /**
     * Test of SubjectAverage method, of class ReportCardStats.
     */
    @Test
    public void testSubjectAverage() {
        ReportCard[] reportCards = new ReportCard[reportCardParsers.length];

        for (int i = 0; i < reportCardParsers.length; i++) {
            reportCards[i] = reportCardParsers[i].parse();
        }
            assertEquals(ReportCardStats.SubjectAverage(reportCards, "English"), 83.33,0);
            assertEquals(ReportCardStats.SubjectAverage(reportCards, "Physics"),  77.0,0);
            assertEquals(ReportCardStats.SubjectAverage(reportCards, "Computer Science"), 81.0,0);
            assertEquals(ReportCardStats.SubjectAverage(reportCards, "Business Studies"),  81.56,0);
            assertEquals(ReportCardStats.SubjectAverage(reportCards, "Principles of Mathematics"), 80.78,0);
            assertEquals(ReportCardStats.SubjectAverage(reportCards, "Chemistry"),  80.89,0);
            assertEquals(ReportCardStats.SubjectAverage(reportCards, "Biology"), 78.33,0);
    }
    
}
