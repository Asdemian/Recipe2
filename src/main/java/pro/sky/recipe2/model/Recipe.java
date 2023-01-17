package pro.sky.recipe2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    private String name;
    private int time;

    private String quantity;
    private List<Ingredient> ingredients;
    private List<String> cookingInstructions;


}