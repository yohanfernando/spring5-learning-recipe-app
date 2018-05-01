package xyz.yohanfernando.sguru.spring5recipeapp.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.yohanfernando.sguru.spring5recipeapp.domain.UnitOfMeasure;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescriptionTeaspoon() {

        Optional<UnitOfMeasure> uomTeaspoonOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon", uomTeaspoonOptional.get().getDescription());
    }

    @Test
    public void findByDescriptionCup() {

        Optional<UnitOfMeasure> uomTeaspoonOptional = unitOfMeasureRepository.findByDescription("Cup");

        assertEquals("Cup", uomTeaspoonOptional.get().getDescription());
    }
}