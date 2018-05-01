package xyz.yohanfernando.sguru.spring5recipeapp.services;

import xyz.yohanfernando.sguru.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

}
