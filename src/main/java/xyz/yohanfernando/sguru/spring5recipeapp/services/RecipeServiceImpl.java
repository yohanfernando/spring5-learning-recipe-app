package xyz.yohanfernando.sguru.spring5recipeapp.services;

import org.springframework.stereotype.Service;
import xyz.yohanfernando.sguru.spring5recipeapp.domain.Recipe;
import xyz.yohanfernando.sguru.spring5recipeapp.repository.RecipeRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}
