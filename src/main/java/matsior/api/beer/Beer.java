package matsior.api.beer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import matsior.api.producer.Producer;
import matsior.api.style.BeerStyle;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    @ManyToOne(optional = false)
    private Producer producer;
    private String description;
    private String country;
    private Double alcohol;
    private Double blg;
    @ManyToOne(optional = false)
    @JoinColumn(name = "beer_style_id")
    private BeerStyle beerStyle;
}