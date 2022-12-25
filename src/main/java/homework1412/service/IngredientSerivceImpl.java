package homework1412.service;

import homework1412.model.Ingredient;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

public interface IngredientSerivceImpl {

    public Ingredient addIngredient(Ingredient ingredient);
    public Ingredient getIngredient(String id);

    public Ingredient editIngredient(String id, Ingredient ingredient);

    public Collection<Ingredient> getAllIngredients();

    public boolean deleteIngredient(String id);
}
