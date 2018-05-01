package xyz.yohanfernando.sguru.spring5recipeapp.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.yohanfernando.sguru.spring5recipeapp.domain.Recipe;
import xyz.yohanfernando.sguru.spring5recipeapp.repository.RecipeRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("Running RecipeService.getRecipes() to get all recipes @ " + new Date());

        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long id) {

        Optional<Recipe> byId = recipeRepository.findById(id);

        if (!byId.isPresent()) {
            throw new RuntimeException("Recipe not found!");
        }

        return byId.get();
    }
}
