package matsior.api;

import matsior.api.beer.Beer;
import matsior.api.beer.BeerDto;
import matsior.api.style.BeerStyle;
import matsior.api.style.BeerStyleDto;
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

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Beer, BeerDto>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
                map().setName(source.getName());
                map().setCountry(source.getCountry());
                map().setAlcohol(source.getAlcohol());
                map().setBlg(source.getBlg());
                map().setBeerStyle(source.getBeerStyle().getName());
            }
        });

        modelMapper.addMappings(new PropertyMap<BeerStyle, BeerStyleDto>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
                map().setName(source.getName());
                map().setDescription(source.getDescription());
            }
        });
        return modelMapper;
    }
}
