package homework1412.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private String ingredientName;
    private int amountOfIngredient;
    private String measure;
    private String id;

}
