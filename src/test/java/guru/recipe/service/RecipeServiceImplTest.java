package guru.recipe.service;

import guru.recipe.converters.RecipeCommandToRecipe;
import guru.recipe.converters.RecipeToRecipeCommand;
import guru.recipe.domain.Recipe;
import guru.recipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;



/**
 * Created by @author Kalmaasali on 06/05/2020.
 **/
public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;
    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        recipeService=new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }
    @Test
    public void getRecipes() throws Exception{

        Recipe recipe=new Recipe();
        Set<Recipe> recipeSet1=new HashSet<>();
        recipeSet1.add(recipe);
        when(recipeService.getRecipes()).thenReturn(recipeSet1);
        Set<Recipe> recipeSet=recipeService.getRecipes();
        assertEquals(recipeSet.size(),1);
        verify(recipeRepository,times(1)).findAll();

    }

}