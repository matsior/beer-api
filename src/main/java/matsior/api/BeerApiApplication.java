package matsior.api;

import matsior.api.beer.Beer;
import matsior.api.beer.dto.BeerDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeerApiApplication.class, args);
    }
}
