package guru.recipe.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Created by @author Kalmaasali on 30/04/2020.
 **/
@Data
@Entity
public class UnitOfMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    /*@OneToOne
    private Ingredient ingredient;*/

    /*   public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }*/
}
