package pro.sky.recipe2.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import pro.sky.recipe2.model.Ingredient;
import pro.sky.recipe2.model.Recipe;

@Service
public class ValidateService {

    public boolean isNotValid(Recipe recipe) {
        boolean result = StringUtils.isBlank(recipe.getName()) ||
                CollectionUtils.isEmpty(recipe.getIngredients()) ||
                CollectionUtils.isEmpty(recipe.getCookingInstructions()) ||
                recipe.getTime() <= 0;
        if (!result) {
                        for (Ingredient ingredient : recipe.getIngredients()) {
                            result = result || isNotValid(ingredient);
            }
        }
        return result;
    }

    public boolean isNotValid(Ingredient ingredient) {
        return StringUtils.isBlank(ingredient.getName()) ||
                StringUtils.isBlank(ingredient.getMeasure()) ||
                ingredient.getQuantity() <= 0;

    }

}
