package matsior.api.beer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import matsior.api.producer.Producer;
import matsior.api.style.BeerStyle;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name can not be empty")
    @NotNull(message = "Beer must have name")
    @Size(min = 2, max = 50)
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

    @CreatedDate
    private Instant dateAdded;

    @Version
    private Integer version;

    public Beer(
            String name,
            Producer producer,
            String description,
            String country,
            Double alcohol,
            Double blg,
            BeerStyle beerStyle
    ) {
        this.name = name;
        this.producer = producer;
        this.description = description;
        this.country = country;
        this.alcohol = alcohol;
        this.blg = blg;
        this.beerStyle = beerStyle;
    }
}