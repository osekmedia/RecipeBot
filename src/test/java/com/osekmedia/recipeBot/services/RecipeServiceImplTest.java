package com.osekmedia.recipeBot.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.osekmedia.recipeBot.models.Recipe;
import com.osekmedia.recipeBot.repositories.RecipeRepository;


public class RecipeServiceImplTest {
	
	RecipeServiceImpl recipeService;
	
	@Mock
	RecipeRepository recipeRepository;

	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		this.recipeService = new RecipeServiceImpl( recipeRepository );
		
	}

	@Test
	public void getRecipes() {
		
		Recipe recipe = new Recipe();
		HashSet<Recipe> recipesData = new HashSet<>();
		recipesData.add(recipe);
		
		when(recipeService.getRecipes()).thenReturn(recipesData);
		
		Set<Recipe> recipes = recipeService.getRecipes();
		assertEquals( recipes.size(), 1 );
		verify(recipeRepository, times(1)).findAll();
	}

}