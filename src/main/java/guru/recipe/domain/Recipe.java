package guru.recipe.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by @author Kalmaasali on 29/04/2020.
 **/
@Data
//@EqualsAndHashCode(exclude = {"notes","categories"})
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer services;
    private Integer source;
    private String url;
    @Lob
    private String directions;
    @Lob
    private Byte[] image;
    /*@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "recipe")*/
    @OneToOne(cascade=CascadeType.ALL)
    private Notes notes;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "recipe")
    private Set<Ingredient> ingredients=new HashSet<>();

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @ManyToMany
    @JoinTable(name = "recipe_category",
    joinColumns=@JoinColumn(name="recipe_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories=new HashSet<>();


    public Recipe() {

    }
    public Recipe(Long id) {
        this.id=id;
    }
    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredients(Ingredient ingredient){
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }


}
