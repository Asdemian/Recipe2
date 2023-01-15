package pro.sky.recipe2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Recipe {
    private String name;
    private String time;

    private String quantity;
    private List<Ingredient> ingredients;
    private List<String> cookingInstructions;

    public Recipe() {
    }

    public Recipe(String name, String time, String quantity,
                  List<Ingredient> ingredients, List<String> cookingInstructions) {
        this.name = name;
        this.time = time;
        this.quantity = quantity;
        this.ingredients = ingredients;
        this.cookingInstructions = cookingInstructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getCookingInstructions() {
        return cookingInstructions;
    }

    public void setCookingInstructions(List<String> cookingInstructions) {
        this.cookingInstructions = cookingInstructions;
    }
}