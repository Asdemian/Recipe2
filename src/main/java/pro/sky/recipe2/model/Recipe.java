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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append("\n").append("\n")
                .append("Время приготовления: ").append(time)
                .append(" минут.").append("\n").append("\n")
                .append("Ингредиенты: ").append("\n").append("\n");
        for (Ingredient ingredient : ingredients) {
            stringBuilder.append("   • ").append(ingredient).append("\n").append("\n");
        }
        stringBuilder.append("Инструкция приготовления: ").append("\n").append("\n");
        int counter = 1;
        for (String cookingInstruction : cookingInstructions) {
            stringBuilder.append("  ").append(counter++).append(". ")
                    .append(cookingInstruction).append("\n");
        }
        return stringBuilder.toString();
    }
}