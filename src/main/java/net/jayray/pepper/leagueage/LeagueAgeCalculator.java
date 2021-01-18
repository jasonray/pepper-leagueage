package net.jayray.pepper.leagueage;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class LeagueAgeCalculator {

    public static int calculateLeagueAge(Date dob) {
        return calculateLeagueAge(dob, new Date());
    }

    public static int calculateLeagueAge(Date dob, Date referenceDate) {
        //for Little League, league age is the age for that year on Aug 31
        //calculate league age reference as 8/31 of reference year
        //determine years for league age reference

        if (referenceDate == null) {
            return calculateLeagueAge(dob);
        }

        LocalDate birthDateLocalDate = dob.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate referenceDateLocalDate = referenceDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate referenceLeagueAgeLocalDate = LocalDate.of(referenceDateLocalDate.getYear(), 8, 31);

        Number years = ChronoUnit.YEARS.between(birthDateLocalDate, referenceLeagueAgeLocalDate);
        return years.intValue();
    }
}