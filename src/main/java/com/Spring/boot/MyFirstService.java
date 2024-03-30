package com.Spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private final MyFirstClass myFirstClass;

    public MyFirstService(MyFirstClass myFirstClass){
        this.myFirstClass=myFirstClass;
    }

    public String tellStory(){
        return "In service class "+myFirstClass.sayhello();
    }
}
