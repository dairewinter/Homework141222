package homework1412.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import homework1412.model.Ingredient;
import homework1412.model.Recipe;
import homework1412.service.IngredientFilesService;
import homework1412.service.IngredientService;
import homework1412.service.exceptions.ProductNotFoundException;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class IngredientServiceImpl implements IngredientService {
    final private IngredientFilesService ingredientFilesService;
    private final Map<String, Ingredient> ingredients = new HashMap<>();

    public IngredientServiceImpl(IngredientFilesService ingredientFilesService) {
        this.ingredientFilesService = ingredientFilesService;
    }

    @PostConstruct
    private void init(){
        readFromFile();
    }

    public Ingredient addIngredient(Ingredient ingredient) {
        if (!ingredients.containsKey(ingredient.getId())) {
            ingredients.put(ingredient.getId(), ingredient);
        }
        saveToFile();
        return ingredient;
    }

    public Ingredient getIngredient(String id){
        if (!StringUtils.isEmpty(id) && ingredients.containsKey(id)){
            return ingredients.get(id);
        } else {
        throw new ProductNotFoundException();
        }
    }

    public Ingredient editIngredient(String id, Ingredient ingredient){
        if (!StringUtils.isEmpty(id) && ingredients.containsKey(id)){
            ingredient.setMeasure(ingredient.getMeasure());
            return ingredients.get(id);
        }
        saveToFile();
        return null;
    }

    public Collection<Ingredient> getAllIngredients(){
        return ingredients.values();
    }

    public boolean deleteIngredient(String id){
        if (!StringUtils.isEmpty(id) && ingredients.containsKey(id)){
            ingredients.remove(id);
            return true;
        }
        return false;
    }

    private void saveToFile(){
        try {
            String json = new ObjectMapper().writeValueAsString(ingredients);
            ingredientFilesService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFile(){
        String json = ingredientFilesService.readFromFile();
        try {
            new ObjectMapper().readValue(json, new TypeReference<HashMap<String, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
