package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@RestController*///restful service hadanna gannawa(Resource Oriented applications)
@Controller//@Controller is used for traditional MVC controllers(Monolithic applications)
@RequestMapping("/hello")
public class HelloController {
/*
    public HelloController() {
        System.out.println("HelloController");
    }
*/


    @GetMapping("/index")//@GetMapping is a shortcut for @RequestMapping(method = RequestMethod.GET)
    public String/*void*/ index() {
        /*return "Hello index!";*/
        return "index";//meeka set wenne gihin suffix ekata issarhin

    }

    @GetMapping("/jsp")
    public String index2() {
        return "customer";

    }

   /* @GetMapping("one")
    public String hello() {
        return "Hello, hello!";
    }

    @GetMapping("two")
    public String test() {
        return "Hello test1";
    }*/


}
