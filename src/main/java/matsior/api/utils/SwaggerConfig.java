package matsior.api.utils;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Beer API", version = "0.0.1", description = "api providing beer info"))
class SwaggerConfig {
}
