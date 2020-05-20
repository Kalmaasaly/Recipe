package guru.recipe.converters;

import guru.recipe.commands.RecipeCommand;
import guru.recipe.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by @author Kalmaasali on 18/05/2020.
 **/
@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {
    private final CategoryToCategoryCommand categoryConveter;
    private final IngredientToIngredientCommand ingredientConverter;
    private final NotesToNotesCommand notesConverter;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryConveter, IngredientToIngredientCommand ingredientConverter, NotesToNotesCommand notesConverter) {
        this.categoryConveter = categoryConveter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }


    @Override
    public RecipeCommand convert(Recipe source) {
        if(source==null){
            return null;
        }
        RecipeCommand recipe=new RecipeCommand();
        recipe.setId(source.getId());
        recipe.setCookTime(source.getCookTime());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setImage(source.getImage());
        recipe.setDirections(source.getDirections());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setServings(source.getServings());
        recipe.setUrl(source.getUrl());
        recipe.setDescription(source.getDescription());
        recipe.setNotes(notesConverter.convert(source.getNotes()));

        if(source.getCategories() !=null && source.getCategories().size()>0){
            source.getCategories()
                    .forEach(category-> recipe.getCategories().add(categoryConveter.convert(category)));
        }
        if (source.getIngredients()!=null && source.getIngredients().size()>0){
            source.getIngredients()
                    .forEach(ingredient -> recipe.getIngredients()
                            .add(ingredientConverter.convert(ingredient)));
        }

        return recipe;
    }
}
