package pro.sky.recipe2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipe2.model.Recipe;
import pro.sky.recipe2.service.RecipeService;
import pro.sky.recipe2.service.ValidateService;

import java.util.Map;
@Tag(name="РЕЦЕПТЫ controller", description = "API для рецептов")
@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;
    private final ValidateService validateService;

    public RecipeController(RecipeService recipeService,
                            ValidateService validateService) {
        this.validateService = validateService;
        this.recipeService = recipeService;
    }
    @Operation(summary="Добавление рецепта", description = "РЕЦЕПТЫ")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Изменилось"),
            @ApiResponse(responseCode = "400",description = "Облом")
    })
@PostMapping
    public ResponseEntity<Recipe> add(@RequestBody Recipe recipe) {
    if (validateService.isNotValid(recipe)) {
        return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(recipeService.add(recipe));
    }
    @Operation(summary="Получение рецепта", description = "РЕЦЕПТ")
    @GetMapping("{id}")
    public ResponseEntity<Recipe> get(@PathVariable long id) {
        return ResponseEntity.of(recipeService.get(id));
    }
    @Operation(summary="Изменение рецепта", description = "ПРАВКА")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Изменилось"),
            @ApiResponse(responseCode = "400",description = "Облом")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> update(@PathVariable long id,
                                             @RequestBody Recipe recipe) {
        if (validateService.isNotValid(recipe)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.of(recipeService.update(id, recipe));
    }
    @Operation(summary="Удаление рецепта", description = "УДАЛЕНИЕ")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Изменилось"),
            @ApiResponse(responseCode = "400",description = "Облом")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Recipe> delete (@PathVariable long id) {
        return ResponseEntity.of(recipeService.delete(id));
    }
    @Operation(summary="Получение рецептов", description = "РЕЦЕПТЫ")
    @GetMapping
    public Map<Long, Recipe> getAll() {
        return recipeService.getAll();
    }

}
