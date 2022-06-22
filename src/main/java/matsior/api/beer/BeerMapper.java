package matsior.api.beer;

public class BeerMapper {
    public static BeerDto map(Beer beer) {
        return new BeerDto(
                beer.getId(),
                beer.getName(),
                beer.getCountry(),
                beer.getAlcohol(),
                beer.getBlg(),
                beer.getBeerStyle().getName()
        );
    }
}
