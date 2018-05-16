package com.osekmedia.recipeBot.services;

import java.util.Set;

import com.osekmedia.recipeBot.models.Recipe;

public interface RecipeService {
	
	Set<Recipe> getRecipes();
	Recipe findById( Long id );
}
