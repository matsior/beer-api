package matsior.api.beer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import matsior.api.style.BeerStyle;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String country;
    private Double alcohol;
    private Double blg;
    @ManyToOne
    @JoinColumn(name = "beer_style_id")
    private BeerStyle beerStyle;
}