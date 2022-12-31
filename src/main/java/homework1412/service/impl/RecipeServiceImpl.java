package homework1412.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import homework1412.model.Recipe;
import homework1412.service.RecipeFileService;
import homework1412.service.RecipeService;
import homework1412.service.exceptions.ProductNotFoundException;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.*;

public class RecipeServiceImpl implements RecipeService {
    final private RecipeFileService recipeFileService;
    private final Map<String, Recipe> recipes = new HashMap<>();

    public RecipeServiceImpl(RecipeFileService recipeFileService) {
        this.recipeFileService = recipeFileService;
    }

    public Recipe addRecipe(Recipe recipe) {
        if (!recipes.containsKey(recipe.getId())) {
            recipes.put(recipe.getId(), recipe);
        }
        saveToFile();
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
            saveToFile();
            return recipe;
        }
        saveToFile();
        return null;
    }

    @PostConstruct
    private void init(){
        try {
            readFromFile();
        } catch (Exception e){
            e.printStackTrace();
        }

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

    private void saveToFile(){
        try {
            String json = new ObjectMapper().writeValueAsString(recipes);
            recipeFileService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFile(){
        String json = recipeFileService.readFromFile();
        try {
            new ObjectMapper().readValue(json, new TypeReference<HashMap<String, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addRecipeFromInputStream(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
            String line;
            while((line = reader.readLine()) != null){
                String[] array = StringUtils.split(line, '|');
                Recipe recipe = new Recipe(String.valueOf(array[0]), Integer.valueOf(array[1]), List.of(array[2]), List.of(array[3]), String.valueOf(array[4]));
                addRecipe(recipe);
            }

        }
    }
}
