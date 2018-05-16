package com.osekmedia.recipeBot.services;

import java.util.HashSet;
import java.util.Optional;
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

    @Override
	public Set<Recipe> getRecipes(){
		
		log.debug("In recipe service");
		
		Set<Recipe> recipeSet = new HashSet<>();
		
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
		
		return recipeSet;
	}

	@Override
	public Recipe findById( Long id ){

		Optional<Recipe> recipeOptional = recipeRepository.findById( id );

		if(!recipeOptional.isPresent()){
			throw new RuntimeException("Recipe not found");
		}

		return recipeOptional.get();
	}
}
