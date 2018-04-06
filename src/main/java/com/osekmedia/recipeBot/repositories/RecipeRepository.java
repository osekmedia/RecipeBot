package com.osekmedia.recipeBot.repositories;

import org.springframework.data.repository.CrudRepository;
import com.osekmedia.recipeBot.models.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
