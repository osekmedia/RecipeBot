package com.osekmedia.recipeBot.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.osekmedia.recipeBot.models.Recipe;
import com.osekmedia.recipeBot.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;
	
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
	
	public Set<Recipe> getRecipes(){
		
		Set<Recipe> recipeSet = new HashSet<>();
		
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
		
		return recipeSet;
	}
	
}
