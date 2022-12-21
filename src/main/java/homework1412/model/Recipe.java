package homework1412.model;

import java.util.List;

public class Recipe {
    private final String recipeName;
    private final int cookingTime;
    private List <Ingredient> ingredients;
    private List<String> cookingSteps;
    private String id;

    public Recipe(String recipeName, int cookingTime, List<Ingredient> ingredients, List<String> cookingSteps) {
        this.recipeName = recipeName;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
        this.cookingSteps = cookingSteps;
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<String> getCookingSteps() {
        return cookingSteps;
    }

    public String getId() {
        return id;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setCookingSteps(List<String> cookingSteps) {
        this.cookingSteps = cookingSteps;
    }
}
