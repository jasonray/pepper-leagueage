package net.jayray.pepper.leagueage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/")
    public String index(@RequestParam Optional<String> name) {
        logger.debug("Hello Controller invoked");

        String greeting;
        if (isValid(name)) {
            greeting = "hello " + name.get() + "!";
        } else {
            greeting = "hello world!";
        }

        return greeting;
    }

    private boolean isValid(Optional<String> value) {
        boolean valid;
        if (value.isPresent()) {
            valid = (value.get().trim().length() > 0);
        } else {
            valid = false;
        }
        return valid;
    }

}
