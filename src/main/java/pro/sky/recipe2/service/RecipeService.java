package pro.sky.recipe2.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import pro.sky.recipe2.model.Recipe;
import pro.sky.recipe2.model.Recipe;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class RecipeService {

    private final Map<Long, Recipe> recipes = new HashMap<>();
    private final Path pathToFile;
    private final ObjectMapper objectMapper;

    private long idGenerator = 1;

    public RecipeService(@Value("${application.path.to.recipes}") String path) {
        this.pathToFile = Paths.get(path);
        this.objectMapper = new ObjectMapper();
    }

    @PostConstruct
    public void init() {
        try {
            Map<Long, Recipe> fromFile = objectMapper.readValue(Files.readAllBytes(pathToFile),
                    new TypeReference<>() {
                    });
            recipes.putAll(fromFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile() {
        try {
            byte[] data = objectMapper.writeValueAsBytes(recipes);
            Files.write(pathToFile, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Recipe add(Recipe recipe) {
        recipes.put(idGenerator++, recipe);
        writeToFile();
        return recipe;
    }

    public Optional<Recipe> get(long id) {
        return Optional.ofNullable(recipes.get(id));
    }

    public Optional<Recipe> update(long id, Recipe recipe) {
       Optional<Recipe> result = Optional.ofNullable(recipes.replace(id, recipe));
       writeToFile();
        return result;
    }

    public Optional<Recipe> delete(long id) {
        Optional<Recipe> result = Optional.ofNullable(recipes.remove(id));
        writeToFile();
        return result;
    }

    public Map<Long, Recipe> getAll() {
        return new HashMap<>(recipes);
    }
}
