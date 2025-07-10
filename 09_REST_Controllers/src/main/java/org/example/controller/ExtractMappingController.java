package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api")
@RestController
public class ExtractMappingController {
    //2
    //api
    @GetMapping
    public String hello() {
        return "Hello World";
    }

    //api/hello
    @GetMapping("hello")
    public String hello2() {
        return "Hello World-2";
    }

    //api/hello/three
    @GetMapping("hello/three")
    public String hello3() {
        return "Hello World-3";
    }

    //api/hello/three/four
    @GetMapping("hello/three/four")
    public String hello4() {
        return "Hello World-4";
    }
}
