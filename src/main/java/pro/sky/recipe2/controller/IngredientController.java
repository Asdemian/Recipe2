package pro.sky.recipe2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipe2.model.Ingredient;
import pro.sky.recipe2.service.IngredientService;
import pro.sky.recipe2.service.ValidateService;

import java.util.Map;
@Tag(name="ИНГРЕДИЕНТЫ controller", description = "API для ингредиентов")
@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;
    private final ValidateService validateService;

    public IngredientController(IngredientService ingredientService,
                                ValidateService validateService) {
        this.ingredientService = ingredientService;
        this.validateService = validateService;
    }
    @Operation(summary="Добавление ингредиента", description = "ДОБАВЛЕНИЕ")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Изменилось"),
            @ApiResponse(responseCode = "400",description = "Облом")
    })
    @PostMapping
    public ResponseEntity<Ingredient> add(@RequestBody Ingredient ingredient) {
        if (!validateService.isNotValid(ingredient)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ingredientService.add(ingredient));
    }
    @Operation(summary="Получение ингредиента", description = "ИНГРЕДИЕНТЫ")
    @GetMapping("{id}")
    public ResponseEntity<Ingredient> get(@PathVariable long id) {
        return ResponseEntity.of(ingredientService.get(id));
    }
    @Operation(summary="Изменение ингредиента", description = "ИЗМЕНЕНИЕ")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Изменилось"),
            @ApiResponse(responseCode = "400",description = "Облом")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> update(@PathVariable long id,
                                             @RequestBody Ingredient ingredient) {
        if (!validateService.isNotValid(ingredient)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.of(ingredientService.update(id, ingredient));
    }
    @Operation(summary="Удаление ингредиента", description = "УДАЛЕНИЕ")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Изменилось"),
            @ApiResponse(responseCode = "400",description = "Облом")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Ingredient> delete(@PathVariable long id) {
        return ResponseEntity.of(ingredientService.delete(id));
    }
    @Operation(summary="Получение ингредиента", description = "ИНГРЕДИЕНТЫ")
    @GetMapping
    public Map<Long, Ingredient> getAll() {
        return IngredientService.getAll();
    }

}
