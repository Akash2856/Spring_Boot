package com.Spring.boot;


//Create our own constructors
//normal getter methods that are created (ex: getFirstName()),
// instead they are simply denoted by the name of the field (ex: firstName()).
//Create static fields

public record StudentDto(String firstname,
                         String lastName,
                         String email,
                         Integer schoolId) {
}
