package guru.recipe.service;

import guru.recipe.commands.RecipeCommand;
import guru.recipe.converters.RecipeCommandToRecipe;
import guru.recipe.converters.RecipeToRecipeCommand;
import guru.recipe.domain.Recipe;
import guru.recipe.repositories.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedNativeQuery;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by @author Kalmaasali on 21/05/2020.
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
class RecipeServiceIT {


    public static final String NEW_DESCRIPTION="new description";
    @Autowired
     RecipeRepository recipeRepository;
    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;
    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;
    @Autowired
    RecipeService recipeService;
    @Transactional
    @Test
    public void testOfDescription() throws Exception {
        //given
        Iterable<Recipe> recipes= recipeRepository.findAll();
        Recipe testRecipe=recipes.iterator().next();
        RecipeCommand testRecipeCommand=recipeToRecipeCommand.convert(testRecipe);
        //when
        testRecipeCommand.setDescription(NEW_DESCRIPTION);
        RecipeCommand saveRecipeCommand=recipeService.saveRecipeCommand(testRecipeCommand);

        //then
        assertEquals(NEW_DESCRIPTION,saveRecipeCommand.getDescription());
        assertEquals(testRecipe.getId(),testRecipeCommand.getId());
        assertEquals(testRecipe.getCategories().size(),testRecipeCommand.getCategories().size());
        assertEquals(testRecipe.getIngredients().size(),testRecipeCommand.getIngredients().size());

    }
}