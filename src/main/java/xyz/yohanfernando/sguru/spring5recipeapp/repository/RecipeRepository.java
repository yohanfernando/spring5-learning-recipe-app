package xyz.yohanfernando.sguru.spring5recipeapp.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.yohanfernando.sguru.spring5recipeapp.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
