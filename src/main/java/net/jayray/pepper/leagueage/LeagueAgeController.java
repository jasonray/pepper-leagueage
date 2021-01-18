package net.jayray.pepper.leagueage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@RestController
public class LeagueAgeController {

    private final Logger logger = LoggerFactory.getLogger(LeagueAgeController.class);

    @GetMapping("/league-age")
    public ResponseEntity calculateLeagueAge(@RequestParam(name = "dob") Optional<String> dob, @RequestParam(name = "reference", required = false) Optional<String> reference) {
        logger.debug("calculate league age invoked");

        Date dobDate;
        if (dob.isPresent()) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            try {
                dobDate = sdf.parse(dob.get());
            } catch (ParseException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid dob (MM/dd/yyyy format) " + dob);
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("dob is required");
        }

        Date referenceDate;
        if (reference.isPresent()) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            try {
                referenceDate = sdf.parse(reference.get());
            } catch (ParseException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid reference (MM/dd/yyyy format) " + reference);
            }
        } else {
            referenceDate = null;
        }

        int leagueAge = LeagueAgeCalculator.calculateLeagueAge(dobDate, referenceDate);
        return ResponseEntity.status(HttpStatus.OK).body(leagueAge);
    }
}
