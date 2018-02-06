package com.patryko.recipe.controllers;

import com.patryko.recipe.domain.Category;
import com.patryko.recipe.domain.Recipe;
import com.patryko.recipe.domain.UnitOfMeasure;
import com.patryko.recipe.repositories.CategoryRepository;
import com.patryko.recipe.repositories.RecipeRepository;
import com.patryko.recipe.repositories.UnitOfMeasureRepository;
import com.patryko.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","index"})
    public String getIndexPage(Model model){

        log.debug("index page here");
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
