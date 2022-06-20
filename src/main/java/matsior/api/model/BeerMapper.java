package matsior.api.model;

public class BeerMapper {
    public static BeerDto map(Beer beer) {
        return new BeerDto(
                beer.getName(),
                beer.getCountry(),
                beer.getStyle().getName(),
                beer.getAlcohol(),
                beer.getBlg()
        );
    }
}
