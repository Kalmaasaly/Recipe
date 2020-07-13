package guru.recipe.service;

import guru.recipe.commands.RecipeCommand;
import guru.recipe.converters.RecipeCommandToRecipe;
import guru.recipe.converters.RecipeToRecipeCommand;
import guru.recipe.domain.Recipe;
import guru.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by @author Kalmaasali on 01/05/2020.
 **/
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.info("I'm in the service");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> recipe= recipeRepository.findById(id);
        if(!recipe.isPresent()){
            throw new RuntimeException("Recipe Not found ");
        }
        return recipe.orElse(null);
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {
        Recipe detachedRecipe=recipeCommandToRecipe.convert(recipeCommand);
        Recipe saveRecipe=recipeRepository.save(detachedRecipe);
        log.debug("Saved Recipe"+saveRecipe.getId());
        return recipeToRecipeCommand.convert(saveRecipe);
    }

    @Override
    public RecipeCommand findCommandById(Long l) {
        return recipeToRecipeCommand.convert(findById(l));
    }

    @Override
    public void deleteById(Long idToDelete) {
        recipeRepository.deleteById(idToDelete);

    }
}
