package homework1412.controller;

import homework1412.model.Ingredient;
import homework1412.service.IngredientSerivce;
import homework1412.service.IngredientServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/ingredients")
@Tag(name = "Ингредиенты", description = "Операции с ингредиентами")
public class IngredientController {
    private final IngredientSerivce ingredientService;

    public IngredientController(IngredientServiceImpl ingredientService) {
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

    @PostMapping("/allingredients")
    public Collection<Ingredient> getAll(){
        return this.ingredientService.getAllIngredients();
    }
    @PostMapping()
    @Operation(description = "Добавление ингредиента")
    public ResponseEntity<Ingredient> addIngredients(@RequestBody Ingredient ingredient){
        Ingredient id = ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok(id);
    }
    @DeleteMapping("/{id}")
    @Operation(description = "Удаление ингредиента")
    public ResponseEntity<Void> deleteIngredient(@PathVariable String id){
        if (ingredientService.deleteIngredient(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Operation(description = "Редактирование ингредиента")
    public ResponseEntity<Ingredient> editIngredient(@PathVariable String id, @RequestBody Ingredient ingredient) {
        ingredient = ingredientService.editIngredient(id, ingredient);
        if (ingredient == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }
}
