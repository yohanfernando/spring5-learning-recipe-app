package xyz.yohanfernando.sguru.spring5recipeapp.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import xyz.yohanfernando.sguru.spring5recipeapp.domain.*;
import xyz.yohanfernando.sguru.spring5recipeapp.repository.CategoryRepository;
import xyz.yohanfernando.sguru.spring5recipeapp.repository.RecipeRepository;
import xyz.yohanfernando.sguru.spring5recipeapp.repository.UnitOfMeasureRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;


    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("Bootstrapping teh application with default data @ " + new Date());

        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {

        List<Recipe> recipes = new ArrayList<>(2);


        Optional<UnitOfMeasure> uomEachOptional = unitOfMeasureRepository.findByDescription("Each");
        if (!uomEachOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not found");
        }

        Optional<UnitOfMeasure> uomTablespoonOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        if (!uomTablespoonOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not found");
        }

        Optional<UnitOfMeasure> uomTeaspoonOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if (!uomTeaspoonOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not found");
        }

        Optional<UnitOfMeasure> uomDashOptional = unitOfMeasureRepository.findByDescription("Dash");
        if (!uomDashOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not found");
        }

        Optional<UnitOfMeasure> uomPintOptional = unitOfMeasureRepository.findByDescription("Pint");
        if (!uomPintOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not found");
        }

        Optional<UnitOfMeasure> uomCupOptional = unitOfMeasureRepository.findByDescription("Cup");
        if (!uomCupOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not found");
        }

        UnitOfMeasure uomEach = uomEachOptional.get();
        UnitOfMeasure uomTablespoon = uomTablespoonOptional.get();
        UnitOfMeasure uomTeaspoon = uomTeaspoonOptional.get();
        UnitOfMeasure uomDash = uomDashOptional.get();
        UnitOfMeasure uomPint = uomPintOptional.get();
        UnitOfMeasure uomCup = uomCupOptional.get();


        Optional<Category> americanOptionalCategory = categoryRepository.findByDescription("American");
        if (!americanOptionalCategory.isPresent()) {
            throw new RuntimeException("Expected Category Not found");
        }

        Optional<Category> mexicanOptionalCategory = categoryRepository.findByDescription("Mexican");
        if (!mexicanOptionalCategory.isPresent()) {
            throw new RuntimeException("Expected Category Not found");
        }

        Category americanCategory = americanOptionalCategory.get();
        Category mexicanCategory = mexicanOptionalCategory.get();


        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(30);
        guacRecipe.setCookTime(0);
        guacRecipe.setServings(4);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setSource("Simply Recipes");
        guacRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                                 "\n" +
                                 "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                                 "\n" +
                                 "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown. Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness. Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                                 "\n" +
                                 "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                                 "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n");

        Notes guacNotes = new Notes();
        guacNotes.setNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                           "\n" +
                           "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                           "\n" +
                           "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                           "\n" +
                           "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.");
        guacRecipe.setNotes(guacNotes);

        guacRecipe.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), uomEach));
        guacRecipe.addIngredient(new Ingredient("Kosher salt", new BigDecimal(.5), uomTeaspoon));
        guacRecipe.addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1), uomTablespoon));
        guacRecipe.addIngredient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), uomTablespoon));
        guacRecipe.addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), uomEach));
        guacRecipe.addIngredient(new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), uomTablespoon));
        guacRecipe.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(1), uomDash));
        guacRecipe.addIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(.5), uomEach));

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);

        recipes.add(guacRecipe);


        Recipe tacoRecipe = new Recipe();
        tacoRecipe.setDescription("Spicy Grilled Chicken Tacos");
        tacoRecipe.setPrepTime(20);
        tacoRecipe.setCookTime(15);
        tacoRecipe.setServings(6);
        tacoRecipe.setSource("Simply Recipes");
        tacoRecipe.setDifficulty(Difficulty.MODERATE);
        tacoRecipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        tacoRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                                 "\n" +
                                 "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                                 "\n" +
                                 "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                                 "\n" +
                                 "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                                 "\n" +
                                 "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                                 "\n" +
                                 "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                                 "\n" +
                                 "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");

        Notes tacoNotes = new Notes();
        tacoNotes.setNotes("Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)");
        tacoRecipe.setNotes(tacoNotes);

        tacoRecipe.addIngredient(new Ingredient("ancho chili powder", new BigDecimal(2), uomTablespoon));
        tacoRecipe.addIngredient(new Ingredient("dried oregano", new BigDecimal(1), uomTeaspoon));
        tacoRecipe.addIngredient(new Ingredient("dried cumin", new BigDecimal(1), uomTeaspoon));
        tacoRecipe.addIngredient(new Ingredient("sugar", new BigDecimal(1), uomTeaspoon));
        tacoRecipe.addIngredient(new Ingredient("salt", new BigDecimal(.5), uomTeaspoon));
        tacoRecipe.addIngredient(new Ingredient("garlic clove, finely chopped", new BigDecimal(1), uomEach));
        tacoRecipe.addIngredient(new Ingredient("finely grated orange zest", new BigDecimal(1), uomTablespoon));
        tacoRecipe.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), uomTablespoon));
        tacoRecipe.addIngredient(new Ingredient("olive oil", new BigDecimal(2), uomTablespoon));
        tacoRecipe.addIngredient(new Ingredient("skinless, boneless chicken thighs (1 1/4 pounds)", new BigDecimal(6), uomEach));
        tacoRecipe.addIngredient(new Ingredient("small corn tortillas", new BigDecimal(8), uomEach));
        tacoRecipe.addIngredient(new Ingredient("packed baby arugula (3 ounces)", new BigDecimal(3), uomCup));
        tacoRecipe.addIngredient(new Ingredient("medium ripe avocados, sliced", new BigDecimal(2), uomEach));
        tacoRecipe.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4), uomEach));
        tacoRecipe.addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(.5), uomPint));
        tacoRecipe.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(.25), uomEach));
        tacoRecipe.addIngredient(new Ingredient("Roughly chopped cilantro", new BigDecimal(1), uomEach));
        tacoRecipe.addIngredient(new Ingredient("sour cream thinned with 1/4 cup milk", new BigDecimal(.5), uomCup));
        tacoRecipe.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(1), uomEach));

        tacoRecipe.getCategories().add(americanCategory);
        tacoRecipe.getCategories().add(mexicanCategory);

        recipes.add(tacoRecipe);


        return recipes;
    }
}
