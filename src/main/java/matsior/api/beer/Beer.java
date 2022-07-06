package matsior.api.beer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import matsior.api.producer.Producer;
import matsior.api.style.BeerStyle;

import javax.persistence.*;
import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Beer {

    private static final Instant CURRENT_INSTANT = Instant.now();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(optional = false)
    private Producer producer;
    private String description;
    private String country;
    private Double alcohol;
    private Double blg;
    @ManyToOne(optional = false)
    @JoinColumn(name = "beer_style_id")
    private BeerStyle beerStyle;
    private Instant dateAdded;

    public Beer(String name,
                Producer producer,
                String description,
                String country,
                Double alcohol,
                Double blg,
                BeerStyle beerStyle) {
        this.name = name;
        this.producer = producer;
        this.description = description;
        this.country = country;
        this.alcohol = alcohol;
        this.blg = blg;
        this.beerStyle = beerStyle;
        this.dateAdded = CURRENT_INSTANT;
    }
}