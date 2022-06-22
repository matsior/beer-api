package matsior.api.beer;

public record BeerDto (String name,
                       String country,
                       String style,
                       Double alcohol,
                       Double blg){
}
