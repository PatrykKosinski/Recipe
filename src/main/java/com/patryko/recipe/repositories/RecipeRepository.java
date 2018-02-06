package com.patryko.recipe.repositories;

import com.patryko.recipe.domain.Category;
import com.patryko.recipe.domain.Recipe;
import com.patryko.recipe.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{


   // Optional<Recipe> findByCategory(Category category);


}
