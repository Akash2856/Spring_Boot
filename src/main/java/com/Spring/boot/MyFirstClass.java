package com.Spring.boot;

import org.springframework.stereotype.Controller;

@Controller
public class MyFirstClass {
    private String myVar;
    public MyFirstClass(String myVar){
        this.myVar=myVar;
    }
    public String sayhello(){

        return "Hello from the My class = "+myVar;
    }
}
