package homework1412.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {
    private final String ingredientName;
    private int amountOfIngredient;
    private String measure;
    private String id;

}
