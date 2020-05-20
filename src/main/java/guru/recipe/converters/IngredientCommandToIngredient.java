package guru.recipe.converters;

import guru.recipe.commands.IngredientCommand;
import guru.recipe.domain.Ingredient;
import guru.recipe.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by @author Kalmaasali on 18/05/2020.
 **/
@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand,Ingredient> {
    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }


    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
       if(source==null){
           return null;
       }
       final Ingredient ingredient=new Ingredient();
       ingredient.setId(source.getId());
       ingredient.setDescription(source.getDescription());
       ingredient.setAmount(source.getAmount());
       ingredient.setUom(uomConverter.convert(source.getUom()));
        if (source.getRecipeId()!=null){
            Recipe recipe = new Recipe();
            recipe.setId(source.getRecipeId());
            ingredient.setRecipe(recipe);
            recipe.addIngredients(ingredient);
        }
        return ingredient;
    }
}
