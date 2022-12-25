package homework1412.service;


import homework1412.model.Recipe;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

public interface RecipeServiceImpl {
    public Recipe addRecipe(Recipe recipe);

    public Recipe getRecipe(String id);

    public Recipe editRecipe(String id, Recipe recipe);

    public boolean deleteRecipe(String id);

    public Collection<Recipe> getAllRecipes();
}
