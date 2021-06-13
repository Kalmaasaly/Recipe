package guru.recipe.controllers;

import guru.recipe.commands.RecipeCommand;
import guru.recipe.domain.Recipe;
import guru.recipe.exceptions.NotFoundException;
import guru.recipe.repositories.RecipeRepository;
import guru.recipe.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by @author Kalmaasali on 14/05/2020.
 **/
class RecipeControllerTest {

    @Mock
    RecipeService recipeService;

    RecipeController recipeController;
    MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeController=new RecipeController(recipeService);

        mockMvc = MockMvcBuilders.standaloneSetup(recipeController)
                .setControllerAdvice(new ControllerExceptionHandler())
                .build();
    }

    /*@Test
    void showById() throws Exception {
        Recipe recipe=new Recipe();
        recipe.setId(1L);
        mockMvc= MockMvcBuilders.standaloneSetup(recipeController).build();

     when(recipeService.findById(anyLong())).thenReturn(recipe);
     mockMvc.perform(get("/recipe/show/1"))
             .andExpect(status().isOk())
             .andExpect(view().name("/recipe/show/1"));
    }*/

    @Test
    void  testGetNewRecipeForm() throws  Exception {

        RecipeCommand command=new RecipeCommand();
        mockMvc.perform(get("/recipe/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/recipeform"))
                .andExpect(model().attributeExists("recipe"));
    }
   /* @Test
    public void testGetRecipeNotFound() throws Exception {

        when(recipeService.findById(anyLong())).thenThrow(NotFoundException.class);

        mockMvc.perform(get("/recipe/2/show"))
                .andExpect(status().isNotFound())
                .andExpect(view().name("404error"));
    }*/
    @Test
    void updateRecipe() {
    }

    @Test
    void saveOrUpdateRecipe() {
    }

}