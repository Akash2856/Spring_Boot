package com.Spring.boot;

import org.springframework.web.bind.annotation.*;

@RestController
public class FiirstController {

//    @GetMapping("/hello")
//    public String sayHello(){
//        return "hello Akash padai chal rhi hai!!!!";
//    }
    @PostMapping("/post")
    public String post(
            @RequestBody String message){
        return "Request accepted "+message;
    }
    @PostMapping("/post-order")
    public String post(
            @RequestBody Order order){
        return "Request accepted "+order.toString();
    }

    @GetMapping("/hello/{userName}")
    public String sayHello(
            @PathVariable String userName
    ){
        return "user name "+userName;
    }
    @GetMapping("/hello")
    public String paramVar(
            @RequestParam("user-name") String userName,
            @RequestParam("user-lastname") String userLastName
    ){
        return "user name "+userName+" "+ userLastName;
    }
}
