package com.osekmedia.recipeBot.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
	
	Category category;
	
	@Before
	public void setup() {
		category = new Category();
	}

	@Test
	public void getId() {
		Long id = 4L;
		category.setId(id);
		assertEquals( id, category.getId() );
	}

	@Test
	public void getDescription() {
		//fail("Not yet implemented");
	}

	@Test
	public void getRecipes() {
		//fail("Not yet implemented");
	}

}
