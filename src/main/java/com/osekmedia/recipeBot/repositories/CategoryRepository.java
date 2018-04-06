package com.osekmedia.recipeBot.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.osekmedia.recipeBot.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	Optional<Category> findByDescription( String description );
	
}
