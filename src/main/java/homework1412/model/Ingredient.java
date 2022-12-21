package homework1412.model;

public class Ingredient {
    private final String ingredientName;
    private int amountOfIngredient;
    private String measure;
    private String id;

    public Ingredient(String ingredientName, int amountOfIngredient, String measure) {
        this.ingredientName = ingredientName;
        this.amountOfIngredient = amountOfIngredient;
        this.measure = measure;
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public int getAmountOfIngredient() {
        return amountOfIngredient;
    }

    public String getMeasure() {
        return measure;
    }

    public String getId(){
        return id;
    }

    public void setAmountOfIngredient(int amountOfIngredient) {
        this.amountOfIngredient = amountOfIngredient;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public void setId(String id) {
        this.id = id;
    }
}
