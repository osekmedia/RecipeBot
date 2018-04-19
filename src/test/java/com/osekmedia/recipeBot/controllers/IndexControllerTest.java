package com.osekmedia.recipeBot.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.anySet;
import static org.mockito.Mockito.eq;
import org.mockito.ArgumentCaptor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.osekmedia.recipeBot.models.Recipe;
import com.osekmedia.recipeBot.services.RecipeService;


public class IndexControllerTest {
	
	IndexController indexController;
	
	@Mock
	RecipeService recipeService;
	
	@Mock
	Model model;

	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		indexController = new IndexController( this.recipeService );
		
	}

	@Test
	public void testGetIndexPage() {
		
		//given
		HashSet<Recipe> recipes = new HashSet<>();
		
		recipes.add(new Recipe());
		
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		recipes.add(recipe);
		
		when(recipeService.getRecipes()).thenReturn(recipes);
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
		
		//when
		String returnValue = indexController.getIndexPage(model);
		
		//Then
		assertEquals( returnValue, "index" );
		verify( recipeService, times( 1 ) ).getRecipes();
		verify( model, times( 1 ) ).addAttribute( eq("recipes"), argumentCaptor.capture() );
		Set<Recipe> controllerSet = argumentCaptor.getValue();
		assertEquals( 2, controllerSet.size() );
	}

}
