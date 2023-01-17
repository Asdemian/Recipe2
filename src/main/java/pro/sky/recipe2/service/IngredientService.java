package pro.sky.recipe2.service;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import pro.sky.recipe2.model.Ingredient;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class IngredientService {

    private static final Map<Long, Ingredient> ingredients = new HashMap<>();

    private long idGenerator = 1;


    public Ingredient add(Ingredient ingredient) {
        ingredients.put(idGenerator++, ingredient);
        return  ingredient;
    }

    public Optional<Ingredient> get(long id) {
        return Optional.ofNullable(ingredients.get(id));
    }

    public Optional<Ingredient> update(long id, Ingredient ingredient) {
        return Optional.ofNullable(ingredients.replace(id, ingredient));
    }

    public Optional<Ingredient> delete(long id) {
        return Optional.ofNullable(ingredients.remove(id));
    }

    public static Map<Long, Ingredient> getAll() {
        return new HashMap<>(ingredients);
    }

}