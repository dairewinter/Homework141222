package homework1412.service;

import homework1412.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientService {
    private final Map<String, Ingredient> ingredients = new HashMap<>();

    public Ingredient addIngredient(Ingredient ingredient) {
        if (ingredients.containsKey(ingredient.getId())) {
            throw new RuntimeException("Такой ингредиент уже существует!");
        } else {
            ingredients.put(ingredient.getId(), ingredient);
        }
        return ingredient;
    }

    public Ingredient getIngredient(String id){
        if (ingredients.containsKey(id)){
            return ingredients.get(id);
        } else {
        throw new RuntimeException("Ингредиент не найден");
        }
    }

    public Collection<Ingredient> getAllIngredients(){
        return ingredients.values();
    }

}
