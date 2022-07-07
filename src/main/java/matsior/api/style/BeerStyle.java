package matsior.api.style;

import lombok.*;
import matsior.api.beer.Beer;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BeerStyle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "beerStyle")
    private List<Beer> beers;

    public BeerStyle(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
