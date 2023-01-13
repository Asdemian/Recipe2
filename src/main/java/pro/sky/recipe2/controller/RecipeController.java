package pro.sky.recipe2.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.recipe2.model.Recipe;
import pro.sky.recipe2.service.RecipeService;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
@PostMapping
    public Recipe add(@RequestBody Recipe recipe) {
    return recipeService.add(recipe);
    }

    @GetMapping("{id}")
    public Recipe get(@PathVariable long id) {
        return recipeService.get(id);
    }

}
