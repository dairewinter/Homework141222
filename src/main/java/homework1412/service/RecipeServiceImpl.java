package homework1412.service;

import homework1412.model.Recipe;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
public class RecipeServiceImpl implements RecipeService {
    private final Map<String, Recipe> recipes = new HashMap<>();

    public Recipe addRecipe(Recipe recipe) {
        if (!recipes.containsKey(recipe.getId())) {
            recipes.put(recipe.getId(), recipe);
        }
        return recipe;
    }

    public Recipe getRecipe(String id){
        if ( !StringUtils.isEmpty(id) && recipes.containsKey(id)){
            return recipes.get(id);
        } else {
            throw new ProductNotFoundException();
        }
    }

    public Recipe editRecipe(String id, Recipe recipe){
        if (!StringUtils.isEmpty(id) && recipes.containsKey(id)){
            recipe.setCookingSteps(recipe.getCookingSteps());
            return recipe;
        }
        return null;
    }

    public boolean deleteRecipe(String id){
        if (!StringUtils.isEmpty(id) && recipes.containsKey(id)){
            recipes.remove(id);
            return true;

        }
        return false;
    }

    public Collection<Recipe> getAllRecipes(){
        return recipes.values();
    }
}
