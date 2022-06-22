package matsior.api.beer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import matsior.api.style.BeerStyle;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private java.lang.String name;
    private java.lang.String country;
    private Double alcohol;
    private Double blg;
    @ManyToOne
    private BeerStyle beerStyle;
}