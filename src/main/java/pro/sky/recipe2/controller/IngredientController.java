package pro.sky.recipe2.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.recipe2.model.Ingredient;
import pro.sky.recipe2.model.Recipe;
import pro.sky.recipe2.service.IngredientService;
import pro.sky.recipe2.service.RecipeService;
@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    @PostMapping
    public Ingredient add(@RequestBody Ingredient ingredient) {
        return ingredientService.add(ingredient);
    }

    @GetMapping("{id}")
    public Ingredient get(@PathVariable long id) {
        return ingredientService.get(id);
    }

}
