package matsior.api.style;

public class BeerStyleMapper {
    static BeerStyleDto map(BeerStyle beerStyle) {
        return new BeerStyleDto(
                beerStyle.getId(),
                beerStyle.getName(),
                beerStyle.getDescription()
        );
    }
}
