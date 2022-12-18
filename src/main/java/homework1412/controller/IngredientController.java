package homework1412.controller;

import homework1412.model.Ingredient;
import homework1412.service.IngredientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    @GetMapping()
    public Ingredient getIngredients(){
        return this.ingredientService.getIngredient(getIngredients().getId());
    }

    @PostMapping("/ingredients/addingredient")
    public Ingredient addIngredients(@RequestBody Ingredient ingredient){
        return this.ingredientService.addIngredient(ingredient);
    }
}
