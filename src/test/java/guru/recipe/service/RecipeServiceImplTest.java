package guru.recipe.service;

import guru.recipe.commands.RecipeCommand;
import guru.recipe.converters.RecipeCommandToRecipe;
import guru.recipe.converters.RecipeToRecipeCommand;
import guru.recipe.domain.Recipe;
import guru.recipe.exceptions.NotFoundException;
import guru.recipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
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
    public void getRecipesTest() throws Exception{

        Recipe recipe=new Recipe();
        Set<Recipe> recipeSet1=new HashSet<>();
        recipeSet1.add(recipe);
        when(recipeService.getRecipes()).thenReturn(recipeSet1);
        Set<Recipe> recipeSet=recipeService.getRecipes();
        assertEquals(recipeSet.size(),1);
        verify(recipeRepository,times(1)).findAll();

    }
    @Test
    public void getRecipeCommandByIdTestNotFound() throws NotFoundException {
        Optional<Recipe>recipeOptional=Optional.empty();

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned=recipeService.findById(1L);

        assertNull(recipeReturned);
    }
    @Test
    public void getRecipeCommandByIdTest() throws Exception{
        Recipe recipe =new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional=Optional.of(recipe);

        when (recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        RecipeCommand commandById=recipeService.findCommandById(1L);

        assertNotNull("Null Recipe Returned");
        verify(recipeRepository,times(1)).findById(anyLong());
        verify(recipeRepository,never()).findAll();
    }


    @Test
    public void testDeleteById() throws Exception{
        //given
        Long idToDelete=Long.valueOf(2L);
        //when
        recipeService.deleteById(idToDelete);
        //then
        verify(recipeRepository,times(1)).
                deleteById(anyLong());
    }

}