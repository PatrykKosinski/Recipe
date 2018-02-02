package com.patryko.recipe.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //we dont need to specify cascade this because this insatnce we
    //are going to allow the recipe to own this
    @OneToOne
    private Recipe recipe;

    //to allow  our users to put in more then to 255 characters
    //Lob = Large object
    @Lob
    private String recipeNotes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
