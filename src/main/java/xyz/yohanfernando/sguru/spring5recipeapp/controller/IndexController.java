package xyz.yohanfernando.sguru.spring5recipeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.yohanfernando.sguru.spring5recipeapp.services.RecipeService;

import java.util.Date;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        System.out.println("Loading index page @ " + new Date());

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
