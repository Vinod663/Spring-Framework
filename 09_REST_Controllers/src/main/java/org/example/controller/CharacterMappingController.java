package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("char")
public class CharacterMappingController {
    //3
    //char/item/Iabc
    //char/item/I123
    //char/item/I@@@

    //char/item/i@@@---> Not Worked
    //char/item/i1234---> Not Worked
    @GetMapping("item/I???")
    public String sayHello() {
        return "Say Hello!";
    }


    @GetMapping("????/search")
    public String hello() {
        return "Hello!";
    }
}
