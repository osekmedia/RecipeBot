package com.osekmedia.recipeBot.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.osekmedia.recipeBot.models.Recipe;
import com.osekmedia.recipeBot.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;
	
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
	
	public Set<Recipe> getRecipes(){
		
		log.debug("In recipe service");
		
		Set<Recipe> recipeSet = new HashSet<>();
		
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
		
		return recipeSet;
	}
	
}
