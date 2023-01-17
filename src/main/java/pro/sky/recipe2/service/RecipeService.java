package pro.sky.recipe2.service;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import pro.sky.recipe2.model.Recipe;
import pro.sky.recipe2.model.Recipe;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class RecipeService {

    private final Map<Long, Recipe> recipes = new HashMap<>();
    private long idGenerator = 1;

    public Recipe add(Recipe recipe) {
        recipes.put(idGenerator++, recipe);
        return recipe;
    }
    public Optional<Recipe> get(long id) {
        return Optional.ofNullable(recipes.get(id));
    }

    public Optional<Recipe> update(long id, Recipe recipe) {
        return Optional.ofNullable(recipes.replace(id, recipe));
    }

    public Optional<Recipe> delete(long id) {
        return Optional.ofNullable(recipes.remove(id));
    }

    public Map<Long, Recipe> getAll() {
        return new HashMap<>(recipes);
    }
}
