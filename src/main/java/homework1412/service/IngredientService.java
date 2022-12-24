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
        if (!ingredients.containsKey(ingredient.getId())) {
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

    public Ingredient editIngredient(String id, Ingredient ingredient){
        if (ingredients.containsKey(id)){
            ingredient.setMeasure(ingredient.getMeasure());
            return ingredients.get(id);

        }
        return null;
    }

    public Collection<Ingredient> getAllIngredients(){
        return ingredients.values();
    }

    public boolean deleteIngredient(String id){
        if (ingredients.containsKey(id)){
            ingredients.remove(id);
            return true;
        }
        return false;
    }

}
