package homework1412.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Recipe {
    private final String recipeName;
    private final int cookingTime;
    private List <Ingredient> ingredients;
    private List<String> cookingSteps;
    private String id;

}
