package homework1412.service;


import homework1412.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface RecipeService {
    public Recipe addRecipe(Recipe recipe);

    public Recipe getRecipe(String id);

    public Recipe editRecipe(String id, Recipe recipe);

    public boolean deleteRecipe(String id);

    public Collection<Recipe> getAllRecipes();
}
