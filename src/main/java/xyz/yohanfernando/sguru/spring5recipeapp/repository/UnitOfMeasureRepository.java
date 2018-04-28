package xyz.yohanfernando.sguru.spring5recipeapp.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.yohanfernando.sguru.spring5recipeapp.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);

}
