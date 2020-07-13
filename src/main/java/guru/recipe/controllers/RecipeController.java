package guru.recipe.controllers;

import guru.recipe.commands.RecipeCommand;
import guru.recipe.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by @author Kalmaasali on 14/05/2020.
 **/
@Slf4j
@Controller
public class RecipeController {

    private static final String RECIPE_RECIPEFORM_URL = "recipe/recipeform";
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @RequestMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id,Model model){
        model.addAttribute("recipe",recipeService.findById(new Long(id)));
        return "/recipe/show";
    }
    @RequestMapping("recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe",new RecipeCommand());
        return "recipe/recipeform";
    }
    @RequestMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe",recipeService.findCommandById(Long.valueOf(id)));
        return RECIPE_RECIPEFORM_URL;
    }
    @RequestMapping("recipe")
    public String saveOrUpdateRecipe(@ModelAttribute  RecipeCommand command){
        RecipeCommand saveCommand=recipeService.saveRecipeCommand(command);
        return "redirect:/recipe/show"+saveCommand.getId();
    }
    @GetMapping("recipe/{id}/delete")
    public String deleteById(@PathVariable String id){
        log.debug("Deleting id"+id);
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:";
    }
}
