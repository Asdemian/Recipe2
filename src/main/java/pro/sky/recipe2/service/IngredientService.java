package pro.sky.recipe2.service;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import pro.sky.recipe2.model.Ingredient;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientService {

    private final Map<Long, Ingredient> ingredients = new HashMap<>();

    private long idGenerator = 1;

    public Ingredient add(Ingredient ingredient) {
        ingredients.put(idGenerator++, ingredient);
        return ingredient;
    }
@Nullable
    public Ingredient get(long id) {
        return ingredients.get(id);
    }
}
