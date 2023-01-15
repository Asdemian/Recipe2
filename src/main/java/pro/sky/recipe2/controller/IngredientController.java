package pro.sky.recipe2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipe2.model.Ingredient;
import pro.sky.recipe2.model.Recipe;
import pro.sky.recipe2.service.IngredientService;
import pro.sky.recipe2.service.RecipeService;

import java.util.Map;

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
    public ResponseEntity<Ingredient> get(@PathVariable long id) {
       return ResponseEntity.of(ingredientService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> update(@PathVariable long id,
                             @RequestBody Ingredient ingredient) {
        return ResponseEntity.of(ingredientService.update(id, ingredient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ingredient> delete (@PathVariable long id) {
        return ResponseEntity.of(ingredientService.delete(id));
    }

    @GetMapping
    public Map<Long, Ingredient> getAll() {
        return IngredientService.getAll();
    }

}
