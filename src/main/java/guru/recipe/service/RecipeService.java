package guru.recipe.service;

import guru.recipe.domain.Recipe;

import java.util.Set;

/**
 * Created by @author Kalmaasali on 01/05/2020.
 **/
public interface RecipeService {
    Set<Recipe> getRecipes();
}