package guru.recipe.controllers;

import guru.recipe.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by @author Kalmaasali on 25/04/2020.
 **/
@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        log.debug("indexController.....");
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){
       // log.debug("getIndexPage.....");
        model.addAttribute("recipes",recipeService.getRecipes());

        return "index";
    }
}
