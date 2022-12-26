package homework1412.service;

import homework1412.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface IngredientSerivce {

    public Ingredient addIngredient(Ingredient ingredient);
    public Ingredient getIngredient(String id);

    public Ingredient editIngredient(String id, Ingredient ingredient);

    public Collection<Ingredient> getAllIngredients();

    public boolean deleteIngredient(String id);
}
