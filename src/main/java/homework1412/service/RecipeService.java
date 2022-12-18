package homework1412.service;

import homework1412.model.Ingredient;
import homework1412.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class RecipeService {
    private final Map<String, Recipe> recipes = new HashMap<>();

    public Recipe addRecipe(Recipe recipe) {
        if (recipes.containsKey(recipe.getId())) {
            throw new RuntimeException("Такой рецепт уже существует!");
        } else {
            recipes.put(recipe.getId(), recipe);
        }
        return recipe;
    }

    public Recipe getRecipe(String id){
        if (recipes.containsKey(id)){
            return recipes.get(id);
        } else {
            throw new RuntimeException("Ингредиент не найден");
        }
    }
}
