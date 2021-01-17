package net.jayray.pepper.leagueage;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class LeagueAgeCalculatorTest {

    private final Date REFERENCE_JAN = d("1/1/2021");
    private final Date REFERENCE_DEC = d("12/31/2021");

    public LeagueAgeCalculatorTest() throws ParseException {
    }

    @Test
    public void standardInput10302006() throws ParseException {
        final String inputDate = "10/30/2006";
        final int expectedAge = 14;
        runTest(inputDate, expectedAge);
    }

    @Test
    public void standardInput04162009() throws ParseException {
        final String inputDate = "4/16/2009";
        final int expectedAge = 12;
        runTest(inputDate, expectedAge);
    }

    @Test
    public void standardInput0101() throws ParseException {
        final String inputDate = "10/30/2006";
        final int expectedAge = 14;
        runTest(inputDate, expectedAge);
    }

    @Test
    public void standardInput12152016() throws ParseException {
        final String inputDate = "12/15/2016";
        final int expectedAge = 4;
        runTest(inputDate, expectedAge);
    }

    @Test
    public void standardInput08152017() throws ParseException {
        final String inputDate = "08/15/2017";
        final int expectedAge = 4;
        runTest(inputDate, expectedAge);
    }

    @Test
    public void standardInput01152017() throws ParseException {
        final String inputDate = "01/15/2017";
        final int expectedAge = 4;
        runTest(inputDate, expectedAge);
    }

    @Test
    public void standardInput01152016() throws ParseException {
        final String inputDate = "01/15/2016";
        final int expectedAge = 5;
        runTest(inputDate, expectedAge);
    }

    @Test
    public void standardInput01152015() throws ParseException {
        final String inputDate = "01/15/2015";
        final int expectedAge = 6;
        runTest(inputDate, expectedAge);
    }

    @Test
    public void standardInput01152014() throws ParseException {
        final String inputDate = "01/15/2014";
        final int expectedAge = 7;
        runTest(inputDate, expectedAge);
    }

    @Test
    public void standardInput01152013() throws ParseException {
        final String inputDate = "01/15/2013";
        final int expectedAge = 8;
        runTest(inputDate, expectedAge);
    }

    @Test
    public void standardInput01152012() throws ParseException {
        final String inputDate = "01/15/2012";
        final int expectedAge = 9;
        runTest(inputDate, expectedAge);
    }

    @Test
    public void standardInput01152011() throws ParseException {
        final String inputDate = "01/15/2011";
        final int expectedAge = 10;
        runTest(inputDate, expectedAge);
    }

    @Test
    public void standardInput01152010() throws ParseException {
        final String inputDate = "01/15/2010";
        final int expectedAge = 11;
        runTest(inputDate, expectedAge);
    }

    @Test
    public void standardInput01152009() throws ParseException {
        final String inputDate = "01/15/2009";
        final int expectedAge = 12;
        runTest(inputDate, expectedAge);
    }

    @Test
    public void standardInput01152008() throws ParseException {
        final String inputDate = "01/15/2008";
        final int expectedAge = 13;
        runTest(inputDate, expectedAge);
    }

    @Test
    public void standardInput01152007() throws ParseException {
        final String inputDate = "01/15/2007";
        final int expectedAge = 14;
        runTest(inputDate, expectedAge);
    }

    @Test
    public void standardInput01152006() throws ParseException {
        final String inputDate = "01/15/2006";
        final int expectedAge = 15;
        runTest(inputDate, expectedAge);
    }

    @Test
    public void standardInput01152005() throws ParseException {
        final String inputDate = "01/15/2005";
        final int expectedAge = 16;
        runTest(inputDate, expectedAge);
    }

//    @Test
//    public void playerTooOld() throws ParseException {
//        final String inputDate = "01/15/2004";
//
//
//        Exception exception = assertThrows(NumberFormatException.class, () -> {
//            LeagueAgeCalculator.calculateLeagueAge(d(inputDate), REFERENCE_JAN);
//        });
//
//        String expectedMessage = "For input string";
//        String actualMessage = exception.getMessage();
//
//        assertTrue(actualMessage.contains(expectedMessage));
//    }

    private void runTest(String inputDate, int expectedAge) throws ParseException {
        assertEquals(expectedAge, LeagueAgeCalculator.calculateLeagueAge(d(inputDate), REFERENCE_JAN));
        assertEquals(expectedAge, LeagueAgeCalculator.calculateLeagueAge(d(inputDate), REFERENCE_DEC));
    }

    private Date d(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.parse(date);
    }

}
