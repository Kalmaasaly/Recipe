package guru.recipe.bootstrap;

import guru.recipe.domain.*;
import guru.recipe.repositories.CategoryRepository;
import guru.recipe.repositories.RecipeRepository;
import guru.recipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by @author Kalmaasali on 01/05/2020.
 **/
@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository,
                           UnitOfMeasureRepository unitOfMeasureRepository,
                           RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;

    }

    private List<Recipe> getRecipes(){
        log.debug("I'm List Recipe....");
        List<Recipe> recipes=new ArrayList<>(2);

        //get UOM

        Optional<UnitOfMeasure> eachUomOptional=unitOfMeasureRepository.findByDescription("Each");
        if (!eachUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not found");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional=unitOfMeasureRepository.findByDescription("Tablespoon");
        if (!tableSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not found");
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional=unitOfMeasureRepository.findByDescription("Teaspoon");
        if (!teaSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not found");
        }

        Optional<UnitOfMeasure> dashUomOptional=unitOfMeasureRepository.findByDescription("Dash");
        if (!dashUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not found");
        }
        Optional<UnitOfMeasure> pintUomOptional=unitOfMeasureRepository.findByDescription("Pint");
        if (!pintUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not found");
        }
        Optional<UnitOfMeasure> cupUomOptional=unitOfMeasureRepository.findByDescription("Cup");
        if (!cupUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not found");
        }

        //get Optional
        UnitOfMeasure each = eachUomOptional.get();
        UnitOfMeasure tableSpoon = tableSpoonUomOptional.get();
        UnitOfMeasure teaSpoon = teaSpoonUomOptional.get();
        UnitOfMeasure dash = dashUomOptional.get();
        UnitOfMeasure pint = pintUomOptional.get();
        UnitOfMeasure cup = cupUomOptional.get();

        //get Categories

        Optional<Category> americanCategoryOptional=categoryRepository.findByDescription("American");
        if (!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not found");
        }

        Optional<Category> mexicanCategoryOptional=categoryRepository.findByDescription("Mexican");
        if (!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not found");
        }
        Category americanCategory= americanCategoryOptional.get();
        Category mexicanCategory=   mexicanCategoryOptional.get();

        //Yummy Guac
        Recipe guacRecipe=new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n");
        Notes guacNotes=new Notes();

        guacNotes.setRecipeNote("Once you have basic guacamole down, feel free to experiment with variations including strawberries, peaches, pineapple, mangoes, even watermelon. One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). You can get creative with homemade guacamole!\n" +
                "\n" +
                "    Simple Guacamole: The simplest version of guacamole is just mashed avocados with salt. Don’t let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "    Quick guacamole: For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "    Don’t have enough avocados? To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "Read More: https://www.simplyrecipes.com/recipes/perfect_guacamole/");


        guacRecipe.setNotes(guacNotes);
        //guacNotes.setRecipe(guacRecipe);



        guacRecipe.getIngredients().add(new Ingredient("ripe avocados",new BigDecimal(2),each,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("salt",new BigDecimal(0.25),teaSpoon,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("cilantro (leaves and tender stems), finely chopped",
                new BigDecimal(2),tableSpoon,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("freshly grated black pepper",new BigDecimal(2),dash,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("serrano chiles, stems and seeds removed, minced",new BigDecimal(2),each,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("ripe tomato, seeds and pulp removed, chopped",new BigDecimal(0.5),each,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("fresh lime juice or lemon juice",new BigDecimal(1),tableSpoon,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("minced red onion or thinly sliced green onion",new BigDecimal(2),tableSpoon,guacRecipe));

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);

        recipes.add(guacRecipe);

        return recipes;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
        log.debug("Loading bootstrap data");
    }
}
