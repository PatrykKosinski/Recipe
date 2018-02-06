package com.patryko.recipe.domain;

import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
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

    public Notes() {
    }


    protected boolean canEqual(Object other) {
        return other instanceof Notes;
    }

}
