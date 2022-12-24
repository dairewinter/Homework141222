package homework1412.controller;

import homework1412.model.Ingredient;
import homework1412.model.Recipe;
import homework1412.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}")
    public Recipe getRecipe(){
        return this.recipeService.getRecipe(getRecipe().getId());
    }

    @PostMapping()
    public Recipe addRecipes(@RequestBody Recipe recipe){
        return this.recipeService.addRecipe(recipe);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable String id){
        if (recipeService.deleteRecipe(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> editRecipe(@PathVariable String id, @RequestBody Recipe recipe) {
        recipe = recipeService.editRecipe(id, recipe);
        if (recipe == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

}