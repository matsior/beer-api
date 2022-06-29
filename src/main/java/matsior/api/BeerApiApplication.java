package matsior.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Beer API", version = "0.0.1", description = "api providing beer info"))
public class BeerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeerApiApplication.class, args);
    }
}
