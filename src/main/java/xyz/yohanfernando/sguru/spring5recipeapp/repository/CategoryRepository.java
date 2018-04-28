package xyz.yohanfernando.sguru.spring5recipeapp.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.yohanfernando.sguru.spring5recipeapp.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
