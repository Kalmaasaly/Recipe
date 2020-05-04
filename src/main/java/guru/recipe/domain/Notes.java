package guru.recipe.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Created by @author Kalmaasali on 29/04/2020.
 **/
@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Recipe recipe;
    @Lob
    private String recipeNote;

}
