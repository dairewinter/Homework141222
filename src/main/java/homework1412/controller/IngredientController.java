package homework1412.controller;

import homework1412.model.Ingredient;
import homework1412.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredients(String id){
       Ingredient ingredient = ingredientService.getIngredient(id);
       if (ingredient == null){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(ingredient);
    }

    @GetMapping("/allingredients")
    public Collection<Ingredient> getAll(){
        return this.ingredientService.getAllIngredients();
    }
    @PostMapping("/addingredient")
    public ResponseEntity<Ingredient> addIngredients(@RequestBody Ingredient ingredient){
        Ingredient id = ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable String id){
        if (ingredientService.deleteIngredient(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> editIngredient(@PathVariable String id, @RequestBody Ingredient ingredient) {
        ingredient = ingredientService.editIngredient(id, ingredient);
        if (ingredient == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }
}
