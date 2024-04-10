package com.Spring.boot.student;


//Create our own constructors
//normal getter methods that are created (ex: getFirstName()),
// instead they are simply denoted by the name of the field (ex: firstName()).
//Create static fields

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "FirstName should not be empty")
        String firstname,
                         @NotEmpty(message = "LastName should not be empty")
                         String lastName,
                         String email,
                         Integer schoolId) {
}
