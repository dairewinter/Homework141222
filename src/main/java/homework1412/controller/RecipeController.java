package homework1412.controller;

import homework1412.model.Recipe;
import homework1412.service.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/recipes")
@Tag(name = "Рецепты", description = "Операции с рецептами")
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
    @Operation(description = "Добавление рецепта")
    public Recipe addRecipes(@RequestBody Recipe recipe){
        return this.recipeService.addRecipe(recipe);
    }

    @PostMapping(value = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity <Object> addRecipeFromFile(@RequestParam MultipartFile file){
        try(InputStream stream = file.getInputStream()){
            recipeService.addRecipeFromInputStream(stream);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.toString());
        }

    }


    @DeleteMapping("/{id}")
    @Operation(description = "Удаление рецептв")
    public ResponseEntity<Void> deleteRecipe(@PathVariable String id){
        if (recipeService.deleteRecipe(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Operation(description = "Редактирование рецепта")
    public ResponseEntity<Recipe> editRecipe(@PathVariable String id, @RequestBody Recipe recipe) {
        recipe = recipeService.editRecipe(id, recipe);
        if (recipe == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }
}