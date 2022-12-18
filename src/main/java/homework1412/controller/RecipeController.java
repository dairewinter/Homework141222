package homework1412.controller;

import homework1412.model.Recipe;
import homework1412.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping()
    public Recipe getRecipe(){
        return this.recipeService.getRecipe(getRecipe().getId());
    }

    @PostMapping("/ingredients/addingredient")
    public Recipe addRecipes(@RequestBody Recipe recipe){
        return this.recipeService.addRecipe(recipe);
    }
}