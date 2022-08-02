package matsior.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class BeerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeerApiApplication.class, args);
    }
}

// TODO write additional tests
// TODO add additional validation
