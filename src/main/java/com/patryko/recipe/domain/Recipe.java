package com.patryko.recipe.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;


    @Lob
    private String directions;


    //it very important to set value. Ordinal is a default, and if we make same changes it will make samoe mess because
    // it numerate position and after same changes index could be also change
    //so we have to choose EnumType.String
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;


    //we specify to cascade this
    //in mappedBy we set the property on child class = ingredient class
    //we can use also use List<> instead of Set<>
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe" )
    private Set<Ingredient> ingredients = new HashSet<>();

    //to big data, Large object
    //asd
    @Lob
    private Byte[] image;

    //cascade mean that recipe is an owner
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;


    @ManyToMany
    @JoinTable(name = "recipie_category",
        joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
        )
    private Set<Category> categories = new HashSet<>();



    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(Ingredient ingredient){
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

}


