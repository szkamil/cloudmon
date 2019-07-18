package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger( Application.class );

    public static void main(String args[]) {
        SpringApplication.run( Application.class );
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


    @Bean
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject(
                    "https://gturnquist-quoters.cfapps.io/api/random", Quote.class );
            log.info( quote.toString() );
        };
    }
    @RequestMapping(value = "/fetch")
    public String runUrl() {

        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject( "https://gturnquist-quoters.cfapps.io/api/random", Quote.class );
        log.info( quote.toString() );
        return quote.toString();

    }
}

