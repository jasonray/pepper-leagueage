package integration.test;

import net.jayray.pepper.leagueage.LeagueAgeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class ApiContext<P> {
    public UriComponentsBuilder requestUriBuilder;
    public ResponseEntity<P> response;

    private final Logger logger = LoggerFactory.getLogger(ApiContext.class);

    private final String DEFAULT_URI_HOST = "localhost";
    private final String DEFAULT_URI_PORT = "9080";

    public ApiContext() {
        logger.trace("init context");
        initRequestUriBuilder();
    }

    private void initRequestUriBuilder() {
        logger.trace("init requestUriBuilder");
        this.requestUriBuilder = UriComponentsBuilder.newInstance().scheme("http").host(DEFAULT_URI_HOST).port(DEFAULT_URI_PORT);
    }

    public ResponseEntity<P> executeGetRequest(Class<P> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        this.response = restTemplate.getForEntity(this.requestUriBuilder.build().toUriString(), responseType);
        return this.response;
    }
}
