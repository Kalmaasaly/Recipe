package guru.recipe.controllers;

import guru.recipe.service.RecipeService;
import guru.recipe.service.RecipeServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;



import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by @author Kalmaasali on 06/05/2020.
 **/
public class IndexControllerTest {

    @Mock
    RecipeService recipeService;
    @Mock
    Model model;
    IndexController indexController;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
       indexController=new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() {
        String viewName=indexController.getIndexPage(model);
        assertEquals("index",viewName);
        verify(recipeService,times(1)).getRecipes();
        verify(model,times(1)).addAttribute(eq("recipes"),anySet());
    }
}